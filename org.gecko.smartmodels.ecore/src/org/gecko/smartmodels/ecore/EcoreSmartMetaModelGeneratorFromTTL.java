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
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.apache.jena.rdf.model.Model;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.gecko.smartmodels.apis.ecore.EcoreSmartModelGenerator;
import org.gecko.smartmodels.apis.ttl.TTLMetaModel;
import org.gecko.smartmodels.apis.ttl.TTLReader;
import org.gecko.smartmodels.ecore.helper.ECoreGeneratorHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * @author ilenia
 * @since Aug 17, 2022
 */
@Component(name="EcoreSmartMetaModelGeneratorFromTTL")
public class EcoreSmartMetaModelGeneratorFromTTL implements EcoreSmartModelGenerator {
	
	@Reference(target = "(component.name=TTLMetaReader)")
	TTLReader ttlReader;
	
	@Reference
	private ResourceSet resourceSet;
	
	private static final String TTL_FILE_EXTENSION = ".ttl";
	private static final String ECORE_FILE_EXTENSION = ".ecore";


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
		
		TTLMetaModel ttlModel = (TTLMetaModel) ttlReader.readTTLFile(pathToInputFile);
		String fileName = new File(pathToEcoreOutputFile).getName().replace(ECORE_FILE_EXTENSION, "");
		String ecoreModelName = fileName.substring(0,1).toLowerCase() + fileName.substring(1);
		final EPackage mainEcorePackage = ECoreGeneratorHelper.createPackage(ecoreModelName, ecoreModelName, ECORE_URL_PREFIX+ecoreModelName+ECORE_URL_VERSION);


		createMainRDFMetaClasses(mainEcorePackage);
		createMetaClasses(ttlModel, mainEcorePackage);
		
		saveEcoreModel(pathToEcoreOutputFile, mainEcorePackage);

	}
	

	private void createMetaClasses(TTLMetaModel ttlModel, EPackage mainEcorePackage) {
		List<org.apache.jena.rdf.model.Resource> classesList = ttlModel.getClassesList();
		Model graph = ttlModel.getModel();
		classesList.stream().forEach(cl -> {
			String className = cl.getLocalName();
			EClass clazz = ECoreGeneratorHelper.createEClass(className);
			clazz.getESuperTypes().add((EClass) mainEcorePackage.getEClassifier("RDFMetaClass"));
			
		});
	}

	
	private void createMainRDFMetaClasses(EPackage mainEcorePackage) {
		EClass RDFMetaClass = ECoreGeneratorHelper.createEClass("RDFMetaClass");
		ECoreGeneratorHelper.addAttribute(RDFMetaClass, "label", EcorePackage.Literals.ESTRING, false, 0, 1, "The label");
		ECoreGeneratorHelper.addAttribute(RDFMetaClass, "uri", EcorePackage.Literals.ESTRING, false, 0, 1, "The uri");
		ECoreGeneratorHelper.addAttribute(RDFMetaClass, "comment", EcorePackage.Literals.ESTRING, false, 0, 1, "The description");
		ECoreGeneratorHelper.addAttribute(RDFMetaClass, "subClassOf", EcorePackage.Literals.ESTRING, false, 0, -1, "A list of parent classes");
		
		
		EClass RDFMetaProperty = ECoreGeneratorHelper.createEClass("RDFPropertyClass");
		ECoreGeneratorHelper.addAttribute(RDFMetaProperty, "label", EcorePackage.Literals.ESTRING, false, 0, 1, "The label");
		ECoreGeneratorHelper.addAttribute(RDFMetaProperty, "uri", EcorePackage.Literals.ESTRING, false, 0, 1, "The uri");
		ECoreGeneratorHelper.addAttribute(RDFMetaProperty, "comment", EcorePackage.Literals.ESTRING, false, 0, 1, "The description");
		ECoreGeneratorHelper.addAttribute(RDFMetaProperty, "subPropertyOf", EcorePackage.Literals.ESTRING, false, 0, -1, "A list of parent properties");
		ECoreGeneratorHelper.addAttribute(RDFMetaProperty, "rangeIncludes", EcorePackage.Literals.ESTRING, false, 0, -1, "A list of types for the property");
		ECoreGeneratorHelper.addAttribute(RDFMetaProperty, "domainIncludes", EcorePackage.Literals.ESTRING, false, 0, -1, "A list of classes to which the property belongs");
			
		mainEcorePackage.getEClassifiers().add(RDFMetaClass);
		mainEcorePackage.getEClassifiers().add(RDFMetaProperty);
		
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
