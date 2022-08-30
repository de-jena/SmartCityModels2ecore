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
import java.util.List;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;

/**
 * 
 * @author ilenia
 * @since Aug 17, 2022
 */
public class TTLMetaModel extends AbstractTTLModel {
	
	Model model;
	List<Resource> classesList;
	List<Resource> propertiesList;
	
	public TTLMetaModel(Model model) {
		this.model = model;
		this.classesList = new ArrayList<>();
		this.propertiesList = new ArrayList<>();
	}
	
	public Model getModel() {
		return this.model;
	}
	
	public List<Resource> getClassesList() {
		return this.classesList;
	}
	
	public List<Resource> getPropertiesList() {
		return this.propertiesList;
	}
	
	

}
