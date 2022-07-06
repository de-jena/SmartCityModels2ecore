/*
 */
package org.gecko.smartmodels.building.model.building.util;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;

import org.gecko.emf.osgi.annotation.provide.ProvideEMFResourceConfigurator;

import org.gecko.smartmodels.building.model.building.BuildingPackage;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource Factory</b> associated with the package.
 * <!-- end-user-doc -->
 * @see org.gecko.smartmodels.building.model.building.util.BuildingResourceImpl
 * @generated
 */
 @Component( name = BuildingPackage.eNAME + "Factory", service = Resource.Factory.class, scope = ServiceScope.SINGLETON)
 @ProvideEMFResourceConfigurator( name = BuildingPackage.eNAME,
	contentType = { "" }, 
	fileExtension = {
	"building"
 	},  
	version = "1.0.0"
)
public class BuildingResourceFactoryImpl extends ResourceFactoryImpl {
	/**
	 * Creates an instance of the resource factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BuildingResourceFactoryImpl() {
		super();
	}

	/**
	 * Creates an instance of the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Resource createResource(URI uri) {
		Resource result = new BuildingResourceImpl(uri);
		return result;
	}

} //BuildingResourceFactoryImpl
