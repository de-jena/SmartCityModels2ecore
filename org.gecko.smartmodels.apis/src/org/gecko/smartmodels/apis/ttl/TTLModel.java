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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author ilenia
 * @since Aug 10, 2022
 * This is just a class which holds the information about a TTL model extracted from the TTLReader, without bringing around TTL dependencies
 */
public class TTLModel extends AbstractTTLModel {
	
	private Map<String, List<String>> classHierarchyMap;
	private Map<String, List<String>> propertyDomainMap;
	private Map<String, List<String>> propertyTypeMap;
	private List<String> dataTypesList;
	
	public TTLModel() {
		classHierarchyMap = new HashMap<>();
		propertyDomainMap = new HashMap<>();
		propertyTypeMap = new HashMap<>();
		dataTypesList = new ArrayList<>();
	}
	
	public Map<String, List<String>> getClassHierarchyMap() {
		return classHierarchyMap;
	}
	
	public Map<String, List<String>> getPropertyDomainMap() {
		return propertyDomainMap;
	}
	
	public Map<String, List<String>> getPropertyTypeMap() {
		return propertyTypeMap;
	}
	
	public List<String> getDataTypesList() {
		return dataTypesList;
	}
	

}
