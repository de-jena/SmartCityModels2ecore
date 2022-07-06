/*
 */
package org.gecko.smartmodels.building.model.building.impl;

import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.gecko.emf.osgi.EMFNamespaces;
import org.gecko.emf.osgi.EPackageConfigurator;

import org.gecko.emf.osgi.annotation.EMFModel;

import org.gecko.emf.osgi.annotation.provide.ProvideEMFModel;

import org.gecko.smartmodels.building.model.building.Address;
import org.gecko.smartmodels.building.model.building.Building;
import org.gecko.smartmodels.building.model.building.BuildingFactory;
import org.gecko.smartmodels.building.model.building.BuildingPackage;
import org.gecko.smartmodels.building.model.building.CategoryValue;
import org.gecko.smartmodels.building.model.building.TypeValue;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
@EMFModel(name=BuildingPackage.eNAME, nsURI={BuildingPackage.eNS_URI}, version="1.0.0")
@ProvideEMFModel(name = BuildingPackage.eNAME, nsURI = { BuildingPackage.eNS_URI }, version = "1.0.0")
@Component( name = BuildingPackage.eNAME, service = { BuildingPackage.class, EPackage.class }, immediate = true, scope = ServiceScope.SINGLETON)
public class BuildingPackageImpl extends EPackageImpl implements BuildingPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass buildingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addressEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum categoryValueEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum typeValueEEnum = null;


	private ServiceRegistration<EPackageConfigurator> ePackageConfiguratorRegistration = null;
	private ServiceRegistration<?> eFactoryRegistration = null;

	/**
	 * Creates an instance of the model <b>Package</b>
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.gecko.smartmodels.building.model.building.BuildingPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	public BuildingPackageImpl() {
		super();
	}

    /**
	 * Activates and initializes the Package and registers the Package {@link org.gecko.emf.osgi.EPackageConfigurator}.
	 *
     * @generated
	 */
    @Activate
	public void activate(BundleContext ctx) {
		// Create package meta-data objects
		createPackageContents();

		// Initialize created meta-data
		initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		freeze();

		setEFactoryInstance(new BuildingFactoryImpl(this));

		// register the EPackageConfigurator
		Dictionary<String, Object> properties = new Hashtable<String, Object>();
		properties.put(EMFNamespaces.EMF_MODEL_NAME, BuildingPackage.eNAME);
		properties.put(EMFNamespaces.EMF_MODEL_NSURI, BuildingPackage.eNS_URI);
		properties.put(EMFNamespaces.EMF_MODEL_FILE_EXT, "building");
		
		ePackageConfiguratorRegistration = ctx.registerService(EPackageConfigurator.class, new BuildingEPackageConfigurator(this), properties);
		
		//regsiter the EFactory as a service
		eFactoryRegistration = ctx.registerService(new String[]{EFactory.class.getName(), BuildingFactory.class.getName()}, getBuildingFactory(), properties);
	}
	
	@Deactivate
	public void deactivate() {
		if(ePackageConfiguratorRegistration != null){
			ePackageConfiguratorRegistration.unregister();
		}
		if(eFactoryRegistration != null){
			eFactoryRegistration.unregister();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBuilding() {
		return buildingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBuilding_Address() {
		return (EReference)buildingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBuilding_AlternateName() {
		return (EAttribute)buildingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBuilding_AreaServed() {
		return (EAttribute)buildingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBuilding_Category() {
		return (EAttribute)buildingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBuilding_CollapseRisk() {
		return (EAttribute)buildingEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBuilding_DataProvider() {
		return (EAttribute)buildingEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBuilding_DateCreated() {
		return (EAttribute)buildingEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBuilding_DateModified() {
		return (EAttribute)buildingEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBuilding_Description() {
		return (EAttribute)buildingEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBuilding_FloorsAboveGround() {
		return (EAttribute)buildingEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBuilding_FloorsBelowGround() {
		return (EAttribute)buildingEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBuilding_Id() {
		return (EAttribute)buildingEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBuilding_Name() {
		return (EAttribute)buildingEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBuilding_Occupier() {
		return (EAttribute)buildingEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBuilding_OpeningHours() {
		return (EAttribute)buildingEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBuilding_Owner() {
		return (EAttribute)buildingEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBuilding_PeopleCapacity() {
		return (EAttribute)buildingEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBuilding_PeopleOccupancy() {
		return (EAttribute)buildingEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBuilding_RefMap() {
		return (EAttribute)buildingEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBuilding_Source() {
		return (EAttribute)buildingEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBuilding_Type() {
		return (EAttribute)buildingEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAddress() {
		return addressEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAddress_AddressCountry() {
		return (EAttribute)addressEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAddress_AddressLocality() {
		return (EAttribute)addressEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAddress_AddressRegion() {
		return (EAttribute)addressEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAddress_PostOfficeBoxNumber() {
		return (EAttribute)addressEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAddress_PostalCode() {
		return (EAttribute)addressEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAddress_StreetAddress() {
		return (EAttribute)addressEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getCategoryValue() {
		return categoryValueEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getTypeValue() {
		return typeValueEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BuildingFactory getBuildingFactory() {
		return (BuildingFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		buildingEClass = createEClass(BUILDING);
		createEReference(buildingEClass, BUILDING__ADDRESS);
		createEAttribute(buildingEClass, BUILDING__ALTERNATE_NAME);
		createEAttribute(buildingEClass, BUILDING__AREA_SERVED);
		createEAttribute(buildingEClass, BUILDING__CATEGORY);
		createEAttribute(buildingEClass, BUILDING__COLLAPSE_RISK);
		createEAttribute(buildingEClass, BUILDING__DATA_PROVIDER);
		createEAttribute(buildingEClass, BUILDING__DATE_CREATED);
		createEAttribute(buildingEClass, BUILDING__DATE_MODIFIED);
		createEAttribute(buildingEClass, BUILDING__DESCRIPTION);
		createEAttribute(buildingEClass, BUILDING__FLOORS_ABOVE_GROUND);
		createEAttribute(buildingEClass, BUILDING__FLOORS_BELOW_GROUND);
		createEAttribute(buildingEClass, BUILDING__ID);
		createEAttribute(buildingEClass, BUILDING__NAME);
		createEAttribute(buildingEClass, BUILDING__OCCUPIER);
		createEAttribute(buildingEClass, BUILDING__OPENING_HOURS);
		createEAttribute(buildingEClass, BUILDING__OWNER);
		createEAttribute(buildingEClass, BUILDING__PEOPLE_CAPACITY);
		createEAttribute(buildingEClass, BUILDING__PEOPLE_OCCUPANCY);
		createEAttribute(buildingEClass, BUILDING__REF_MAP);
		createEAttribute(buildingEClass, BUILDING__SOURCE);
		createEAttribute(buildingEClass, BUILDING__TYPE);

		addressEClass = createEClass(ADDRESS);
		createEAttribute(addressEClass, ADDRESS__ADDRESS_COUNTRY);
		createEAttribute(addressEClass, ADDRESS__ADDRESS_LOCALITY);
		createEAttribute(addressEClass, ADDRESS__ADDRESS_REGION);
		createEAttribute(addressEClass, ADDRESS__POST_OFFICE_BOX_NUMBER);
		createEAttribute(addressEClass, ADDRESS__POSTAL_CODE);
		createEAttribute(addressEClass, ADDRESS__STREET_ADDRESS);

		// Create enums
		categoryValueEEnum = createEEnum(CATEGORY_VALUE);
		typeValueEEnum = createEEnum(TYPE_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(buildingEClass, Building.class, "Building", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBuilding_Address(), this.getAddress(), null, "address", null, 1, 1, Building.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBuilding_AlternateName(), ecorePackage.getEString(), "alternateName", null, 0, 1, Building.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBuilding_AreaServed(), ecorePackage.getEString(), "areaServed", null, 0, 1, Building.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBuilding_Category(), this.getCategoryValue(), "category", null, 1, -1, Building.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBuilding_CollapseRisk(), ecorePackage.getEDoubleObject(), "collapseRisk", null, 0, 1, Building.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBuilding_DataProvider(), ecorePackage.getEString(), "dataProvider", null, 0, 1, Building.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBuilding_DateCreated(), ecorePackage.getEString(), "dateCreated", null, 0, 1, Building.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBuilding_DateModified(), ecorePackage.getEString(), "dateModified", null, 0, 1, Building.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBuilding_Description(), ecorePackage.getEString(), "description", null, 0, 1, Building.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBuilding_FloorsAboveGround(), ecorePackage.getEIntegerObject(), "floorsAboveGround", null, 0, 1, Building.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBuilding_FloorsBelowGround(), ecorePackage.getEIntegerObject(), "floorsBelowGround", null, 0, 1, Building.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBuilding_Id(), ecorePackage.getEString(), "id", null, 1, 1, Building.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBuilding_Name(), ecorePackage.getEString(), "name", null, 0, 1, Building.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBuilding_Occupier(), ecorePackage.getEString(), "occupier", null, 0, -1, Building.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBuilding_OpeningHours(), ecorePackage.getEString(), "openingHours", null, 0, -1, Building.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBuilding_Owner(), ecorePackage.getEString(), "owner", null, 0, -1, Building.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBuilding_PeopleCapacity(), ecorePackage.getEDoubleObject(), "peopleCapacity", null, 0, 1, Building.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBuilding_PeopleOccupancy(), ecorePackage.getEDoubleObject(), "peopleOccupancy", null, 0, 1, Building.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBuilding_RefMap(), ecorePackage.getEString(), "refMap", null, 0, 1, Building.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBuilding_Source(), ecorePackage.getEString(), "source", null, 0, 1, Building.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBuilding_Type(), this.getTypeValue(), "type", null, 1, 1, Building.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addressEClass, Address.class, "Address", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAddress_AddressCountry(), ecorePackage.getEString(), "addressCountry", null, 0, 1, Address.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAddress_AddressLocality(), ecorePackage.getEString(), "addressLocality", null, 0, 1, Address.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAddress_AddressRegion(), ecorePackage.getEString(), "addressRegion", null, 0, 1, Address.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAddress_PostOfficeBoxNumber(), ecorePackage.getEString(), "postOfficeBoxNumber", null, 0, 1, Address.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAddress_PostalCode(), ecorePackage.getEString(), "postalCode", null, 0, 1, Address.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAddress_StreetAddress(), ecorePackage.getEString(), "streetAddress", null, 0, 1, Address.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(categoryValueEEnum, CategoryValue.class, "CategoryValue");
		addEEnumLiteral(categoryValueEEnum, CategoryValue.APARTMENTS);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.BAKEHOUSE);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.BARN);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.BRIDGE);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.BUNGALOW);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.BUNKER);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.CATHEDRAL);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.CABIN);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.CARPORT);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.CHAPEL);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.CHURCH);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.CIVIC);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.COMMERCIAL);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.CONSERVATORY);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.CONSTRUCTION);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.COWSHED);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.DETACHED);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.DIGESTER);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.DORMITORY);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.FARM);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.FARM_AUXILIARY);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.GARAGE);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.GARAGES);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.GARBAGE_SHED);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.GRANDSTAND);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.GREENHOUSE);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.HANGAR);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.HOSPITAL);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.HOTEL);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.HOUSE);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.HOUSEBOAT);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.HUT);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.INDUSTRIAL);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.KINDERGARTEN);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.KIOSK);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.MOSQUE);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.OFFICE);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.PARKING);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.PAVILION);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.PUBLIC);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.RESIDENTIAL);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.RETAIL);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.RIDING_HALL);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.ROOF);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.RUINS);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.SCHOOL);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.SERVICE);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.SHED);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.SHRINE);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.STABLE);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.STADIUM);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.STATIC_CARAVAN);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.STY);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.SYNAGOGUE);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.TEMPLE);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.TERRACE);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.TRAIN_STATION);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.TRANSFORMER_TOWER);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.TRANSPORTATION);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.UNIVERSITY);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.WAREHOUSE);
		addEEnumLiteral(categoryValueEEnum, CategoryValue.WATER_TOWER);

		initEEnum(typeValueEEnum, TypeValue.class, "TypeValue");
		addEEnumLiteral(typeValueEEnum, TypeValue.BUILDING);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/GenModel
		createGenModelAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/GenModel</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGenModelAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/GenModel";
		addAnnotation
		  (buildingEClass,
		   source,
		   new String[] {
			   "documentation", "Information on a given Building"
		   });
		addAnnotation
		  (getBuilding_Address(),
		   source,
		   new String[] {
			   "documentation", "The mailing address"
		   });
		addAnnotation
		  (getBuilding_AlternateName(),
		   source,
		   new String[] {
			   "documentation", "An alternative name for this item"
		   });
		addAnnotation
		  (getBuilding_AreaServed(),
		   source,
		   new String[] {
			   "documentation", "The geographic area where a service or offered item is provided"
		   });
		addAnnotation
		  (getBuilding_CollapseRisk(),
		   source,
		   new String[] {
			   "documentation", "Probability of total collapse of the building."
		   });
		addAnnotation
		  (getBuilding_DataProvider(),
		   source,
		   new String[] {
			   "documentation", "A sequence of characters identifying the provider of the harmonised data entity."
		   });
		addAnnotation
		  (getBuilding_DateCreated(),
		   source,
		   new String[] {
			   "documentation", "Entity creation timestamp. This will usually be allocated by the storage platform."
		   });
		addAnnotation
		  (getBuilding_DateModified(),
		   source,
		   new String[] {
			   "documentation", "Timestamp of the last modification of the entity. This will usually be allocated by the storage platform."
		   });
		addAnnotation
		  (getBuilding_Description(),
		   source,
		   new String[] {
			   "documentation", "A description of this item"
		   });
		addAnnotation
		  (getBuilding_FloorsAboveGround(),
		   source,
		   new String[] {
			   "documentation", "Floors above the ground level"
		   });
		addAnnotation
		  (getBuilding_FloorsBelowGround(),
		   source,
		   new String[] {
			   "documentation", "Floors below the ground level"
		   });
		addAnnotation
		  (getBuilding_Id(),
		   source,
		   new String[] {
			   "documentation", "Unique identifier of the entity"
		   });
		addAnnotation
		  (getBuilding_Name(),
		   source,
		   new String[] {
			   "documentation", "The name of this item."
		   });
		addAnnotation
		  (getBuilding_Occupier(),
		   source,
		   new String[] {
			   "documentation", "Person or entity using the building"
		   });
		addAnnotation
		  (getBuilding_Owner(),
		   source,
		   new String[] {
			   "documentation", "A List containing a JSON encoded sequence of characters referencing the unique Ids of the owner(s)"
		   });
		addAnnotation
		  (getBuilding_PeopleCapacity(),
		   source,
		   new String[] {
			   "documentation", "Allowed people present at the building"
		   });
		addAnnotation
		  (getBuilding_PeopleOccupancy(),
		   source,
		   new String[] {
			   "documentation", "People present at the building"
		   });
		addAnnotation
		  (getBuilding_RefMap(),
		   source,
		   new String[] {
			   "documentation", "Reference to the map containing the building"
		   });
		addAnnotation
		  (getBuilding_Source(),
		   source,
		   new String[] {
			   "documentation", "A sequence of characters giving the original source of the entity data as a URL. Recommended to be the fully qualified domain name of the source provider, or the URL to the source object."
		   });
		addAnnotation
		  (getBuilding_Type(),
		   source,
		   new String[] {
			   "documentation", "NGSI Entity type"
		   });
		addAnnotation
		  (addressEClass,
		   source,
		   new String[] {
			   "documentation", "The mailing address"
		   });
		addAnnotation
		  (getAddress_AddressCountry(),
		   source,
		   new String[] {
			   "documentation", "Property. The country. For example, Spain. Model:\'https://schema.org/addressCountry\'"
		   });
		addAnnotation
		  (getAddress_AddressLocality(),
		   source,
		   new String[] {
			   "documentation", "Property. The locality in which the street address is, and which is in the region. Model:\'https://schema.org/addressLocality\'"
		   });
		addAnnotation
		  (getAddress_AddressRegion(),
		   source,
		   new String[] {
			   "documentation", "Property. The region in which the locality is, and which is in the country. Model:\'https://schema.org/addressRegion\'"
		   });
		addAnnotation
		  (getAddress_PostOfficeBoxNumber(),
		   source,
		   new String[] {
			   "documentation", "Property. The post office box number for PO box addresses. For example, 03578. Model:\'https://schema.org/postOfficeBoxNumber\'"
		   });
		addAnnotation
		  (getAddress_PostalCode(),
		   source,
		   new String[] {
			   "documentation", "Property. The postal code. For example, 24004. Model:\'https://schema.org/https://schema.org/postalCode\'"
		   });
		addAnnotation
		  (getAddress_StreetAddress(),
		   source,
		   new String[] {
			   "documentation", "Property. The street address. Model:\'https://schema.org/streetAddress\'"
		   });
	}

} //BuildingPackageImpl
