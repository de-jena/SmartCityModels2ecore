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
package org.gecko.smartmodels.tests;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emfcloud.jackson.annotations.EcoreTypeInfo;
import org.eclipse.emfcloud.jackson.databind.EMFContext;
import org.gecko.emf.json.constants.EMFJs;
import org.gecko.smartmodels.apis.ecore.EcoreConcreteObjectConverter;
import org.gecko.smartmodels.geojson.model.geojson.GeojsonPackage;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(name="EcoreConcreteObjectConverter")
public class EcoreConcreteObjectConverterImpl implements EcoreConcreteObjectConverter {
	
	@Reference
	private ResourceSet resourceSet;
	
	/* 
	 * (non-Javadoc)
	 * @see org.gecko.smartmodels.apis.ecore.EcoreConcreteObjectConverter#createConcreteEObject(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void createConcreteEObject(String pathToJsonInputFile, String ecoreModelURI, String ecorePackagePrefix) {
		Registry packageRegistry = resourceSet.getPackageRegistry();
		EPackage ePackage = packageRegistry.getEPackage(ecoreModelURI);
		if(ePackage == null) {
			System.out.println("EPackage " + ecoreModelURI + " not found!");
			return;
		}
		EClass eclass = (EClass) ePackage.getEClassifier(ecorePackagePrefix);
		Resource inRes = resourceSet.createResource(URI.createFileURI(pathToJsonInputFile));
		try {		
			Map<Object, Object> loadOptions = new HashMap<Object, Object>();
			loadOptions.put(EMFContext.Attributes.ROOT_ELEMENT, eclass);
			loadOptions.put(EMFJs.OPTION_TYPE_USE, EcoreTypeInfo.USE.NAME);
			loadOptions.put(EMFJs.OPTION_TYPE_FIELD, "type");
			loadOptions.put(EMFJs.OPTION_TYPE_PACKAGE_URIS, List.of(GeojsonPackage.eNS_URI, ePackage.getNsURI()));
			
			inRes.load(loadOptions);
			if(inRes.getContents() != null && inRes.getContents().size() > 0) {
				if(inRes.getContents().get(0).eClass().equals(eclass)) {
					System.out.println("Classes are equals!!");
					System.out.println(inRes.getContents().get(0));
					EObject mainObj = (EObject) inRes.getContents().get(0);
					for(EObject ref : mainObj.eContents()) {
						System.out.println(ref);
					}
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
