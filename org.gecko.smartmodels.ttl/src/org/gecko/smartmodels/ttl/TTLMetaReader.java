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
package org.gecko.smartmodels.ttl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ResIterator;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.riot.RDFDataMgr;
import org.gecko.smartmodels.apis.ttl.TTLMetaModel;
import org.gecko.smartmodels.apis.ttl.TTLReader;
import org.gecko.smartmodels.apis.ttl.TTLReaderHelper;
import org.osgi.service.component.annotations.Component;

/**
 * 
 * @author ilenia
 * @since Aug 17, 2022
 */
@Component(name = "TTLMetaReader")
public class TTLMetaReader implements TTLReader {

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.smartmodels.apis.ttl.TTLReader#readTTLFile(java.lang.String)
	 */
	@Override
	public TTLMetaModel readTTLFile(String pathToTTLFile) {
		Model model = RDFDataMgr.loadModel(pathToTTLFile) ;
		
//		Extract all classes (this will include classes, data types and enums)
		List<Resource> classList = extractStatements(model, TTLReaderHelper.PREDICATE_TYPE,  
				st -> TTLReaderHelper.OBJECT_CLASS_TYPE.equals(st.getObject().toString()))
				.stream().map(st -> st.getSubject()).collect(Collectors.toList());
		
//		Extract all the properties
		List<Resource> propList = extractStatements(model, TTLReaderHelper.PREDICATE_TYPE,  
				st -> TTLReaderHelper.OBJECT_PROPERTY_TYPE.equals(st.getObject().toString()))
				.stream().map(st -> st.getSubject()).collect(Collectors.toList());
		
		TTLMetaModel ttlMetaModel = new TTLMetaModel(model);
		ttlMetaModel.getClassesList().addAll(classList);
		ttlMetaModel.getPropertiesList().addAll(propList);
		return ttlMetaModel;
	}
	
	private List<Statement> extractStatements(Model model, String propertyURI,  Predicate<Statement> filter) {
		List<Statement> statamentList = new ArrayList<>();
		ResIterator iter = model.listSubjectsWithProperty(model.getProperty(propertyURI));
		while(iter.hasNext()) {
			Resource resource = iter.next();
			StmtIterator stmtIter = resource.listProperties(model.getProperty(propertyURI));
			while(stmtIter.hasNext()) {
				Statement statement = stmtIter.nextStatement();
				if(filter.test(statement)) {
					statamentList.add(statement);
				}
			}
		}
		return statamentList;
	}

}
