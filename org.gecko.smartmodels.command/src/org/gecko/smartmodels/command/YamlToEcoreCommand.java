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
package org.gecko.smartmodels.command;

import org.osgi.service.component.annotations.*;
import org.gecko.smartmodels.apis.ecore.EcoreConcreteObjectConverter;
import org.gecko.smartmodels.apis.ecore.EcoreSmartModelGenerator;

@Component(service=YamlToEcoreCommand.class, property= {
        "osgi.command.scope=yamltoecore",
        "osgi.command.function=generateEcore",
        "osgi.command.function=createConcrete"})
public class YamlToEcoreCommand {
	
	@Reference
	private EcoreSmartModelGenerator ecoreSmartModelGen;
	
	@Reference
	private EcoreConcreteObjectConverter ecoreConcreteObjectConverter;
	
	public static final String BASE_PATH = System.getProperty("base.path") + "/data/";
	
	public void generateEcore(String pathToYamlInputFile, String pathToEcoreOutputFile) {
		ecoreSmartModelGen.generateEcoreSmartModel(BASE_PATH + pathToYamlInputFile, BASE_PATH + pathToEcoreOutputFile);
	}
	
	public void createConcrete(String pathToJsonInputFile, String ecoreModelPackageURI, String ecorePackagePrefix) {
		ecoreConcreteObjectConverter.createConcreteEObject(BASE_PATH + pathToJsonInputFile, ecoreModelPackageURI, ecorePackagePrefix);
//		ecoreSmartModelGen.createConcreteEObject(BASE_PATH + pathToJsonInputFile);
	}

}
