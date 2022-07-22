/**
 * Copyright (c) 2012 - 2018 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.gecko.smartmodels.ecore;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.gecko.smartmodels.apis.ecore.EcoreSmartModelGenerator;
import org.gecko.smartmodels.apis.yaml.YamlReader;
import org.gecko.smartmodels.ecore.helper.ECoreGeneratorHelper;
import org.gecko.smartmodels.geojson.model.geojson.GeojsonPackage;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(name = "EcoreSmartModelGenerator")
public class EcoreSmartModelGeneratorImpl implements EcoreSmartModelGenerator {

	@Reference
	private ResourceSet resourceSet;

	@Reference
	private YamlReader yamlReader;
	
	@Reference
	GeojsonPackage geojsonPackage;


	public static final String ECORE_URL_PREFIX = "http://smartmodels.com/";
	public static final String ECORE_URL_VERSION = "/1.0";
	

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.smartmodels.apis.ecore.EcoreSmartModelGenerator#generateEcoreSmartModel(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void generateEcoreSmartModel(String pathToYamlInputFile, String pathToEcoreOutputFile) {

		Map<String, Object> yamlContent = yamlReader.getYamlContent(pathToYamlInputFile);
		String mainObjectName = yamlContent.keySet().stream().findFirst().orElse(null);
		if(mainObjectName == null) {
			throw new IllegalArgumentException("No main object found in yaml file! Cannot continue...");
		}
		String ecoreModelName = mainObjectName.substring(0,1).toLowerCase() + mainObjectName.substring(1);
		final EPackage mainEcorePackage = ECoreGeneratorHelper.createPackage(ecoreModelName, ecoreModelName, ECORE_URL_PREFIX+ecoreModelName+ECORE_URL_VERSION);
		final EClass mainEcoreClass = ECoreGeneratorHelper.createEClass(mainObjectName);
		mainEcorePackage.getEClassifiers().add(mainEcoreClass);

		convertYamlContent((Map<String, Object>) yamlContent.get(mainObjectName), mainEcoreClass, mainEcorePackage);		

		saveEcoreModel(pathToEcoreOutputFile, mainEcorePackage);
	}

	@SuppressWarnings("unchecked")
	private void convertYamlContent(Map<String, Object> yamlContent, EClass eClass, EPackage mainEPackage) {

		ECoreGeneratorHelper.addDocumentation(eClass, extractElementDescription(yamlContent));
		List<String> requiredProperties = extractRequiredProperties(yamlContent);

		if(yamlContent.containsKey(YamlReader.YAML_PROPERTIES_KEY)) {

			Map<String, Object> propertiesMap = (Map<String, Object>) yamlContent.get(YamlReader.YAML_PROPERTIES_KEY);
			propertiesMap.forEach((k, v) -> {
				Map<String, Object> valueMap = (Map<String, Object>) v;
				int lowerBound = requiredProperties.contains(k) ? 1 : 0;
				int upperBound = 1;
				if(valueMap.containsKey(YamlReader.YAML_TYPE_KEY)) {
					String propertyType = (String) valueMap.get(YamlReader.YAML_TYPE_KEY);
					doConvertProperty(k, propertyType, valueMap, lowerBound, upperBound, eClass, mainEPackage);						
				}
				else if(valueMap.containsKey(YamlReader.YAML_ANYOF_KEY)) {
					extractMultipleTypes(k, (List<Map<String, Object>>) valueMap.get(YamlReader.YAML_ANYOF_KEY), lowerBound, upperBound, eClass, mainEPackage, extractElementDescription(valueMap));
				}
				else if(valueMap.containsKey(YamlReader.YAML_ONEOF_KEY)) {
					if(valueMap.containsKey(YamlReader.YAML_XNGSI_KEY)) {
						Map<String, Object> xngsiMap = (Map<String, Object>) valueMap.get(YamlReader.YAML_XNGSI_KEY);
						if(xngsiMap.containsKey(YamlReader.YAML_TYPE_KEY)) {
							if(YamlReader.YAML_XGSI_TYPE_GEOPROPERTY.equals(xngsiMap.get(YamlReader.YAML_TYPE_KEY))) {
								System.out.println("Found GeoProperty for " + k);
//								Resource jsonRes = resourceSet.getResource(URI.createFileURI(System.getProperty("base.path")+"/../org.gecko.smartmodels.geojson.model/model/geojson.ecore"), true); 
//								EPackage jsonPack = (EPackage) jsonRes.getContents().get(0);
								ECoreGeneratorHelper.addReference(eClass, k, geojsonPackage.getEClassifier("Geometry"), lowerBound, upperBound, extractElementDescription(valueMap), true);
							}
						}
					}
					extractMultipleTypes(k, (List<Map<String, Object>>) valueMap.get(YamlReader.YAML_ONEOF_KEY), lowerBound, upperBound, eClass, mainEPackage, extractElementDescription(valueMap));

				}
			});
		}
		else {
			throw new RuntimeException("No properties map found in yaml file! " + yamlContent);
		}
	} 
	
	@SuppressWarnings("unchecked")
	private void extractMultipleTypes(String propertyName, List<Map<String, Object> > possibleValuesList, int lowerBound, int upperBound, EClass mainEcoreClass, EPackage mainEcorePackage, String description) {
		List<String> possibleTypes = possibleValuesList.stream().filter(m -> m.containsKey(YamlReader.YAML_TYPE_KEY))
				.map(m -> (String) m.get(YamlReader.YAML_TYPE_KEY)).distinct().collect(Collectors.toList());
		List<String> possibleAnyOfTypes = possibleValuesList.stream().filter(m -> m.containsKey(YamlReader.YAML_ANYOF_KEY))
				.map(m -> (List<Map<String, Object> >) m.get(YamlReader.YAML_ANYOF_KEY)).flatMap(l -> l.stream()).filter(m -> m.containsKey(YamlReader.YAML_TYPE_KEY))
				.map(m -> (String) m.get(YamlReader.YAML_TYPE_KEY)).distinct().collect(Collectors.toList());
		List<String> possibleOneOfTypes = possibleValuesList.stream().filter(m -> m.containsKey(YamlReader.YAML_ONEOF_KEY))
				.map(m -> (List<Map<String, Object> >) m.get(YamlReader.YAML_ONEOF_KEY)).flatMap(l -> l.stream()).filter(m -> m.containsKey(YamlReader.YAML_TYPE_KEY))
				.map(m -> (String) m.get(YamlReader.YAML_TYPE_KEY)).distinct().collect(Collectors.toList());
		possibleTypes.addAll(possibleAnyOfTypes);
		possibleTypes.addAll(possibleOneOfTypes);
		possibleTypes = possibleTypes.stream().distinct().collect(Collectors.toList());
		
//		Case: all the possible types are actually the same
		if(possibleTypes.size() == 1) {
			String propertyType = possibleTypes.get(0);
			switch(propertyType) {
			case YamlReader.YAML_STRING_TYPE:
				ECoreGeneratorHelper
				.addAttribute(mainEcoreClass, propertyName, EcorePackage.Literals.ESTRING, false, lowerBound, upperBound, description);
				break;
			case YamlReader.YAML_INTEGER_TYPE:
				ECoreGeneratorHelper
				.addAttribute(mainEcoreClass, propertyName, EcorePackage.Literals.EINTEGER_OBJECT, false, lowerBound, upperBound, description);
				break;
			case YamlReader.YAML_NUMBER_TYPE:
				ECoreGeneratorHelper
				.addAttribute(mainEcoreClass, propertyName, EcorePackage.Literals.EDOUBLE_OBJECT, false, lowerBound, upperBound, description);
				break;
			case YamlReader.YAML_ARRAY_TYPE:
//				TODO: if all the possible types are array we have to check what can be inside each array...
				break;
			case YamlReader.YAML_OBJECT_TYPE:
//				TODO: if all the possible types are object we have to check which kind of object they are. We can set the ref to a general 
//				      EObject, and then add an annotation with the possible actual objects they might be
			}
		}
/*		TODO add support in case multiple types are found:
			 We can have different cases here:
			 	1. A simple object and a complex object (a String and an Address)
			 	2. A simple object and an array of simple objects (a String and an array of String)
			 	3. Multiple different simple objects (a String and an Integer)
*/		
	}

	@SuppressWarnings("unchecked")
	private void doConvertProperty(String propertyName, String propertyType, Map<String, Object> propertyValueMap, int lowerBound, int upperBound, EClass mainEcoreClass, EPackage mainEcorePackage) {

		String propertyDescription = extractElementDescription(propertyValueMap);
		switch(propertyType) {
		case YamlReader.YAML_STRING_TYPE:	
			if(propertyValueMap.containsKey(YamlReader.YAML_ENUM_KEY)) {
				EEnum eEnum = ECoreGeneratorHelper.createEEnum(mainEcoreClass.getName(), propertyName, (List<String>) propertyValueMap.get(YamlReader.YAML_ENUM_KEY));
				mainEcorePackage.getEClassifiers().add(eEnum);
				ECoreGeneratorHelper.addAttribute(mainEcoreClass, propertyName, eEnum, false, lowerBound, upperBound, propertyDescription);
			}
			else {
				ECoreGeneratorHelper
				.addAttribute(mainEcoreClass, propertyName, EcorePackage.Literals.ESTRING, false, lowerBound, upperBound, propertyDescription);
			}
			break;
		case YamlReader.YAML_OBJECT_TYPE:
			EClass secondaryEClass = ECoreGeneratorHelper.createEClass(propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1));
			mainEcorePackage.getEClassifiers().add(secondaryEClass);
			ECoreGeneratorHelper.addReference(mainEcoreClass, propertyName, secondaryEClass, lowerBound, upperBound, propertyDescription, true);
			convertYamlContent(propertyValueMap, secondaryEClass, mainEcorePackage);
			break;
		case YamlReader.YAML_INTEGER_TYPE:
			ECoreGeneratorHelper
			.addAttribute(mainEcoreClass, propertyName, EcorePackage.Literals.EINTEGER_OBJECT, false, lowerBound, upperBound, propertyDescription);
			break;
		case YamlReader.YAML_NUMBER_TYPE: 
			ECoreGeneratorHelper
			.addAttribute(mainEcoreClass, propertyName, EcorePackage.Literals.EDOUBLE_OBJECT, false, lowerBound, upperBound, propertyDescription);
			break;
		case YamlReader.YAML_ARRAY_TYPE:
			treatArray(propertyName, propertyValueMap, mainEcoreClass, mainEcorePackage, propertyDescription);
			break;
		}
	}
	
	@SuppressWarnings("unchecked")
	private void treatArray(String propertyName, Map<String, Object> propertyValueMap, EClass mainEcoreClass, EPackage mainEcorePackage, String propertyDescription) {
		int lowerBound = 0;
		int upperBound = -1;
		if(propertyValueMap.containsKey(YamlReader.YAML_MIN_ITEMS_KEY)) {
			lowerBound = (Integer) propertyValueMap.get(YamlReader.YAML_MIN_ITEMS_KEY);
		}
		if(propertyValueMap.containsKey(YamlReader.YAML_MAX_ITEMS_KEY)) {
			upperBound = (Integer) propertyValueMap.get(YamlReader.YAML_MAX_ITEMS_KEY);
		}
		if(propertyValueMap.containsKey(YamlReader.YAML_ITEMS_KEY)) {
			Map<String, Object> itemsMap = (Map<String, Object>) propertyValueMap.get(YamlReader.YAML_ITEMS_KEY);
			if(itemsMap.containsKey(YamlReader.YAML_TYPE_KEY)) {
				String itemsType = (String) itemsMap.get(YamlReader.YAML_TYPE_KEY);
				doConvertProperty(propertyName, itemsType, itemsMap, lowerBound, upperBound, mainEcoreClass, mainEcorePackage);
			}
			else if(itemsMap.containsKey(YamlReader.YAML_ANYOF_KEY)) {
				extractMultipleTypes(propertyName, (List<Map<String, Object>>) itemsMap.get(YamlReader.YAML_ANYOF_KEY), lowerBound, upperBound, mainEcoreClass, mainEcorePackage, propertyDescription);
			}
			else if(itemsMap.containsKey(YamlReader.YAML_ONEOF_KEY)) {
				extractMultipleTypes(propertyName, (List<Map<String, Object>>) itemsMap.get(YamlReader.YAML_ONEOF_KEY), lowerBound, upperBound, mainEcoreClass, mainEcorePackage, propertyDescription);
			}
		}
	}

//	@SuppressWarnings("unchecked")
//	private EEnum generateEEnum(EClass mainEcoreClass, EPackage mainEcorePackage, Map<String, Object> yamlContent, String enumName) {
//		EEnum eEnum = ECoreGeneratorHelper.createEEnum(mainEcoreClass.getName(), enumName, (List<String>) yamlContent.get(YamlReader.YAML_ENUM_KEY));
//		mainEcorePackage.getEClassifiers().add(eEnum);
//		return eEnum;
//	}

	private String extractElementDescription(Map<String, Object> yamlContent) {
		String description = null;
		if(yamlContent.containsKey(YamlReader.YAML_DESCRIPTION_KEY)) {
			description = (String) yamlContent.get(YamlReader.YAML_DESCRIPTION_KEY);
		}
		return description;
	}

	@SuppressWarnings("unchecked")
	private List<String> extractRequiredProperties(Map<String, Object> yamlContent) {
		List<String> requiredProperties = new LinkedList<>();
		if(yamlContent.containsKey(YamlReader.YAML_REQUIRED_KEY)) {
			requiredProperties.addAll((Collection<? extends String>) yamlContent.get(YamlReader.YAML_REQUIRED_KEY));
		}
		return requiredProperties;
	}


	private void saveEcoreModel(String pathToEcoreOutputFile, EPackage mainEcorePackage) {
		try {
			Resource outputRes = resourceSet.createResource(URI.createFileURI(pathToEcoreOutputFile));
			outputRes.getContents().add(mainEcorePackage);
			outputRes.save(Collections.emptyMap());
		} catch(IOException e) {
			throw new RuntimeException("Error saving ecore model " + e);
		}		
	}
}
