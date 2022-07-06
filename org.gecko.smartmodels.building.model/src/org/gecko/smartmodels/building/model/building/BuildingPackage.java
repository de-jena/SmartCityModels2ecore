/*
 */
package org.gecko.smartmodels.building.model.building;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.gecko.smartmodels.building.model.building.BuildingFactory
 * @model kind="package"
 * @generated
 */
public interface BuildingPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "building";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://smartmodels.com/building/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "building";
	
	/**
	 * The meta object id for the '{@link org.gecko.smartmodels.building.model.building.impl.BuildingImpl <em>Building</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.smartmodels.building.model.building.impl.BuildingImpl
	 * @see org.gecko.smartmodels.building.model.building.impl.BuildingPackageImpl#getBuilding()
	 * @generated
	 */
	int BUILDING = 0;

	/**
	 * The feature id for the '<em><b>Address</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING__ADDRESS = 0;

	/**
	 * The feature id for the '<em><b>Alternate Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING__ALTERNATE_NAME = 1;

	/**
	 * The feature id for the '<em><b>Area Served</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING__AREA_SERVED = 2;

	/**
	 * The feature id for the '<em><b>Category</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING__CATEGORY = 3;

	/**
	 * The feature id for the '<em><b>Collapse Risk</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING__COLLAPSE_RISK = 4;

	/**
	 * The feature id for the '<em><b>Data Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING__DATA_PROVIDER = 5;

	/**
	 * The feature id for the '<em><b>Date Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING__DATE_CREATED = 6;

	/**
	 * The feature id for the '<em><b>Date Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING__DATE_MODIFIED = 7;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING__DESCRIPTION = 8;

	/**
	 * The feature id for the '<em><b>Floors Above Ground</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING__FLOORS_ABOVE_GROUND = 9;

	/**
	 * The feature id for the '<em><b>Floors Below Ground</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING__FLOORS_BELOW_GROUND = 10;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING__ID = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING__NAME = 12;

	/**
	 * The feature id for the '<em><b>Occupier</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING__OCCUPIER = 13;

	/**
	 * The feature id for the '<em><b>Opening Hours</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING__OPENING_HOURS = 14;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING__OWNER = 15;

	/**
	 * The feature id for the '<em><b>People Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING__PEOPLE_CAPACITY = 16;

	/**
	 * The feature id for the '<em><b>People Occupancy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING__PEOPLE_OCCUPANCY = 17;

	/**
	 * The feature id for the '<em><b>Ref Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING__REF_MAP = 18;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING__SOURCE = 19;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING__TYPE = 20;

	/**
	 * The number of structural features of the '<em>Building</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING_FEATURE_COUNT = 21;

	/**
	 * The number of operations of the '<em>Building</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING_OPERATION_COUNT = 0;

	
	/**
	 * The meta object id for the '{@link org.gecko.smartmodels.building.model.building.impl.AddressImpl <em>Address</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.smartmodels.building.model.building.impl.AddressImpl
	 * @see org.gecko.smartmodels.building.model.building.impl.BuildingPackageImpl#getAddress()
	 * @generated
	 */
	int ADDRESS = 1;

	/**
	 * The feature id for the '<em><b>Address Country</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS__ADDRESS_COUNTRY = 0;

	/**
	 * The feature id for the '<em><b>Address Locality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS__ADDRESS_LOCALITY = 1;

	/**
	 * The feature id for the '<em><b>Address Region</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS__ADDRESS_REGION = 2;

	/**
	 * The feature id for the '<em><b>Post Office Box Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS__POST_OFFICE_BOX_NUMBER = 3;

	/**
	 * The feature id for the '<em><b>Postal Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS__POSTAL_CODE = 4;

	/**
	 * The feature id for the '<em><b>Street Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS__STREET_ADDRESS = 5;

	/**
	 * The number of structural features of the '<em>Address</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Address</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDRESS_OPERATION_COUNT = 0;

	
	/**
	 * The meta object id for the '{@link org.gecko.smartmodels.building.model.building.CategoryValue <em>Category Value</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.smartmodels.building.model.building.CategoryValue
	 * @see org.gecko.smartmodels.building.model.building.impl.BuildingPackageImpl#getCategoryValue()
	 * @generated
	 */
	int CATEGORY_VALUE = 2;

	
	/**
	 * The meta object id for the '{@link org.gecko.smartmodels.building.model.building.TypeValue <em>Type Value</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gecko.smartmodels.building.model.building.TypeValue
	 * @see org.gecko.smartmodels.building.model.building.impl.BuildingPackageImpl#getTypeValue()
	 * @generated
	 */
	int TYPE_VALUE = 3;


	/**
	 * Returns the meta object for class '{@link org.gecko.smartmodels.building.model.building.Building <em>Building</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Building</em>'.
	 * @see org.gecko.smartmodels.building.model.building.Building
	 * @generated
	 */
	EClass getBuilding();

	/**
	 * Returns the meta object for the containment reference '{@link org.gecko.smartmodels.building.model.building.Building#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Address</em>'.
	 * @see org.gecko.smartmodels.building.model.building.Building#getAddress()
	 * @see #getBuilding()
	 * @generated
	 */
	EReference getBuilding_Address();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.smartmodels.building.model.building.Building#getAlternateName <em>Alternate Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alternate Name</em>'.
	 * @see org.gecko.smartmodels.building.model.building.Building#getAlternateName()
	 * @see #getBuilding()
	 * @generated
	 */
	EAttribute getBuilding_AlternateName();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.smartmodels.building.model.building.Building#getAreaServed <em>Area Served</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Area Served</em>'.
	 * @see org.gecko.smartmodels.building.model.building.Building#getAreaServed()
	 * @see #getBuilding()
	 * @generated
	 */
	EAttribute getBuilding_AreaServed();

	/**
	 * Returns the meta object for the attribute list '{@link org.gecko.smartmodels.building.model.building.Building#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Category</em>'.
	 * @see org.gecko.smartmodels.building.model.building.Building#getCategory()
	 * @see #getBuilding()
	 * @generated
	 */
	EAttribute getBuilding_Category();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.smartmodels.building.model.building.Building#getCollapseRisk <em>Collapse Risk</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Collapse Risk</em>'.
	 * @see org.gecko.smartmodels.building.model.building.Building#getCollapseRisk()
	 * @see #getBuilding()
	 * @generated
	 */
	EAttribute getBuilding_CollapseRisk();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.smartmodels.building.model.building.Building#getDataProvider <em>Data Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Provider</em>'.
	 * @see org.gecko.smartmodels.building.model.building.Building#getDataProvider()
	 * @see #getBuilding()
	 * @generated
	 */
	EAttribute getBuilding_DataProvider();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.smartmodels.building.model.building.Building#getDateCreated <em>Date Created</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date Created</em>'.
	 * @see org.gecko.smartmodels.building.model.building.Building#getDateCreated()
	 * @see #getBuilding()
	 * @generated
	 */
	EAttribute getBuilding_DateCreated();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.smartmodels.building.model.building.Building#getDateModified <em>Date Modified</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date Modified</em>'.
	 * @see org.gecko.smartmodels.building.model.building.Building#getDateModified()
	 * @see #getBuilding()
	 * @generated
	 */
	EAttribute getBuilding_DateModified();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.smartmodels.building.model.building.Building#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.gecko.smartmodels.building.model.building.Building#getDescription()
	 * @see #getBuilding()
	 * @generated
	 */
	EAttribute getBuilding_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.smartmodels.building.model.building.Building#getFloorsAboveGround <em>Floors Above Ground</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Floors Above Ground</em>'.
	 * @see org.gecko.smartmodels.building.model.building.Building#getFloorsAboveGround()
	 * @see #getBuilding()
	 * @generated
	 */
	EAttribute getBuilding_FloorsAboveGround();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.smartmodels.building.model.building.Building#getFloorsBelowGround <em>Floors Below Ground</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Floors Below Ground</em>'.
	 * @see org.gecko.smartmodels.building.model.building.Building#getFloorsBelowGround()
	 * @see #getBuilding()
	 * @generated
	 */
	EAttribute getBuilding_FloorsBelowGround();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.smartmodels.building.model.building.Building#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.gecko.smartmodels.building.model.building.Building#getId()
	 * @see #getBuilding()
	 * @generated
	 */
	EAttribute getBuilding_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.smartmodels.building.model.building.Building#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.gecko.smartmodels.building.model.building.Building#getName()
	 * @see #getBuilding()
	 * @generated
	 */
	EAttribute getBuilding_Name();

	/**
	 * Returns the meta object for the attribute list '{@link org.gecko.smartmodels.building.model.building.Building#getOccupier <em>Occupier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Occupier</em>'.
	 * @see org.gecko.smartmodels.building.model.building.Building#getOccupier()
	 * @see #getBuilding()
	 * @generated
	 */
	EAttribute getBuilding_Occupier();

	/**
	 * Returns the meta object for the attribute list '{@link org.gecko.smartmodels.building.model.building.Building#getOpeningHours <em>Opening Hours</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Opening Hours</em>'.
	 * @see org.gecko.smartmodels.building.model.building.Building#getOpeningHours()
	 * @see #getBuilding()
	 * @generated
	 */
	EAttribute getBuilding_OpeningHours();

	/**
	 * Returns the meta object for the attribute list '{@link org.gecko.smartmodels.building.model.building.Building#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Owner</em>'.
	 * @see org.gecko.smartmodels.building.model.building.Building#getOwner()
	 * @see #getBuilding()
	 * @generated
	 */
	EAttribute getBuilding_Owner();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.smartmodels.building.model.building.Building#getPeopleCapacity <em>People Capacity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>People Capacity</em>'.
	 * @see org.gecko.smartmodels.building.model.building.Building#getPeopleCapacity()
	 * @see #getBuilding()
	 * @generated
	 */
	EAttribute getBuilding_PeopleCapacity();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.smartmodels.building.model.building.Building#getPeopleOccupancy <em>People Occupancy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>People Occupancy</em>'.
	 * @see org.gecko.smartmodels.building.model.building.Building#getPeopleOccupancy()
	 * @see #getBuilding()
	 * @generated
	 */
	EAttribute getBuilding_PeopleOccupancy();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.smartmodels.building.model.building.Building#getRefMap <em>Ref Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ref Map</em>'.
	 * @see org.gecko.smartmodels.building.model.building.Building#getRefMap()
	 * @see #getBuilding()
	 * @generated
	 */
	EAttribute getBuilding_RefMap();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.smartmodels.building.model.building.Building#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see org.gecko.smartmodels.building.model.building.Building#getSource()
	 * @see #getBuilding()
	 * @generated
	 */
	EAttribute getBuilding_Source();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.smartmodels.building.model.building.Building#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.gecko.smartmodels.building.model.building.Building#getType()
	 * @see #getBuilding()
	 * @generated
	 */
	EAttribute getBuilding_Type();

	/**
	 * Returns the meta object for class '{@link org.gecko.smartmodels.building.model.building.Address <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Address</em>'.
	 * @see org.gecko.smartmodels.building.model.building.Address
	 * @generated
	 */
	EClass getAddress();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.smartmodels.building.model.building.Address#getAddressCountry <em>Address Country</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Address Country</em>'.
	 * @see org.gecko.smartmodels.building.model.building.Address#getAddressCountry()
	 * @see #getAddress()
	 * @generated
	 */
	EAttribute getAddress_AddressCountry();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.smartmodels.building.model.building.Address#getAddressLocality <em>Address Locality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Address Locality</em>'.
	 * @see org.gecko.smartmodels.building.model.building.Address#getAddressLocality()
	 * @see #getAddress()
	 * @generated
	 */
	EAttribute getAddress_AddressLocality();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.smartmodels.building.model.building.Address#getAddressRegion <em>Address Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Address Region</em>'.
	 * @see org.gecko.smartmodels.building.model.building.Address#getAddressRegion()
	 * @see #getAddress()
	 * @generated
	 */
	EAttribute getAddress_AddressRegion();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.smartmodels.building.model.building.Address#getPostOfficeBoxNumber <em>Post Office Box Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Post Office Box Number</em>'.
	 * @see org.gecko.smartmodels.building.model.building.Address#getPostOfficeBoxNumber()
	 * @see #getAddress()
	 * @generated
	 */
	EAttribute getAddress_PostOfficeBoxNumber();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.smartmodels.building.model.building.Address#getPostalCode <em>Postal Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Postal Code</em>'.
	 * @see org.gecko.smartmodels.building.model.building.Address#getPostalCode()
	 * @see #getAddress()
	 * @generated
	 */
	EAttribute getAddress_PostalCode();

	/**
	 * Returns the meta object for the attribute '{@link org.gecko.smartmodels.building.model.building.Address#getStreetAddress <em>Street Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Street Address</em>'.
	 * @see org.gecko.smartmodels.building.model.building.Address#getStreetAddress()
	 * @see #getAddress()
	 * @generated
	 */
	EAttribute getAddress_StreetAddress();

	/**
	 * Returns the meta object for enum '{@link org.gecko.smartmodels.building.model.building.CategoryValue <em>Category Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Category Value</em>'.
	 * @see org.gecko.smartmodels.building.model.building.CategoryValue
	 * @generated
	 */
	EEnum getCategoryValue();

	/**
	 * Returns the meta object for enum '{@link org.gecko.smartmodels.building.model.building.TypeValue <em>Type Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type Value</em>'.
	 * @see org.gecko.smartmodels.building.model.building.TypeValue
	 * @generated
	 */
	EEnum getTypeValue();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BuildingFactory getBuildingFactory();

} //BuildingPackage
