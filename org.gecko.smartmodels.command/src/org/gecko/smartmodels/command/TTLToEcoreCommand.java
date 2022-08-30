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
package org.gecko.smartmodels.command;

import org.gecko.smartmodels.apis.ecore.EcoreSmartModelGenerator;
import org.gecko.smartmodels.apis.ttl.TTLReader;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * @author ilenia
 * @since Aug 8, 2022
 */
@Component(service=TTLToEcoreCommand.class, property= {
        "osgi.command.scope=ttltoecore",
        "osgi.command.function=readTTL",
        "osgi.command.function=ttlToEcore"
        })
public class TTLToEcoreCommand {
	
	@Reference
	TTLReader ttlReader;
	
	@Reference(target = "(component.name=EcoreSmartModelGeneratorFromTtl)")
	EcoreSmartModelGenerator ecoreModelGeneratorFromTTL;
	
	private static final String BASE_PATH = System.getProperty("base.path");
	private static final String DATA_FOLDER = "/data/";
	private static final String TTL_FOLDER = "ttl/";
	
	public void readTTL(String pathToTTLFile) {
		ttlReader.readTTLFile(BASE_PATH + DATA_FOLDER + TTL_FOLDER + pathToTTLFile); 
	}
	
	public void ttlToEcore(String pathToTTLInputFile, String pathToEcoreOutputFile) {
		ecoreModelGeneratorFromTTL.generateEcoreSmartModel(BASE_PATH + DATA_FOLDER + pathToTTLInputFile, BASE_PATH + DATA_FOLDER + pathToEcoreOutputFile);
	}

}
