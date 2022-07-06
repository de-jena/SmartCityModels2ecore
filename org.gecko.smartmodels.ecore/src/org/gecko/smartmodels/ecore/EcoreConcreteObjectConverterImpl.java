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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emfjson.jackson.databind.EMFContext;
import org.gecko.smartmodels.apis.ecore.EcoreConcreteObjectConverter;
import org.gecko.smartmodels.building.model.building.BuildingFactory;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * @author ilenia
 * @since Jul 6, 2022
 */
@Component(name = "EcoreConcreteObjectConverter")
public class EcoreConcreteObjectConverterImpl implements EcoreConcreteObjectConverter {
	
	@Reference
	private ComponentServiceObjects<ResourceSet> resourceSetFactory;
	
	@Reference
	BuildingFactory buildingFactory;	

	
	/* 
	 * (non-Javadoc)
	 * @see org.gecko.smartmodels.apis.ecore.EcoreConcreteObjectConverter#createConcreteEObject(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void createConcreteEObject(String pathToJsonInputFile, String ecorePackageURI, String ecorePackagePrefix) {
		ResourceSet resourceSet = resourceSetFactory.getService();
		Registry packageRegistry = resourceSet.getPackageRegistry();
		EPackage ePackage = packageRegistry.getEPackage(ecorePackageURI);
		EClass eclass = (EClass) ePackage.getEClassifier(ecorePackagePrefix);
		Resource inRes = resourceSet.createResource(URI.createFileURI(pathToJsonInputFile));
		try {		
			Map<Object, Object> loadOptions = new HashMap<Object, Object>();
			loadOptions.put(EMFContext.Attributes.ROOT_ELEMENT, eclass);
			inRes.load(loadOptions);
			if(inRes.getContents() != null && inRes.getContents().size() > 0) {
				if(inRes.getContents().get(0).eClass().equals(eclass)) {
					System.out.println("Classes are equals!!");
					System.out.println(inRes.getContents().get(0));
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

	}

}
