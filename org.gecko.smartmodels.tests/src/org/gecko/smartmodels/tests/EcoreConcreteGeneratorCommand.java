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
package org.gecko.smartmodels.tests;

import org.gecko.smartmodels.apis.ecore.EcoreConcreteObjectConverter;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * @author ilenia
 * @since Jul 21, 2022
 */
@Component(service=EcoreConcreteGeneratorCommand.class, property= {
		"osgi.command.scope=concreteEcore",
		"osgi.command.function=createConcrete"
})
public class EcoreConcreteGeneratorCommand {
	
	@Reference
	private EcoreConcreteObjectConverter ecoreConcreteObjectConverter;
	
	public static final String BASE_PATH = System.getProperty("base.path") + "/data/";

	public void createConcrete(String pathToJsonInputFile, String ecoreModelPackageURI, String ecorePackagePrefix) {
		ecoreConcreteObjectConverter.createConcreteEObject(BASE_PATH + pathToJsonInputFile, ecoreModelPackageURI, ecorePackagePrefix);
	}

}
