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
package org.gecko.smartmodels.apis.yaml;

import java.util.Map;

/**
 * 
 * @author ilenia
 * @since Jun 24, 2022
 */
public interface YamlReader {
	
	public static final String YAML_DESCRIPTION_KEY = "description";
	public static final String YAML_PROPERTIES_KEY = "properties";
	public static final String YAML_VALUES_KEY = "values";
	public static final String YAML_TYPE_KEY = "type";
	public static final String YAML_ANYOF_KEY = "anyOf";
	public static final String YAML_ONEOF_KEY = "oneOf";
	public static final String YAML_REQUIRED_KEY = "required";
	public static final String YAML_ITEMS_KEY = "items";
	public static final String YAML_MIN_ITEMS_KEY = "minItems";
	public static final String YAML_MAX_ITEMS_KEY = "maxItems";
	public static final String YAML_ENUM_KEY = "enum";
	public static final String YAML_XNGSI_KEY = "x-ngsi";
	
	public static final String YAML_OBJECT_TYPE = "object";
	public static final String YAML_STRING_TYPE = "string";
	public static final String YAML_NUMBER_TYPE = "number";
	public static final String YAML_INTEGER_TYPE = "integer";
	public static final String YAML_ARRAY_TYPE = "array";
	public static final String YAML_BOOLEAN_TYPE = "boolean";
	
	public static final String YAML_XNGSI_TYPE_GEOPROPERTY = "Geoproperty";
	public static final String YAML_XNGSI_MODEL_KEY = "model";
	
	Map<String, Object> getYamlContent(String yamlFilePath);
	
	

}
