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
 * @since Aug 10, 2022
 */
public class TTLReaderHelper {
	
	public static final String PREDICATE_SUBCLASS_OF = "http://www.w3.org/2000/01/rdf-schema#subClassOf";
	
	public static final String PREDICATE_LABEL = "http://www.w3.org/2000/01/rdf-schema#label";
	
	public static final String PREDICATE_COMMENT = "http://www.w3.org/2000/01/rdf-schema#comment";
	
	public static final String PREDICATE_SUBPROPERTY_OF = "http://www.w3.org/2000/01/rdf-schema#subPropertyOff";
	
	
	/** PREDICATE_DOMAIN_INCLUDES 
	 *  This is the predicate whose object contains the URI of the classes to which the property with it belongs
	 * 
	 **/
	public static final String PREDICATE_DOMAIN_INCLUDES = "https://schema.org/domainIncludes";
	public static final String DCAT_PREDICATE_DOMAIN_INCLUDES = "http://purl.org/dc/dcam/domainIncludes";
	public static final String RDF_PREDICATE_DOMAIN_INCLUDES = "http://www.w3.org/2000/01/rdf-schema#domain";
	
	
	/** PREDICATE_RANGE_INCLUDES 
	 *  This is the predicate whose object contains the URI of the type of the property 
	 * 
	 **/
	public static final String PREDICATE_RANGE_INCLUDES = "https://schema.org/rangeIncludes";
	public static final String DCAT_PREDICATE_RANGE_INCLUDES = "http://purl.org/dc/dcam/rangeIncludes";
	public static final String RDF_PREDICATE_RANGE_INCLUDES = "http://www.w3.org/2000/01/rdf-schema#range";
	
	
	/** PREDICATE_TYPE 
	 *  This is the predicate whose object contains whether the Resource represents a Class or a Property
	 * 
	 * */
	public static final String PREDICATE_TYPE = "http://www.w3.org/1999/02/22-rdf-syntax-ns#type";
	
	
	/** OBJECT_CLASS_TYPE 
	 *  This is the object which marks a Resource as a Class
	 * 
	 * */
	public static final String OBJECT_CLASS_TYPE = "http://www.w3.org/2000/01/rdf-schema#Class";
	public static final String OWL_OBJECT_CLASS_TYPE = "http://www.w3.org/2002/07/owl#Class";
	
	
	/** OBJECT_DATATYPE_TYPE 
	 *  This is the object which marks a Resource as a DataType
	 * 
	 * */
	public static final String OBJECT_DATATYPE_TYPE = "https://schema.org/DataType";
	public static final String RDF_OBJECT_DATATYPE_TYPE = "http://www.w3.org/2000/01/rdf-schema#Datatype";
	
	
	/** OBJECT_PROPERTY_TYPE 
	 *  This is the object which marks a Resource as a Property
	 * 
	 * */
	public static final String OBJECT_PROPERTY_TYPE = "http://www.w3.org/1999/02/22-rdf-syntax-ns#Property";
	public static final String OWL_OBJECT_PROPERTY_TYPE = "http://www.w3.org/2002/07/owl#ObjectProperty";
	


}
