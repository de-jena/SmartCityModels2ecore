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
import org.gecko.smartmodels.apis.ttl.TTLModel;
import org.gecko.smartmodels.apis.ttl.TTLReader;
import org.gecko.smartmodels.apis.ttl.TTLReaderHelper;
import org.osgi.service.component.annotations.Component;

@Component(name="TTLReader")
public class TTLReaderImpl implements TTLReader{

	/* 
	 * (non-Javadoc)
	 * @see org.gecko.smartmodels.apis.ttl.TTLReader#readTTLFile(java.lang.String)
	 */
	@Override
	public TTLModel readTTLFile(String pathToTTLFile) {
		Model model = RDFDataMgr.loadModel(pathToTTLFile) ;
		
//		This will give us both classses and DataTypes since they are listed as classes as well, in addition to as data types
		List<Resource> classList = extractStatements(model, TTLReaderHelper.PREDICATE_TYPE,  
				st -> TTLReaderHelper.OBJECT_CLASS_TYPE.equals(st.getObject().toString()))
				.stream().map(st -> st.getSubject()).collect(Collectors.toList());
		
//		We filter to keep only the data types
		List<Resource> dataTypeList = classList.stream().filter(r -> {
			
			StmtIterator stmtIter = r.listProperties(model.getProperty(TTLReaderHelper.PREDICATE_TYPE));
			while(stmtIter.hasNext()) {
				Statement st = stmtIter.nextStatement();
				if(TTLReaderHelper.OBJECT_DATATYPE_TYPE.equals(st.getObject().toString())) {
					return true;
				}
			}
			return false;
		}).distinct().collect(Collectors.toList());

//		We filter to keep only the class (no data types)
		classList = classList.stream().filter(r -> {
			StmtIterator stmtIter = r.listProperties(model.getProperty(TTLReaderHelper.PREDICATE_TYPE));
			while(stmtIter.hasNext()) {
				Statement st = stmtIter.nextStatement();
				if(TTLReaderHelper.OBJECT_DATATYPE_TYPE.equals(st.getObject().toString())) {
					return false;
				}
			}
			return true;
		}).distinct().collect(Collectors.toList());
		
		
		TTLModel ttlModel = new TTLModel();

		classList.stream().forEach(r -> {
			
			if(!ttlModel.getClassHierarchyMap().containsKey(r.getNameSpace()+r.getLocalName())) {
				ttlModel.getClassHierarchyMap().put(r.getNameSpace()+r.getLocalName(), new ArrayList<String>());
			}
			if(r.hasProperty(model.getProperty(TTLReaderHelper.PREDICATE_SUBCLASS_OF))) {
				StmtIterator propIter = r.listProperties(model.getProperty(TTLReaderHelper.PREDICATE_SUBCLASS_OF));
				while(propIter.hasNext()) {
					ttlModel.getClassHierarchyMap().get(r.getNameSpace()+r.getLocalName()).add(propIter.nextStatement().getObject().toString());
				}
			}
		});
		
		List<String> dataTypesNameList = dataTypeList.stream().map(r -> r.getNameSpace() + r.getLocalName()).collect(Collectors.toList());
		ttlModel.getDataTypesList().addAll(dataTypesNameList);
		
		List<Resource> propList = extractStatements(model, TTLReaderHelper.PREDICATE_TYPE, st -> TTLReaderHelper.OBJECT_PROPERTY_TYPE.equals(st.getObject().toString()))
				.stream().map(st -> st.getSubject()).distinct().collect(Collectors.toList());
		
		propList.stream().forEach(r -> {
			if(!ttlModel.getPropertyDomainMap().containsKey(r.getNameSpace()+r.getLocalName())) {
				ttlModel.getPropertyDomainMap().put(r.getNameSpace()+r.getLocalName(), new ArrayList<String>());
			}
			if(!ttlModel.getPropertyTypeMap().containsKey(r.getNameSpace()+r.getLocalName())) {
				ttlModel.getPropertyTypeMap().put(r.getNameSpace()+r.getLocalName(), new ArrayList<String>());
			}
			if(r.hasProperty(model.getProperty(TTLReaderHelper.PREDICATE_DOMAIN_INCLUDES))) {
				StmtIterator propIter = r.listProperties(model.getProperty(TTLReaderHelper.PREDICATE_DOMAIN_INCLUDES));
				while(propIter.hasNext()) {
					ttlModel.getPropertyDomainMap().get(r.getNameSpace()+r.getLocalName()).add(propIter.nextStatement().getObject().toString());
				}
			}
			if(r.hasProperty(model.getProperty(TTLReaderHelper.PREDICATE_RANGE_INCLUDES))) {
				StmtIterator propIter = r.listProperties(model.getProperty(TTLReaderHelper.PREDICATE_RANGE_INCLUDES));
				while(propIter.hasNext()) {
					ttlModel.getPropertyTypeMap().get(r.getNameSpace()+r.getLocalName()).add(propIter.nextStatement().getObject().toString());
				}
			}
		});    

		return ttlModel;
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
