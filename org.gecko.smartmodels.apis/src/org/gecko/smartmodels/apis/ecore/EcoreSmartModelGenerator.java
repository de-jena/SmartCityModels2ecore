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
package org.gecko.smartmodels.apis.ecore;

/**
 * 
 * @author ilenia
 * @since Jun 24, 2022
 */
public interface EcoreSmartModelGenerator {
	
	public static final String ECORE_URL_PREFIX = "http://smartmodels.com/";
	public static final String ECORE_URL_VERSION = "/1.0";	
	
	public boolean canHandleFileFormat(String pathToInputFile);
	
	public void generateEcoreSmartModels(String pathToInFolder, String pathToEcoreOutFolder);
	
	public void generateEcoreSmartModel(String pathToInputFile, String pathToEcoreOutputFile);

}
