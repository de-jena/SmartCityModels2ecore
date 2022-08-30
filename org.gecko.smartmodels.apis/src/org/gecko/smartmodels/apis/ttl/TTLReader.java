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
package org.gecko.smartmodels.apis.ttl;

/**
 * 
 * @author ilenia
 * @since Aug 8, 2022
 */
public interface TTLReader {
	
	AbstractTTLModel readTTLFile(String pathToTTLFile);

}
