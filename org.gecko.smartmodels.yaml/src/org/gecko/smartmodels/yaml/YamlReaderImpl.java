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
package org.gecko.smartmodels.yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

import org.gecko.smartmodels.apis.yaml.YamlReader;
import org.osgi.service.component.annotations.Component;
import org.snakeyaml.engine.v2.api.Load;
import org.snakeyaml.engine.v2.api.LoadSettings;

/**
 * 
 * @author ilenia
 * @since Jun 24, 2022
 */
@Component(name = "YamlReader")
public class YamlReaderImpl implements YamlReader {


	/* 
	 * (non-Javadoc)
	 * @see org.gecko.smartmodels.apis.yaml.YamlReader#readYamlFile(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getYamlContent(String yamlFilePath) {
		try {
			InputStream inputStream = new FileInputStream(new File(yamlFilePath));
			LoadSettings settings = LoadSettings.builder().setLabel("Custom user configuration").build();
			Load load = new Load(settings);
			Map<String, Object> yamlContent = (Map<String, Object>) load.loadFromInputStream(inputStream);
			return yamlContent;
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Something went wrong while parsing yaml file " + yamlFilePath);
		}
	}

}
