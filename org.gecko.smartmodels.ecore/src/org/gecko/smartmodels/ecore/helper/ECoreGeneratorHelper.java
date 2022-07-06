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
package org.gecko.smartmodels.ecore.helper;

import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;

/**
 * 
 * @author ilenia
 * @since Jun 22, 2022
 */
public class ECoreGeneratorHelper {
	
	public static final String ANNOTAION_DOC_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";

	private ECoreGeneratorHelper() {};

	public static EPackage createPackage(final String name, final String prefix, final String uri) {
		final EPackage epackage = EcoreFactory.eINSTANCE.createEPackage();
		epackage.setName(name);
		epackage.setNsPrefix(prefix);
		epackage.setNsURI(uri);
		return epackage;
	}

	public static EClass createEClass(final String name) {
		final EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName(name);
		return eClass;
	}
	
	public static EEnum createEEnum(final String name, final List<String> values) {
		final EEnum eEnum = EcoreFactory.eINSTANCE.createEEnum();
		eEnum.setName(name);
		values.stream().forEach(v -> {
			final EEnumLiteral literal = EcoreFactory.eINSTANCE.createEEnumLiteral();
			literal.setName(v);
			literal.setValue(eEnum.getELiterals().size());
			eEnum.getELiterals().add(literal);
		});
		return eEnum;
	}

	public static void addAttribute(EClass eClass, String name, EClassifier type, boolean isId, 
			int lowerBound, int upperBound, String description) {
		final EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
		// always add to container first
		eClass.getEStructuralFeatures().add(attribute);
		attribute.setName(name);
		attribute.setEType(type);
		attribute.setID(isId);
		attribute.setLowerBound(lowerBound);
		attribute.setUpperBound(upperBound);
		if(description != null) {
			addDocumentation(attribute, description);
		}
	}

	public static void addReference(EClass eClass, String name, EClassifier type, 
			int lowerBound, int upperBound, String description, boolean isContainment) {
		final EReference reference = EcoreFactory.eINSTANCE.createEReference();
		// always add to container first
		eClass.getEStructuralFeatures().add(reference);
		reference.setName(name);
		reference.setEType(type);
		reference.setLowerBound(lowerBound);
		reference.setUpperBound(upperBound);
		reference.setContainment(isContainment);
		if(description != null) {
			addDocumentation(reference, description);
		}
	}
	
	public static void addDocumentation(EClassifier type, String description) {
		if(description == null) {
			return;
		}
		final EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
		annotation.setSource(ANNOTAION_DOC_SOURCE);
		annotation.getDetails().put("documentation", description);
		type.getEAnnotations().add(annotation);
	}
	
	public static void addDocumentation(EStructuralFeature feature, String description) {
		if(description == null) {
			return;
		}
		final EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
		annotation.setSource(ANNOTAION_DOC_SOURCE);
		annotation.getDetails().put("documentation", description);
		feature.getEAnnotations().add(annotation);
	}
}
