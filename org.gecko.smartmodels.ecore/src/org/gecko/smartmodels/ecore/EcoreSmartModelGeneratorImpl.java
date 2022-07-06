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

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
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
import org.emfjson.jackson.databind.EMFContext;
import org.gecko.smartmodels.apis.ecore.EcoreSmartModelGenerator;
import org.gecko.smartmodels.apis.yaml.YamlReader;
import org.gecko.smartmodels.building.model.building.Building;
import org.gecko.smartmodels.building.model.building.BuildingFactory;
import org.gecko.smartmodels.ecore.helper.ECoreGeneratorHelper;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(name = "EcoreSmartModelGenerator")
public class EcoreSmartModelGeneratorImpl implements EcoreSmartModelGenerator {

	@Reference
	private ComponentServiceObjects<ResourceSet> resourceSetFactory;
	
	@Reference
	BuildingFactory buildingFactory;

	@Reference
	private YamlReader yamlReader;

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
		String ecoreModelName = mainObjectName.toLowerCase();
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
				if(valueMap.containsKey(YamlReader.YAML_TYPE_KEY)) {
					String propertyType = (String) valueMap.get(YamlReader.YAML_TYPE_KEY);
					int lowerBound = requiredProperties.contains(k) ? 1 : 0;
					int upperBound = 1;
					doConvertProperty(k, propertyType, valueMap, lowerBound, upperBound, eClass, mainEPackage);						
				}
				else if(valueMap.containsKey(YamlReader.YAML_ANYOF_KEY)) {
//					System.out.println("AnyOf: " + k);
//					System.out.println("AnyOf: " + valueMap.get(YamlReader.YAML_ANYOF_KEY));
					int lowerBound = requiredProperties.contains(k) ? 1 : 0;
					int upperBound = 1;
					extractAnyOf(k, (List<Map<String, Object>>) valueMap.get(YamlReader.YAML_ANYOF_KEY), lowerBound, upperBound, eClass, mainEPackage, extractElementDescription(valueMap));
				}
				else if(valueMap.containsKey(YamlReader.YAML_ONEOF_KEY)) {
//					TODO add support for oneOf attributes
//					System.out.println("OneOf: " + k);
//					System.out.println("AnyOf: " + valueMap.get(YamlReader.YAML_ONEOF_KEY));
				}
			});
		}
		else {
			throw new RuntimeException("No properties map found in yaml file! " + yamlContent);
		}
	} 
	
	@SuppressWarnings("unchecked")
	private void extractAnyOf(String propertyName, List<Map<String, Object> > possibleValuesList, int lowerBound, int upperBound, EClass mainEcoreClass, EPackage mainEcorePackage, String description) {
		List<String> possibleTypes = possibleValuesList.stream().filter(m -> m.containsKey(YamlReader.YAML_TYPE_KEY))
				.map(m -> (String) m.get(YamlReader.YAML_TYPE_KEY)).distinct().collect(Collectors.toList());
		List<String> possibleAnyOfTypes = possibleValuesList.stream().filter(m -> m.containsKey(YamlReader.YAML_ANYOF_KEY))
				.map(m -> (List<Map<String, Object> >) m.get(YamlReader.YAML_ANYOF_KEY)).flatMap(l -> l.stream()).filter(m -> m.containsKey(YamlReader.YAML_TYPE_KEY))
				.map(m -> (String) m.get(YamlReader.YAML_TYPE_KEY)).distinct().collect(Collectors.toList());
		possibleTypes.addAll(possibleAnyOfTypes);
		possibleTypes = possibleTypes.stream().distinct().collect(Collectors.toList());
		if(possibleTypes.size() == 1) {
//			System.out.println("Only one type for " + propertyName + ": " + possibleTypes.get(0));
			String propertyType = possibleTypes.get(0);
			switch(propertyType) {
			case YamlReader.YAML_STRING_TYPE:
				ECoreGeneratorHelper
				.addAttribute(mainEcoreClass, propertyName, EcorePackage.Literals.ESTRING, false, lowerBound, upperBound, description);
			}
//			TODO add support for other types
		}
//		TODO add support in case multiple types are found
		
	}

	@SuppressWarnings("unchecked")
	private void doConvertProperty(String propertyName, String propertyType, Map<String, Object> propertyValueMap, int lowerBound, int upperBound, EClass mainEcoreClass, EPackage mainEcorePackage) {

		String propertyDescription = extractElementDescription(propertyValueMap);
		switch(propertyType) {
		case YamlReader.YAML_STRING_TYPE:	
			if(propertyValueMap.containsKey(YamlReader.YAML_ENUM_KEY)) {
				EEnum eEnum = generateEEnum(mainEcorePackage, propertyValueMap, propertyName);
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
			if(propertyValueMap.containsKey(YamlReader.YAML_MIN_ITEMS_KEY)) {
				lowerBound = (Integer) propertyValueMap.get(YamlReader.YAML_MIN_ITEMS_KEY);
			}
			if(propertyValueMap.containsKey(YamlReader.YAML_MAX_ITEMS_KEY)) {
				upperBound = (Integer) propertyValueMap.get(YamlReader.YAML_MAX_ITEMS_KEY);
			} else {
				upperBound = -1;
			}
			if(propertyValueMap.containsKey(YamlReader.YAML_ITEMS_KEY)) {
				Map<String, Object> itemsMap = (Map<String, Object>) propertyValueMap.get(YamlReader.YAML_ITEMS_KEY);
				if(itemsMap.containsKey(YamlReader.YAML_TYPE_KEY)) {
					String itemsType = (String) itemsMap.get(YamlReader.YAML_TYPE_KEY);
					doConvertProperty(propertyName, itemsType, itemsMap, lowerBound, upperBound, mainEcoreClass, mainEcorePackage);
				}
				else if(itemsMap.containsKey(YamlReader.YAML_ANYOF_KEY)) {
//					System.out.println("Items AnyOf: " + propertyName);					
					extractAnyOf(propertyName, (List<Map<String, Object>>) itemsMap.get(YamlReader.YAML_ANYOF_KEY), lowerBound, upperBound, mainEcoreClass, mainEcorePackage, propertyDescription);
				}
				else if(itemsMap.containsKey(YamlReader.YAML_ONEOF_KEY)) {
//					System.out.println("Items OneOf: " + propertyName);
//					System.out.println("Items OneOf: " + itemsMap.get(YamlReader.YAML_ONEOF_KEY));
					extractAnyOf(propertyName, (List<Map<String, Object>>) itemsMap.get(YamlReader.YAML_ONEOF_KEY), lowerBound, upperBound, mainEcoreClass, mainEcorePackage, propertyDescription);
				}
			}
			break;
		}
	}

	@SuppressWarnings("unchecked")
	private EEnum generateEEnum(EPackage mainEcorePackage, Map<String, Object> yamlContent, String enumName) {
		enumName = enumName.substring(0, 1).toUpperCase() + enumName.substring(1)+"Value";
		EEnum eEnum = ECoreGeneratorHelper.createEEnum(enumName, (List<String>) yamlContent.get(YamlReader.YAML_ENUM_KEY));
		mainEcorePackage.getEClassifiers().add(eEnum);
		return eEnum;
	}

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
			ResourceSet resourceSet = resourceSetFactory.getService();
			Resource outputRes = resourceSet.createResource(URI.createFileURI(pathToEcoreOutputFile));
			outputRes.getContents().add(mainEcorePackage);
			outputRes.save(Collections.emptyMap());
		} catch(IOException e) {
			throw new RuntimeException("Error saving ecore model " + e);
		}		
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.smartmodels.apis.ecore.EcoreSmartModelGenerator#createConcreteEObject(java.lang.String)
	 */
	@Override
	public void createConcreteEObject(String pathToJsonInputFile) {
		
		File f = new File(pathToJsonInputFile);
		if(f.exists()) {
			System.out.println("File Found");
		} else {
			System.out.println("File not found");
		}
		ResourceSet resourceSet = resourceSetFactory.getService();
		Resource inRes = resourceSet.createResource(URI.createFileURI(pathToJsonInputFile));
		try {		
			Map<Object, Object> loadOptions = new HashMap<Object, Object>();
			loadOptions.put(EMFContext.Attributes.ROOT_ELEMENT, buildingFactory.getBuildingPackage().getBuilding());
			inRes.load(loadOptions);
			if(inRes.getContents() != null && inRes.getContents().size() > 0) {
				if(inRes.getContents().get(0) instanceof Building) {
					System.out.println("OK!!");
					Building building = (Building) inRes.getContents().get(0);
					System.out.println(building);
					System.out.println(building.getAddress());
				}
				else {
					System.out.println("Wrong instance");
				}
			}
			else {
				System.out.println("No Contents");
			};
		} catch (Exception e) {
			e.printStackTrace();
		}
//		
	}

}
