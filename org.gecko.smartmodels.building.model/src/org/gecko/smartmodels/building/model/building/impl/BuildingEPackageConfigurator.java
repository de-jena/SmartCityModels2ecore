/*
 */
package org.gecko.smartmodels.building.model.building.impl;

import org.gecko.emf.osgi.EPackageConfigurator;

import org.gecko.smartmodels.building.model.building.BuildingPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>EPackageConfiguration</b> and <b>ResourceFactoryConfigurator</b> for the model.
 * The package will be registered into a OSGi base model registry.
 * <!-- end-user-doc -->
 * @see EPackageConfigurator
 * @generated
 */
public class BuildingEPackageConfigurator implements EPackageConfigurator {
	
	private BuildingPackage ePackage;

	protected BuildingEPackageConfigurator(BuildingPackage ePackage){
		this.ePackage = ePackage;
	}
	
	/* 
	 * (non-Javadoc)
	 * @see org.gecko.emf.osgi.EPackageRegistryConfigurator#configureEPackage(org.eclipse.emf.ecore.EPackage.Registry)
	 * @generated
	 */
	@Override
	public void configureEPackage(org.eclipse.emf.ecore.EPackage.Registry registry) {
		registry.put(BuildingPackage.eNS_URI, ePackage);
	}
	
	/* 
	 * (non-Javadoc)
	 * @see org.gecko.emf.osgi.EPackageRegistryConfigurator#unconfigureEPackage(org.eclipse.emf.ecore.EPackage.Registry)
	 * @generated
	 */
	@Override
	public void unconfigureEPackage(org.eclipse.emf.ecore.EPackage.Registry registry) {
		registry.remove(BuildingPackage.eNS_URI);
	}
}