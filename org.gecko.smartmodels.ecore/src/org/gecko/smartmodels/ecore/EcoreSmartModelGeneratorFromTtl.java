/**
 * Copyright (c) 2012 - 2022 Data In Motion and others.
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.gecko.smartmodels.apis.ecore.EcoreSmartModelGenerator;
import org.gecko.smartmodels.apis.ttl.TTLModel;
import org.gecko.smartmodels.apis.ttl.TTLReader;
import org.gecko.smartmodels.ecore.helper.ECoreGeneratorHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * @author ilenia
 * @since Aug 10, 2022
 */
@Component(name = "EcoreSmartModelGeneratorFromTtl")
public class EcoreSmartModelGeneratorFromTtl implements EcoreSmartModelGenerator {

	@Reference(target = "(component.name=TTLReader)")
	TTLReader ttlReader;

	@Reference
	private ResourceSet resourceSet;

	private static final String TTL_FILE_EXTENSION = ".ttl";
	
	private static final Map<String, EClassifier> BASIC_TYPES_CONVERSION_MAP = 
			Map.ofEntries(Map.entry("Float", EcorePackage.Literals.EDOUBLE_OBJECT),
						  Map.entry("Double", EcorePackage.Literals.EDOUBLE_OBJECT),
						  Map.entry("Number", EcorePackage.Literals.EDOUBLE_OBJECT),
						  Map.entry("Integer", EcorePackage.Literals.EINTEGER_OBJECT),
						  Map.entry("Boolean", EcorePackage.Literals.EBOOLEAN_OBJECT),
						  Map.entry("Text", EcorePackage.Literals.ESTRING),
						  Map.entry("Time", EcorePackage.Literals.ESTRING),
						  Map.entry("Date", EcorePackage.Literals.ESTRING),
						  Map.entry("DateTime", EcorePackage.Literals.ESTRING));
	
	private static final String DATA_TYPE_CLASS_NAME = "DataType";
	

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.smartmodels.apis.ecore.EcoreSmartModelGenerator#canHandleFileFormat(java.lang.String)
	 */
	@Override
	public boolean canHandleFileFormat(String pathToInputFile) {
		if(Objects.isNull(pathToInputFile)) {
			return false;
		}
		if(pathToInputFile.endsWith(TTL_FILE_EXTENSION)) {
			return true;
		}
		return false;
	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.smartmodels.apis.ecore.EcoreSmartModelGenerator#generateEcoreSmartModels(java.lang.String, java.lang.String)
	 */
	@Override
	public void generateEcoreSmartModels(String pathToInFolder, String pathToEcoreOutFolder) {
		// TODO Auto-generated method stub

	}

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.smartmodels.apis.ecore.EcoreSmartModelGenerator#generateEcoreSmartModel(java.lang.String, java.lang.String)
	 */
	@Override
	public void generateEcoreSmartModel(String pathToInputFile, String pathToEcoreOutputFile) {

		if(!canHandleFileFormat(pathToInputFile)) {
			throw new IllegalArgumentException("Cannot handle file format " + pathToInputFile);
		}

		TTLModel ttlModel = (TTLModel) ttlReader.readTTLFile(pathToInputFile);
		String fileName = new File(pathToInputFile).getName().replace(TTL_FILE_EXTENSION, "");
		String ecoreModelName = fileName.substring(0,1).toLowerCase() + fileName.substring(1);
		final EPackage mainEcorePackage = ECoreGeneratorHelper.createPackage(ecoreModelName, ecoreModelName, ECORE_URL_PREFIX+ecoreModelName+ECORE_URL_VERSION);

		addClasses(ttlModel, mainEcorePackage);
		addDataTypes(ttlModel, mainEcorePackage);

		Map<String, List<String>> propertyDomainMap = ttlModel.getPropertyDomainMap();
		Map<String, List<String>> propertyTypeMap = ttlModel.getPropertyTypeMap();
		propertyDomainMap.forEach((prop, domainList) -> {

			String propName = extractLastURLSegment(prop);
			List<String> propTypes = propertyTypeMap.get(prop);
			
//			TODO we are going to take only the first type of a property. However, there are properties with multiple types, 
//			so at some point we have to decide how to deal with them...
			if(propTypes != null && propTypes.size() > 0) {
				List<String> classesNames = domainList.stream().map(d -> extractLastURLSegment(d)).collect(Collectors.toList());
				classesNames.stream().forEach(cn -> {
					EClass c = (EClass) mainEcorePackage.getEClassifier(cn);
					if(c != null) {
						String typeName = extractLastURLSegment(propTypes.get(0));
						EClassifier type = BASIC_TYPES_CONVERSION_MAP.get(typeName);
						if(type == null) {
							type = mainEcorePackage.getEClassifier(typeName);
						}
						List<EClass> allParentChain = new ArrayList<>();
						extractParentClasses(c, allParentChain);
						List<String> parentClassNames = allParentChain.stream().map(cl -> cl.getName()).collect(Collectors.toList());
						boolean isInParent = false;
						for(String parent : parentClassNames) {
							if(classesNames.contains(parent)) {
								isInParent = true;
								break;
							}
						}
//						If a property is already inherited by a parent class, we do not add it to this class
						if(!isInParent) {
							if(type instanceof EDataType) {
								ECoreGeneratorHelper.addAttribute(c, propName, type, false, 0, 1, null);
							} else if(type instanceof EClass) {
								ECoreGeneratorHelper.addReference(c, propName, type, 0, 1, null, true);
							}
						}
						
//						EParameter parameter = ECoreGeneratorHelper.createEParameter(propName, type);
//						EOperation setOperation = ECoreGeneratorHelper.createEOperation("set"+propName.substring(0, 1).toUpperCase()+propName.substring(1), Collections.singletonList(parameter), null);
//						c.getEOperations().add(setOperation);
//						
//						EOperation getOperation = ECoreGeneratorHelper.createEOperation("get"+propName.substring(0, 1).toUpperCase()+propName.substring(1), Collections.emptyList(), type);
//						c.getEOperations().add(getOperation);
						
					}
				});
			} else if(propTypes.size() > 1) {
				System.out.println("Multiple ( " + propTypes.size() + ") for property " + propName);
				propTypes.stream().forEach(t -> {
					System.out.println("Type " + t);
				});
				
				System.out.println("-------------------------");
			}

		});
		saveEcoreModel(pathToEcoreOutputFile, mainEcorePackage);
	}

	private void addDataTypes(TTLModel ttlModel, EPackage mainEcorePackage) {
		List<String> dataTypesList = ttlModel.getDataTypesList();
		dataTypesList.stream().forEach(dt -> {
			String dataTypeName = extractLastURLSegment(dt);
			if(!BASIC_TYPES_CONVERSION_MAP.containsKey(dataTypeName)) {
				EDataType eDataType = ECoreGeneratorHelper.createEDataType(dataTypeName);
				mainEcorePackage.getEClassifiers().add(eDataType);
			}			
		});	
	}
	
	private List<EClass> extractParentClasses(EClass clazz, List<EClass> parentClasses) {
		parentClasses.addAll(clazz.getESuperTypes());
		List<EClass> anchestorClasses = new ArrayList<>();
		for(Iterator<EClass> iter = parentClasses.iterator(); iter.hasNext();) {
			EClass parent = iter.next();
			extractParentClasses(parent, anchestorClasses);
		}		
		parentClasses.addAll(anchestorClasses);
		return parentClasses;
	}

	private void addClasses(TTLModel ttlModel, EPackage mainEcorePackage) {
		Map<String, List<String>> classHierarchyMap = ttlModel.getClassHierarchyMap();
		classHierarchyMap.forEach((k,v) -> {
			String className = extractLastURLSegment(k);
			if(DATA_TYPE_CLASS_NAME.equals(className)) {
				return;
			}
			if(!BASIC_TYPES_CONVERSION_MAP.containsKey(className)) {
				EClass eClass = (EClass) mainEcorePackage.getEClassifier(className);
				if(eClass == null) {
					eClass = ECoreGeneratorHelper.createEClass(className);
					mainEcorePackage.getEClassifiers().add(eClass);
				}
				v.stream().forEach(pc -> {
					String parentClassName = extractLastURLSegment(pc);
					EClass parentClass = (EClass) mainEcorePackage.getEClassifier(parentClassName);
					if(parentClass == null) {
						parentClass = ECoreGeneratorHelper.createEClass(parentClassName);
						mainEcorePackage.getEClassifiers().add(parentClass);
					}
					parentClass.setInterface(true);
					parentClass.setAbstract(true);
					((EClass) mainEcorePackage.getEClassifier(className)).getESuperTypes().add(parentClass);
				});
			}			
		});
	}

	private String extractLastURLSegment(String url) {
		return url.substring(url.lastIndexOf('/') + 1);
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
