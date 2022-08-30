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
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.gecko.smartmodels.apis.ecore.EcoreSmartModelGenerator;
import org.gecko.smartmodels.apis.yaml.YamlReader;
import org.gecko.smartmodels.ecore.helper.ECoreGeneratorHelper;
import org.gecko.smartmodels.geojson.model.geojson.GeojsonPackage;
import org.gecko.smartmodels.schema.model.schema.SchemaPackage;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;



@Component(name = "EcoreSmartModelGeneratorFromYaml")
public class EcoreSmartModelGeneratorFromYamlImpl implements EcoreSmartModelGenerator {

	@Reference
	private ResourceSet resourceSet;

	@Reference
	private YamlReader yamlReader;

	@Reference
	GeojsonPackage geojsonPackage;

	@Reference
	SchemaPackage schemaPackage;


	private static final String YAML_FILE_EXTENSION = ".yaml";

	private static final Logger LOGGER = Logger.getLogger(EcoreSmartModelGeneratorFromYamlImpl.class.getName());
	private static final Map<String, String> SCHEMA_MODELS_MAP = 
			Map.ofEntries(Map.entry("https://schema.org/address", "PostalAddress"), 
						  Map.entry("https://schema.org/ContactPoint", "ContactPoint"),
						  Map.entry("https://schema.org/aggregateRating", "AggregateRating"),
						  Map.entry("https://schema.org/contactPoint", "ContactPoint"),
						  Map.entry("https://schema.org/Person", "Person"));
	
	private static final Map<String, EDataType> SIMPLE_TYPES_MAP =
			Map.ofEntries(Map.entry("https://schema.org/openingHours", EcorePackage.Literals.ESTRING),
					      Map.entry("https://schema.org/Text", EcorePackage.Literals.ESTRING),
					      Map.entry("https://schema.org/DateTime", EcorePackage.Literals.ESTRING),
						  Map.entry("https://schema.org/Number", EcorePackage.Literals.EDOUBLE),
						  Map.entry("http://schema.org/Number", EcorePackage.Literals.EDOUBLE),
						  Map.entry("https://schema.org/Number.", EcorePackage.Literals.EDOUBLE),
						  Map.entry("http://schema.org/Number.", EcorePackage.Literals.EDOUBLE), 
						  Map.entry("https://schema.org/URL", EcorePackage.Literals.ESTRING));
	
	private static final Map<String, EDataType> STRUCTURED_VALUE_MAP =
			Map.ofEntries(Map.entry("http://schema.org/StructuredValue", EcorePackage.Literals.EJAVA_OBJECT),
						  Map.entry("https://schema.org/StructuredValue", EcorePackage.Literals.EJAVA_OBJECT),
						  Map.entry("http://schema.org/StructuredValue.", EcorePackage.Literals.EJAVA_OBJECT),
						  Map.entry("https://schema.org/StructuredValue.", EcorePackage.Literals.EJAVA_OBJECT));
					
	private File cumulativeSummaryFile;
	private String currentModel;
	private List<String> problematicModelList = List.of("MediaEvent");
	private boolean writeSummary = true;

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.smartmodels.apis.ecore.EcoreSmartModelGenerator#generateEcoreSmartModels(java.lang.String, java.lang.String)
	 */
	@Override
	public void generateEcoreSmartModels(String pathToYamlInFolder, String pathToEcoreOutFolder) {

		File folder = new File(pathToYamlInFolder);
		if(!folder.exists()) {
			throw new IllegalArgumentException("Folder " + pathToYamlInFolder + " does not exist!");
		}
		if(!folder.isDirectory()) {
			throw new IllegalArgumentException("The provided path " + pathToYamlInFolder + " is not a directory!");
		}
		File[] pathNames = folder.listFiles();
		int counter = 0;
		for(File f : pathNames) {
			if(f.isDirectory() || !f.getName().endsWith(".yaml")) {
				LOGGER.warning("Skipping " + f.getPath() + " because is a directory or the file extension is not yaml!");
				continue;
			}
			String fileName = f.getName().replaceAll(".yaml", "");
			if(problematicModelList.contains(fileName)) {
				continue;
			}
			if(new File(pathToEcoreOutFolder  + "/" + fileName + ".ecore").exists()) {
				continue;
			}
			LOGGER.info("Start processing file " + fileName);
			counter++;
			generateEcoreSmartModel(pathToYamlInFolder + "/" + fileName + ".yaml", pathToEcoreOutFolder  + "/" + fileName + ".ecore");
		}
		LOGGER.info("Processed a total of " + counter + " models!");
	}


	/* 
	 * (non-Javadoc)
	 * @see org.gecko.smartmodels.apis.ecore.EcoreSmartModelGenerator#generateEcoreSmartModel(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void generateEcoreSmartModel(String pathToYamlInputFile, String pathToEcoreOutputFile) {

		if(!canHandleFileFormat(pathToYamlInputFile)) {
			throw new IllegalArgumentException("Cannot handle file " + pathToYamlInputFile);
		}
		Map<String, Object> yamlContent = yamlReader.getYamlContent(pathToYamlInputFile);
		String mainObjectName = yamlContent.keySet().stream().findFirst().orElse(null);
		if(mainObjectName == null) {
			throw new IllegalArgumentException("No main object found in yaml file! Cannot continue...");
		}
		String ecoreModelName = mainObjectName.substring(0,1).toLowerCase() + mainObjectName.substring(1);
		final EPackage mainEcorePackage = ECoreGeneratorHelper.createPackage(ecoreModelName, ecoreModelName, ECORE_URL_PREFIX+ecoreModelName+ECORE_URL_VERSION);
		final EClass mainEcoreClass = ECoreGeneratorHelper.createEClass(mainObjectName);
		mainEcorePackage.getEClassifiers().add(mainEcoreClass);

		currentModel = mainObjectName;
		createSummaryFilesAndFolders(pathToEcoreOutputFile, mainObjectName);

		convertYamlContent((Map<String, Object>) yamlContent.get(mainObjectName), mainEcoreClass, mainEcorePackage, null);		

		saveEcoreModel(pathToEcoreOutputFile, mainEcorePackage);
	}

	/**
	 * @param pathToEcoreOutputFile
	 * @param mainObjectName
	 */
	private void createSummaryFilesAndFolders(String pathToEcoreOutputFile, String mainObjectName) {
		File summaryFolder = new File(new File(pathToEcoreOutputFile).getParent() + "/summary");
		if(!summaryFolder.exists()) {
			summaryFolder.mkdir();
		}
		cumulativeSummaryFile = new File(summaryFolder.getPath().toString() + "/CumulativeModelSummary.txt");
		try {
			cumulativeSummaryFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	private void convertYamlContent(Map<String, Object> yamlContent, EClass eClass, EPackage mainEPackage, String propertyName) {

		try {
			ECoreGeneratorHelper.addDocumentation(eClass, extractElementDescription(yamlContent));
		
			if(yamlContent.containsKey(YamlReader.YAML_PROPERTIES_KEY)) {
				inspectObjectContent(YamlReader.YAML_PROPERTIES_KEY, yamlContent, eClass, mainEPackage, propertyName);

			} else if(yamlContent.containsKey(YamlReader.YAML_VALUES_KEY)) {
				inspectObjectContent(YamlReader.YAML_VALUES_KEY, yamlContent, eClass, mainEPackage, propertyName);
			} else {
//				We try to create an object if there are some properties even if not explicitly said...
				inspectObjectContent(null, yamlContent, eClass, mainEPackage, propertyName);
			}

		} catch(ClassCastException e) {
			writeInSummary(currentModel + " \t \t | " + propertyName + " \t \t | Unexpected ClassCastException in 'convertYamlContent'! " + yamlContent + " \n");
		}

	} 

	/**
	 * @param yamlPropertiesKey
	 * @param yamlContent
	 * @param eClass
	 * @param mainEPackage
	 * @param propertyName
	 */
	@SuppressWarnings("unchecked")
	private void inspectObjectContent(String yamlPropertiesKey, Map<String, Object> yamlContent, EClass eClass,
			EPackage mainEPackage, String propertyName) {

		List<String> requiredProperties = extractRequiredProperties(yamlContent);		
		//		There is no key for the object in the yaml file but directly the list of properties
		if(yamlPropertiesKey == null) {
			Map<String, Object> propertiesMap = yamlContent;
			propertiesMap.forEach((k, v) -> {
				Map<String, Object> valueMap = (Map<String, Object>) v;
				int lowerBound = requiredProperties.contains(k) ? 1 : 0;
				int upperBound = 1;
				if(valueMap.containsKey(YamlReader.YAML_TYPE_KEY)) {
					if(valueMap.get(YamlReader.YAML_TYPE_KEY) instanceof String) {
						String propertyType = (String) valueMap.get(YamlReader.YAML_TYPE_KEY);
						doConvertProperty(k, propertyType, valueMap, lowerBound, upperBound, eClass, mainEPackage);	
					} else {
						//							TODO case in which the "type" property is not a single String but an array because the attribute can be of any type!! 
						writeInSummary(currentModel + " \t \t | " + k + " \t \t | Type of " + k + " is not a single String \n");
					}

				}
				else if(valueMap.containsKey(YamlReader.YAML_ANYOF_KEY)) {
					extractMultipleTypes(k, (List<Map<String, Object>>) valueMap.get(YamlReader.YAML_ANYOF_KEY), lowerBound, upperBound, eClass, mainEPackage, extractElementDescription(valueMap));
				}
				else if(valueMap.containsKey(YamlReader.YAML_ONEOF_KEY)) {
					if(valueMap.containsKey(YamlReader.YAML_XNGSI_KEY)) {
						Map<String, Object> xngsiMap = (Map<String, Object>) valueMap.get(YamlReader.YAML_XNGSI_KEY);
						if(xngsiMap.containsKey(YamlReader.YAML_TYPE_KEY)) {
							if(YamlReader.YAML_XNGSI_TYPE_GEOPROPERTY.equals(xngsiMap.get(YamlReader.YAML_TYPE_KEY))) {
								Resource jsonRes = resourceSet.getResource(URI.createFileURI(System.getProperty("base.path")+"/../org.gecko.smartmodels.geojson.model/model/geojson.ecore"), true); 
								EPackage jsonPack = (EPackage) jsonRes.getContents().get(0);
								ECoreGeneratorHelper.addReference(eClass, k, jsonPack.getEClassifier("Geometry"), lowerBound, upperBound, extractElementDescription(valueMap), true);
							}
							else {
								extractMultipleTypes(k, (List<Map<String, Object>>) valueMap.get(YamlReader.YAML_ONEOF_KEY), lowerBound, upperBound, eClass, mainEPackage, extractElementDescription(valueMap));
							}
						} 
						else {
							extractMultipleTypes(k, (List<Map<String, Object>>) valueMap.get(YamlReader.YAML_ONEOF_KEY), lowerBound, upperBound, eClass, mainEPackage, extractElementDescription(valueMap));
						}
					} else if(valueMap.containsKey(YamlReader.YAML_DESCRIPTION_KEY)){
						String description = (String) valueMap.get(YamlReader.YAML_DESCRIPTION_KEY);
						if(description != null && description.startsWith(YamlReader.YAML_XNGSI_TYPE_GEOPROPERTY)) {
							Resource jsonRes = resourceSet.getResource(URI.createFileURI(System.getProperty("base.path")+"/../org.gecko.smartmodels.geojson.model/model/geojson.ecore"), true); 
							EPackage jsonPack = (EPackage) jsonRes.getContents().get(0);
							ECoreGeneratorHelper.addReference(eClass, k, jsonPack.getEClassifier("Geometry"), lowerBound, upperBound, extractElementDescription(valueMap), true);
						}						
					}
					else {
						extractMultipleTypes(k, (List<Map<String, Object>>) valueMap.get(YamlReader.YAML_ONEOF_KEY), lowerBound, upperBound, eClass, mainEPackage, extractElementDescription(valueMap));
					}
				}
			});			
		}
		else if(yamlContent.get(yamlPropertiesKey) == null) {
			//					TODO here we have an object with attribute yamlPropertiesKey which is there but does not contain anything!
			writeInSummary(currentModel + " \t \t | " + propertyName + " \t \t | Object has key " + yamlPropertiesKey + " but is empty \n");
		} else {
			Map<Object, Object> generalPropMap = (Map<Object, Object>) yamlContent.get(yamlPropertiesKey);
			if(generalPropMap.keySet().stream().findAny().orElse(null) instanceof String) {
				Map<String, Object> propertiesMap = (Map<String, Object>) yamlContent.get(yamlPropertiesKey);
				propertiesMap.forEach((k, v) -> {
					Map<String, Object> valueMap = (Map<String, Object>) v;
					int lowerBound = requiredProperties.contains(k) ? 1 : 0;
					int upperBound = 1;
					if(valueMap.containsKey(YamlReader.YAML_TYPE_KEY)) {
						if(valueMap.get(YamlReader.YAML_TYPE_KEY) instanceof String) {
							String propertyType = (String) valueMap.get(YamlReader.YAML_TYPE_KEY);
							doConvertProperty(k, propertyType, valueMap, lowerBound, upperBound, eClass, mainEPackage);		
						} else {
							//							TODO case in which the "type" property is not a single String but an array because the attribute can be of any type!! 
							writeInSummary(currentModel + " \t \t | " + k + " \t \t | Type of " + k + " is not a single String \n");
						}

					}
					else if(valueMap.containsKey(YamlReader.YAML_ANYOF_KEY)) {
						extractMultipleTypes(k, (List<Map<String, Object>>) valueMap.get(YamlReader.YAML_ANYOF_KEY), lowerBound, upperBound, eClass, mainEPackage, extractElementDescription(valueMap));
					}
					else if(valueMap.containsKey(YamlReader.YAML_ONEOF_KEY)) {
						if(valueMap.containsKey(YamlReader.YAML_XNGSI_KEY)) {
							Map<String, Object> xngsiMap = (Map<String, Object>) valueMap.get(YamlReader.YAML_XNGSI_KEY);
							if(xngsiMap.containsKey(YamlReader.YAML_TYPE_KEY)) {
								if(YamlReader.YAML_XNGSI_TYPE_GEOPROPERTY.equals(xngsiMap.get(YamlReader.YAML_TYPE_KEY))) {
									Resource jsonRes = resourceSet.getResource(URI.createFileURI(System.getProperty("base.path")+"/../org.gecko.smartmodels.geojson.model/model/geojson.ecore"), true); 
									EPackage jsonPack = (EPackage) jsonRes.getContents().get(0);
									ECoreGeneratorHelper.addReference(eClass, k, jsonPack.getEClassifier("Geometry"), lowerBound, upperBound, extractElementDescription(valueMap), true);
								}
								else {
									extractMultipleTypes(k, (List<Map<String, Object>>) valueMap.get(YamlReader.YAML_ONEOF_KEY), lowerBound, upperBound, eClass, mainEPackage, extractElementDescription(valueMap));
								}
							} 
							else {
								extractMultipleTypes(k, (List<Map<String, Object>>) valueMap.get(YamlReader.YAML_ONEOF_KEY), lowerBound, upperBound, eClass, mainEPackage, extractElementDescription(valueMap));
							}
						} else if(valueMap.containsKey(YamlReader.YAML_DESCRIPTION_KEY)){
							String description = (String) valueMap.get(YamlReader.YAML_DESCRIPTION_KEY);
							if(description != null && description.startsWith(YamlReader.YAML_XNGSI_TYPE_GEOPROPERTY)) {
								Resource jsonRes = resourceSet.getResource(URI.createFileURI(System.getProperty("base.path")+"/../org.gecko.smartmodels.geojson.model/model/geojson.ecore"), true); 
								EPackage jsonPack = (EPackage) jsonRes.getContents().get(0);
								ECoreGeneratorHelper.addReference(eClass, k, jsonPack.getEClassifier("Geometry"), lowerBound, upperBound, extractElementDescription(valueMap), true);
							}						
						}
						else {
							extractMultipleTypes(k, (List<Map<String, Object>>) valueMap.get(YamlReader.YAML_ONEOF_KEY), lowerBound, upperBound, eClass, mainEPackage, extractElementDescription(valueMap));
						}
					}
				});
			}
			else if(generalPropMap.keySet().stream().findAny().orElse(null) instanceof Integer) {
				//					We have to build a map because Java does not allow variable names which start with numbers!!
				Map<Integer, Object> intKeyPropMap = (Map<Integer, Object>) yamlContent.get(yamlPropertiesKey);					
				Object value = intKeyPropMap.values().stream().findAny().orElse(null);
				EClassifier valueDataType = EcorePackage.Literals.EOBJECT;
				String mapName = "IntegerToObjectMap";
				if(value != null) {
					if(value instanceof Map) {
						Map<String, Object> valueMap = (Map<String, Object>) value;
						if(valueMap.containsKey(YamlReader.YAML_TYPE_KEY)) {
							String valueMapType = (String) valueMap.get(YamlReader.YAML_TYPE_KEY);
							switch(valueMapType) {
							case YamlReader.YAML_INTEGER_TYPE:
								valueDataType = EcorePackage.Literals.EINTEGER_OBJECT;
								mapName = "IntegerToIntegerMap";
								break;
							case YamlReader.YAML_NUMBER_TYPE:
								valueDataType = EcorePackage.Literals.EDOUBLE_OBJECT;
								mapName = "IntegerToDoubleMap";
								break;
							case YamlReader.YAML_BOOLEAN_TYPE:
								valueDataType = EcorePackage.Literals.EBOOLEAN_OBJECT;
								mapName = "IntegerToBooleanMap";
								break;
							case YamlReader.YAML_STRING_TYPE:
								valueDataType = EcorePackage.Literals.ESTRING;
								mapName = "IntegerToStringMap";
								break;
							}
						}
					}						
				}
				EClass existingMapClass = (EClass) mainEPackage.getEClassifier(mapName);
				if(existingMapClass != null) {
					ECoreGeneratorHelper.addReference(eClass, "properties", existingMapClass, 0, 1, null, true);
				} else {
					EClass mapClass = ECoreGeneratorHelper.createEClass(mapName);
					mapClass.setInstanceTypeName("java.util.Map$Entry");
					ECoreGeneratorHelper.addAttribute(mapClass, "key", EcorePackage.Literals.EINTEGER_OBJECT, false, 0, 1, "the key of the map");
					ECoreGeneratorHelper.addAttribute(mapClass, "value", valueDataType, false, 0, 1, "the value of the map");
					//						writeInSummary("Property Map has Integer keys"  + propertyName + "\n");					
					mainEPackage.getEClassifiers().add(mapClass);
					ECoreGeneratorHelper.addReference(eClass, "properties", mapClass, 0, 1, null, true);
				}
			} else {
				//			TODO map keys different from String and Integer
				writeInSummary(currentModel + " \t \t | " + propertyName + " \t \t | Property Map has keys no String no Integer \n");

			} 

		}


	}


	@SuppressWarnings("unchecked")
	private void extractMultipleTypes(String propertyName, List<Map<String, Object> > possibleValuesList, int lowerBound, int upperBound, EClass mainEcoreClass, EPackage mainEcorePackage, String description) {

		try {
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

					writeInSummary(currentModel + " \t \t | " + propertyName + " \t \t | Property has 'oneOf' or 'anyOf' with type array \n");
					break;
				case YamlReader.YAML_OBJECT_TYPE:
					//				TODO: if all the possible types are object we have to check which kind of object they are. We can set the ref to a general 
					//				      EObject, and then add an annotation with the possible actual objects they might be
					writeInSummary(currentModel + " \t \t | " + propertyName + " \t \t | Property has 'oneOf' or 'anyOf' with type Object \n");
					break;
				default:
					//				TODO There is something we have not considered so far...
					writeInSummary(currentModel + " \t \t | " + propertyName + " \t \t | Property has 'oneOf' or 'anyOf' of unknown type " + propertyType + " \n");
				}
			}
			else {
				/*		TODO add support in case multiple types are found:
				 We can have different cases here:
				 	1. A simple object and a complex object (a String and an Address)
				 	2. A simple object and an array of simple objects (a String and an array of String)
				 	3. Multiple different simple objects (a String and an Integer)
				 */	
				writeInSummary(currentModel + " \t \t | " + propertyName + " \t \t | Property has 'oneOf' or 'anyOf' of different types \n");
			}
		} catch(ClassCastException e) {
			writeInSummary(currentModel + " \t \t | " + propertyName + " \t \t | Unexpected ClassCastException in 'extractMultipleTypes' \n");

		}


	}

	private void writeInSummary(String content) {
		if(writeSummary) {
			try {
				FileUtils.writeStringToFile(cumulativeSummaryFile, content, true);
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}	
	}

	@SuppressWarnings("unchecked")
	private void doConvertProperty(String propertyName, String propertyType, Map<String, Object> propertyValueMap, int lowerBound, int upperBound, EClass mainEcoreClass, EPackage mainEcorePackage) {
		try {
			String propertyDescription = extractElementDescription(propertyValueMap);
			switch(propertyType) {
			case YamlReader.YAML_STRING_TYPE:	
				if(propertyValueMap.containsKey(YamlReader.YAML_ENUM_KEY)) {
					List<Object> enumValues = (List<Object>) propertyValueMap.get(YamlReader.YAML_ENUM_KEY);
					EEnum eEnum = ECoreGeneratorHelper.createEEnum(mainEcoreClass.getName(), propertyName, enumValues);
					mainEcorePackage.getEClassifiers().add(eEnum);
					ECoreGeneratorHelper.addAttribute(mainEcoreClass, propertyName, eEnum, false, lowerBound, upperBound, propertyDescription);
				}
				else {
					ECoreGeneratorHelper
					.addAttribute(mainEcoreClass, propertyName, EcorePackage.Literals.ESTRING, false, lowerBound, upperBound, propertyDescription);
				}
				break;
			case YamlReader.YAML_OBJECT_TYPE:
				boolean doneWithSchema = false;
				if(propertyValueMap.containsKey(YamlReader.YAML_XNGSI_KEY)) { 
					Map<String, Object> xngsiProp = (Map<String, Object>) propertyValueMap.get(YamlReader.YAML_XNGSI_KEY);
					if(xngsiProp.containsKey(YamlReader.YAML_XNGSI_MODEL_KEY)) {
						String modelRef = (String) xngsiProp.get(YamlReader.YAML_XNGSI_MODEL_KEY);
						if(SCHEMA_MODELS_MAP.containsKey(modelRef)) {
							Resource schemaRes = resourceSet.getResource(URI.createFileURI(System.getProperty("base.path")+"/../org.gecko.smartmodels.schema.model/model/schema.ecore"), true); 
							EPackage schemaPack = (EPackage) schemaRes.getContents().get(0);
							ECoreGeneratorHelper.addReference(mainEcoreClass, propertyName, schemaPack.getEClassifier(SCHEMA_MODELS_MAP.get(modelRef)), 0, 1, null, true);
							doneWithSchema = true;
						} 
						else if(SIMPLE_TYPES_MAP.containsKey(modelRef)) {
							EDataType dataType = SIMPLE_TYPES_MAP.get(modelRef);
							ECoreGeneratorHelper.addAttribute(mainEcoreClass, propertyName, dataType, false, 0, 1, propertyDescription);
							doneWithSchema = true;
						}					
						else if(STRUCTURED_VALUE_MAP.containsKey(modelRef)) {
							if(!propertyValueMap.containsKey(YamlReader.YAML_PROPERTIES_KEY)) {
								EDataType dataType = SIMPLE_TYPES_MAP.get(modelRef);
								ECoreGeneratorHelper.addAttribute(mainEcoreClass, propertyName, dataType, false, 0, 1, propertyDescription);
								doneWithSchema = true;
							}
						}
//						if(!doneWithSchema) {
//							writeInSummary(currentModel + " \t \t | " + propertyName + " \t \t | should be built accordingly to model " + modelRef + " \n");
//						}
					}
				}
				if(!doneWithSchema) {
					EClass secondaryEClass = ECoreGeneratorHelper.createEClass(propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1));
					mainEcorePackage.getEClassifiers().add(secondaryEClass);
					ECoreGeneratorHelper.addReference(mainEcoreClass, propertyName, secondaryEClass, lowerBound, upperBound, propertyDescription, true);
					convertYamlContent(propertyValueMap, secondaryEClass, mainEcorePackage, propertyName);
				}
				break;
			case YamlReader.YAML_INTEGER_TYPE:
				ECoreGeneratorHelper
				.addAttribute(mainEcoreClass, propertyName, EcorePackage.Literals.EINTEGER_OBJECT, false, lowerBound, upperBound, propertyDescription);
				break;
			case YamlReader.YAML_NUMBER_TYPE: 
				ECoreGeneratorHelper
				.addAttribute(mainEcoreClass, propertyName, EcorePackage.Literals.EDOUBLE_OBJECT, false, lowerBound, upperBound, propertyDescription);
				break;
			case YamlReader.YAML_BOOLEAN_TYPE: 
				ECoreGeneratorHelper
				.addAttribute(mainEcoreClass, propertyName, EcorePackage.Literals.EBOOLEAN_OBJECT, false, lowerBound, upperBound, propertyDescription);
				break;
			case YamlReader.YAML_ARRAY_TYPE:
				treatArray(propertyName, propertyValueMap, mainEcoreClass, mainEcorePackage, propertyDescription);
				break;
			default:
				//			TODO there is something we have not considered so far...
				writeInSummary(currentModel + " \t \t | " + propertyName + " \t \t | Property of unknown type " + propertyType + "\n");
			}
		} catch(ClassCastException e) {
			//			TODO unexpected CCE
			writeInSummary(currentModel + " \t \t | " + propertyName + " \t \t | Unexpected ClassCastException " + propertyType + "\n");
		}

	}

	@SuppressWarnings("unchecked")
	private void doConvertProperty(String propertyName, String propertyType, Map<String, Object> propertyValueMap, 
			int lowerBound, int upperBound, EClass mainEcoreClass, EPackage mainEcorePackage, String description) {
		try {
			String propertyDescription = description;
			if(propertyDescription == null) {
				propertyDescription = extractElementDescription(propertyValueMap);
			}
			switch(propertyType) {
			case YamlReader.YAML_STRING_TYPE:	
				if(propertyValueMap.containsKey(YamlReader.YAML_ENUM_KEY)) {
					List<Object> enumValues = (List<Object>) propertyValueMap.get(YamlReader.YAML_ENUM_KEY);
					EEnum eEnum = ECoreGeneratorHelper.createEEnum(mainEcoreClass.getName(), propertyName, enumValues);
					mainEcorePackage.getEClassifiers().add(eEnum);
					ECoreGeneratorHelper.addAttribute(mainEcoreClass, propertyName, eEnum, false, lowerBound, upperBound, propertyDescription);
				}
				else {
					ECoreGeneratorHelper
					.addAttribute(mainEcoreClass, propertyName, EcorePackage.Literals.ESTRING, false, lowerBound, upperBound, propertyDescription);
				}
				break;
			case YamlReader.YAML_OBJECT_TYPE:
				boolean doneWithSchema = false;
				if(propertyValueMap.containsKey(YamlReader.YAML_XNGSI_KEY)) { 
					Map<String, Object> xngsiProp = (Map<String, Object>) propertyValueMap.get(YamlReader.YAML_XNGSI_KEY);
					if(xngsiProp.containsKey(YamlReader.YAML_XNGSI_MODEL_KEY)) {
						String modelRef = (String) xngsiProp.get(YamlReader.YAML_XNGSI_MODEL_KEY);
						if(SCHEMA_MODELS_MAP.containsKey(modelRef)) {
							Resource schemaRes = resourceSet.getResource(URI.createFileURI(System.getProperty("base.path")+"/../org.gecko.smartmodels.schema.model/model/schema.ecore"), true); 
							EPackage schemaPack = (EPackage) schemaRes.getContents().get(0);
							ECoreGeneratorHelper.addReference(mainEcoreClass, propertyName, schemaPack.getEClassifier(SCHEMA_MODELS_MAP.get(modelRef)), 0, 1, null, true);
							doneWithSchema = true;
						} 
						else if(SIMPLE_TYPES_MAP.containsKey(modelRef)) {
							EDataType dataType = SIMPLE_TYPES_MAP.get(modelRef);
							ECoreGeneratorHelper.addAttribute(mainEcoreClass, propertyName, dataType, false, 0, 1, propertyDescription);
							doneWithSchema = true;
						}		
						else if(STRUCTURED_VALUE_MAP.containsKey(modelRef)) {
							if(!propertyValueMap.containsKey(YamlReader.YAML_PROPERTIES_KEY)) {
								EDataType dataType = SIMPLE_TYPES_MAP.get(modelRef);
								ECoreGeneratorHelper.addAttribute(mainEcoreClass, propertyName, dataType, false, 0, 1, propertyDescription);
								doneWithSchema = true;
							}
						}
//						if(!doneWithSchema) {
//							writeInSummary(currentModel + " \t \t | " + propertyName + " \t \t | should be built accordingly to model " + modelRef + " \n");
//						}
					}
				}
				if(!doneWithSchema) {
					EClass secondaryEClass = ECoreGeneratorHelper.createEClass(propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1));
					mainEcorePackage.getEClassifiers().add(secondaryEClass);
					ECoreGeneratorHelper.addReference(mainEcoreClass, propertyName, secondaryEClass, lowerBound, upperBound, propertyDescription, true);
					convertYamlContent(propertyValueMap, secondaryEClass, mainEcorePackage, propertyName);
				}				
				break;
			case YamlReader.YAML_INTEGER_TYPE:
				ECoreGeneratorHelper
				.addAttribute(mainEcoreClass, propertyName, EcorePackage.Literals.EINTEGER_OBJECT, false, lowerBound, upperBound, propertyDescription);
				break;
			case YamlReader.YAML_NUMBER_TYPE: 
				ECoreGeneratorHelper
				.addAttribute(mainEcoreClass, propertyName, EcorePackage.Literals.EDOUBLE_OBJECT, false, lowerBound, upperBound, propertyDescription);
				break;
			case YamlReader.YAML_BOOLEAN_TYPE: 
				ECoreGeneratorHelper
				.addAttribute(mainEcoreClass, propertyName, EcorePackage.Literals.EBOOLEAN_OBJECT, false, lowerBound, upperBound, propertyDescription);
				break;
			case YamlReader.YAML_ARRAY_TYPE:
				treatArray(propertyName, propertyValueMap, mainEcoreClass, mainEcorePackage, propertyDescription);
				break;
			default:
				//			TODO there is something we have not considered so far...
				writeInSummary(currentModel + " \t \t | " + propertyName + " \t \t | Property of unknown type " + propertyType + "\n");
			}
		} catch(ClassCastException e) {
			//			TODO unexpected CCE
			writeInSummary(currentModel + " \t \t | " + propertyName + " \t \t | Unexpected ClassCastException " + propertyType + "\n");
		}

	}

	@SuppressWarnings("unchecked")
	private void treatArray(String propertyName, Map<String, Object> propertyValueMap, EClass mainEcoreClass, EPackage mainEcorePackage, String propertyDescription) {
		try {
			int lowerBound = 0;
			int upperBound = -1;
			if(propertyValueMap.containsKey(YamlReader.YAML_MIN_ITEMS_KEY)) {
				lowerBound = (Integer) propertyValueMap.get(YamlReader.YAML_MIN_ITEMS_KEY);
			}
			if(propertyValueMap.containsKey(YamlReader.YAML_MAX_ITEMS_KEY)) {
				upperBound = (Integer) propertyValueMap.get(YamlReader.YAML_MAX_ITEMS_KEY);
			}
			if(propertyValueMap.containsKey(YamlReader.YAML_ITEMS_KEY)) {
				if(propertyValueMap.get(YamlReader.YAML_ITEMS_KEY) instanceof Map) {
					Map<String, Object> itemsMap = (Map<String, Object>) propertyValueMap.get(YamlReader.YAML_ITEMS_KEY);
					if(itemsMap.containsKey(YamlReader.YAML_TYPE_KEY)) {
						String itemsType = (String) itemsMap.get(YamlReader.YAML_TYPE_KEY);
						doConvertProperty(propertyName, itemsType, itemsMap, lowerBound, upperBound, mainEcoreClass, mainEcorePackage);
					}
					else if(itemsMap.containsKey(YamlReader.YAML_ANYOF_KEY)) {
						extractMultipleTypes(propertyName, (List<Map<String, Object>>) itemsMap.get(YamlReader.YAML_ANYOF_KEY), lowerBound, upperBound, mainEcoreClass, mainEcorePackage, propertyDescription);
					}
					else if(itemsMap.containsKey(YamlReader.YAML_ONEOF_KEY)) {
						if(itemsMap.containsKey(YamlReader.YAML_DESCRIPTION_KEY)){
							String description = (String) itemsMap.get(YamlReader.YAML_DESCRIPTION_KEY);
							if(description != null && description.startsWith(YamlReader.YAML_XNGSI_TYPE_GEOPROPERTY)) {
								Resource jsonRes = resourceSet.getResource(URI.createFileURI(System.getProperty("base.path")+"/../org.gecko.smartmodels.geojson.model/model/geojson.ecore"), true); 
								EPackage jsonPack = (EPackage) jsonRes.getContents().get(0);
								ECoreGeneratorHelper.addReference(mainEcoreClass, propertyName, jsonPack.getEClassifier("Geometry"), lowerBound, upperBound, extractElementDescription(itemsMap), true);
							}	
							else {
								extractMultipleTypes(propertyName, (List<Map<String, Object>>) itemsMap.get(YamlReader.YAML_ONEOF_KEY), lowerBound, upperBound, mainEcoreClass, mainEcorePackage, propertyDescription);
							}
						} else {
							extractMultipleTypes(propertyName, (List<Map<String, Object>>) itemsMap.get(YamlReader.YAML_ONEOF_KEY), lowerBound, upperBound, mainEcoreClass, mainEcorePackage, propertyDescription);
						}
					}
					else if(itemsMap.containsKey(YamlReader.YAML_PROPERTIES_KEY) || itemsMap.containsKey(YamlReader.YAML_VALUES_KEY)) {						
						EClass secondaryEClass = ECoreGeneratorHelper.createEClass(propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1));
						mainEcorePackage.getEClassifiers().add(secondaryEClass);
						ECoreGeneratorHelper.addReference(mainEcoreClass, propertyName, secondaryEClass, lowerBound, upperBound, propertyDescription, true);
						convertYamlContent(itemsMap, secondaryEClass, mainEcorePackage, propertyName);
					}
					else {
						//				TODO something we haven't foreseen
						EClass secondaryEClass = ECoreGeneratorHelper.createEClass(propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1));
						mainEcorePackage.getEClassifiers().add(secondaryEClass);
						ECoreGeneratorHelper.addReference(mainEcoreClass, propertyName, secondaryEClass, lowerBound, upperBound, propertyDescription, true);
						convertYamlContent(itemsMap, secondaryEClass, mainEcorePackage, propertyName);
						//						writeInSummary(currentModel + " \t \t | " + propertyName + " \t \t | Property has array items which is a map w/o type nor 'anyOf' nor 'oneOf' nor 'properties' nor 'values' info \n");
					}
				}
				else if(propertyValueMap.get(YamlReader.YAML_ITEMS_KEY) instanceof List) {
					List<Object> objs = (List<Object>) propertyValueMap.get(YamlReader.YAML_ITEMS_KEY);
					if(objs.size() == 1) {
						Object obj = objs.get(0);
						if(obj instanceof Map) {
							Map<String, Object> objMap = (Map<String, Object>) obj;
							if(objMap.containsKey(YamlReader.YAML_TYPE_KEY)) {
								String itemsType = (String) objMap.get(YamlReader.YAML_TYPE_KEY);
								doConvertProperty(propertyName, itemsType, objMap, lowerBound, upperBound, mainEcoreClass, mainEcorePackage, propertyDescription);
							}
							
							else if(objMap.containsKey(YamlReader.YAML_ANYOF_KEY)) {
								extractMultipleTypes(propertyName, (List<Map<String, Object>>) objMap.get(YamlReader.YAML_ANYOF_KEY), lowerBound, upperBound, mainEcoreClass, mainEcorePackage, propertyDescription);
							}
							else if(objMap.containsKey(YamlReader.YAML_ONEOF_KEY)) {
								if(objMap.containsKey(YamlReader.YAML_DESCRIPTION_KEY)){
									String description = (String) objMap.get(YamlReader.YAML_DESCRIPTION_KEY);
									if(description != null && description.startsWith(YamlReader.YAML_XNGSI_TYPE_GEOPROPERTY)) {
										Resource jsonRes = resourceSet.getResource(URI.createFileURI(System.getProperty("base.path")+"/../org.gecko.smartmodels.geojson.model/model/geojson.ecore"), true); 
										EPackage jsonPack = (EPackage) jsonRes.getContents().get(0);
										ECoreGeneratorHelper.addReference(mainEcoreClass, propertyName, jsonPack.getEClassifier("Geometry"), lowerBound, upperBound, extractElementDescription(objMap), true);
									}
									else {
										extractMultipleTypes(propertyName, (List<Map<String, Object>>) objMap.get(YamlReader.YAML_ONEOF_KEY), lowerBound, upperBound, mainEcoreClass, mainEcorePackage, propertyDescription);
									}
								} else {
									extractMultipleTypes(propertyName, (List<Map<String, Object>>) objMap.get(YamlReader.YAML_ONEOF_KEY), lowerBound, upperBound, mainEcoreClass, mainEcorePackage, propertyDescription);
								}
							}
							else  {
								//								TODO something we haven't foreseen
								writeInSummary(currentModel + " \t \t | " + propertyName + " \t \t | Property has array items which is a list w/o type nor 'anyOf' nor 'oneOf' info \n");
							}
						}
					}
					else {
						//						TODO something we haven't foreseen
						writeInSummary(currentModel + " \t \t | " + propertyName + " \t \t | Property has array items which is a list with size != 1 \n");
					}
				}
				else {
					//					TODO something we haven't foreseen
					writeInSummary(currentModel + " \t \t | " + propertyName + " \t \t | Property has array items which is neither a map nor a list, but it's a " + propertyValueMap.get(YamlReader.YAML_ITEMS_KEY).getClass() + "\n");
				}

			}
		} catch(ClassCastException e) {
			writeInSummary(currentModel + " \t \t | " + propertyName + " \t \t | Unexpected ClassCastExcpetion when treating array \n");
		}

	}


	private String extractElementDescription(Map<String, Object> yamlContent) {
		String description = null;
		if(yamlContent.containsKey(YamlReader.YAML_DESCRIPTION_KEY)) {
			description = (String) yamlContent.get(YamlReader.YAML_DESCRIPTION_KEY);
			if(description != null && description.isEmpty()) {
				description = null;
			}
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


	/* 
	 * (non-Javadoc)
	 * @see org.gecko.smartmodels.apis.ecore.EcoreSmartModelGenerator#canHandleFileFormat(java.lang.String)
	 */
	@Override
	public boolean canHandleFileFormat(String pathToInputFile) {
		if(Objects.isNull(pathToInputFile)) {
			return false;
		}
		if(pathToInputFile.endsWith(YAML_FILE_EXTENSION)) {
			return true;
		}
		return false;
	}


}
