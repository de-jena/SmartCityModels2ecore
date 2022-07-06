/*
 */
package org.gecko.smartmodels.building.model.building.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.gecko.smartmodels.building.model.building.Address;
import org.gecko.smartmodels.building.model.building.Building;
import org.gecko.smartmodels.building.model.building.BuildingPackage;
import org.gecko.smartmodels.building.model.building.CategoryValue;
import org.gecko.smartmodels.building.model.building.TypeValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Building</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.smartmodels.building.model.building.impl.BuildingImpl#getAddress <em>Address</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.impl.BuildingImpl#getAlternateName <em>Alternate Name</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.impl.BuildingImpl#getAreaServed <em>Area Served</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.impl.BuildingImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.impl.BuildingImpl#getCollapseRisk <em>Collapse Risk</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.impl.BuildingImpl#getDataProvider <em>Data Provider</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.impl.BuildingImpl#getDateCreated <em>Date Created</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.impl.BuildingImpl#getDateModified <em>Date Modified</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.impl.BuildingImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.impl.BuildingImpl#getFloorsAboveGround <em>Floors Above Ground</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.impl.BuildingImpl#getFloorsBelowGround <em>Floors Below Ground</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.impl.BuildingImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.impl.BuildingImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.impl.BuildingImpl#getOccupier <em>Occupier</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.impl.BuildingImpl#getOpeningHours <em>Opening Hours</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.impl.BuildingImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.impl.BuildingImpl#getPeopleCapacity <em>People Capacity</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.impl.BuildingImpl#getPeopleOccupancy <em>People Occupancy</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.impl.BuildingImpl#getRefMap <em>Ref Map</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.impl.BuildingImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.impl.BuildingImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BuildingImpl extends MinimalEObjectImpl.Container implements Building {
	/**
	 * The cached value of the '{@link #getAddress() <em>Address</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddress()
	 * @generated
	 * @ordered
	 */
	protected Address address;

	/**
	 * The default value of the '{@link #getAlternateName() <em>Alternate Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlternateName()
	 * @generated
	 * @ordered
	 */
	protected static final String ALTERNATE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAlternateName() <em>Alternate Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlternateName()
	 * @generated
	 * @ordered
	 */
	protected String alternateName = ALTERNATE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getAreaServed() <em>Area Served</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAreaServed()
	 * @generated
	 * @ordered
	 */
	protected static final String AREA_SERVED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAreaServed() <em>Area Served</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAreaServed()
	 * @generated
	 * @ordered
	 */
	protected String areaServed = AREA_SERVED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCategory() <em>Category</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected EList<CategoryValue> category;

	/**
	 * The default value of the '{@link #getCollapseRisk() <em>Collapse Risk</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollapseRisk()
	 * @generated
	 * @ordered
	 */
	protected static final Double COLLAPSE_RISK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCollapseRisk() <em>Collapse Risk</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollapseRisk()
	 * @generated
	 * @ordered
	 */
	protected Double collapseRisk = COLLAPSE_RISK_EDEFAULT;

	/**
	 * The default value of the '{@link #getDataProvider() <em>Data Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataProvider()
	 * @generated
	 * @ordered
	 */
	protected static final String DATA_PROVIDER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDataProvider() <em>Data Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataProvider()
	 * @generated
	 * @ordered
	 */
	protected String dataProvider = DATA_PROVIDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getDateCreated() <em>Date Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateCreated()
	 * @generated
	 * @ordered
	 */
	protected static final String DATE_CREATED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDateCreated() <em>Date Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateCreated()
	 * @generated
	 * @ordered
	 */
	protected String dateCreated = DATE_CREATED_EDEFAULT;

	/**
	 * The default value of the '{@link #getDateModified() <em>Date Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateModified()
	 * @generated
	 * @ordered
	 */
	protected static final String DATE_MODIFIED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDateModified() <em>Date Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateModified()
	 * @generated
	 * @ordered
	 */
	protected String dateModified = DATE_MODIFIED_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getFloorsAboveGround() <em>Floors Above Ground</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFloorsAboveGround()
	 * @generated
	 * @ordered
	 */
	protected static final Integer FLOORS_ABOVE_GROUND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFloorsAboveGround() <em>Floors Above Ground</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFloorsAboveGround()
	 * @generated
	 * @ordered
	 */
	protected Integer floorsAboveGround = FLOORS_ABOVE_GROUND_EDEFAULT;

	/**
	 * The default value of the '{@link #getFloorsBelowGround() <em>Floors Below Ground</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFloorsBelowGround()
	 * @generated
	 * @ordered
	 */
	protected static final Integer FLOORS_BELOW_GROUND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFloorsBelowGround() <em>Floors Below Ground</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFloorsBelowGround()
	 * @generated
	 * @ordered
	 */
	protected Integer floorsBelowGround = FLOORS_BELOW_GROUND_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOccupier() <em>Occupier</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOccupier()
	 * @generated
	 * @ordered
	 */
	protected EList<String> occupier;

	/**
	 * The cached value of the '{@link #getOpeningHours() <em>Opening Hours</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpeningHours()
	 * @generated
	 * @ordered
	 */
	protected EList<String> openingHours;

	/**
	 * The cached value of the '{@link #getOwner() <em>Owner</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	protected EList<String> owner;

	/**
	 * The default value of the '{@link #getPeopleCapacity() <em>People Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeopleCapacity()
	 * @generated
	 * @ordered
	 */
	protected static final Double PEOPLE_CAPACITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPeopleCapacity() <em>People Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeopleCapacity()
	 * @generated
	 * @ordered
	 */
	protected Double peopleCapacity = PEOPLE_CAPACITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getPeopleOccupancy() <em>People Occupancy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeopleOccupancy()
	 * @generated
	 * @ordered
	 */
	protected static final Double PEOPLE_OCCUPANCY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPeopleOccupancy() <em>People Occupancy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeopleOccupancy()
	 * @generated
	 * @ordered
	 */
	protected Double peopleOccupancy = PEOPLE_OCCUPANCY_EDEFAULT;

	/**
	 * The default value of the '{@link #getRefMap() <em>Ref Map</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefMap()
	 * @generated
	 * @ordered
	 */
	protected static final String REF_MAP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRefMap() <em>Ref Map</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefMap()
	 * @generated
	 * @ordered
	 */
	protected String refMap = REF_MAP_EDEFAULT;

	/**
	 * The default value of the '{@link #getSource() <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected String source = SOURCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final TypeValue TYPE_EDEFAULT = TypeValue.BUILDING;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected TypeValue type = TYPE_EDEFAULT;


	private final BuildingPackage ePackage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BuildingImpl(EClass instanceEClass) {
		super();
		this.ePackage = (BuildingPackage) instanceEClass.getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ePackage.getBuilding();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Address getAddress() {
		return address;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAddress(Address newAddress, NotificationChain msgs) {
		Address oldAddress = address;
		address = newAddress;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BuildingPackage.BUILDING__ADDRESS, oldAddress, newAddress);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAddress(Address newAddress) {
		if (newAddress != address) {
			NotificationChain msgs = null;
			if (address != null)
				msgs = ((InternalEObject)address).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BuildingPackage.BUILDING__ADDRESS, null, msgs);
			if (newAddress != null)
				msgs = ((InternalEObject)newAddress).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BuildingPackage.BUILDING__ADDRESS, null, msgs);
			msgs = basicSetAddress(newAddress, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuildingPackage.BUILDING__ADDRESS, newAddress, newAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAlternateName() {
		return alternateName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAlternateName(String newAlternateName) {
		String oldAlternateName = alternateName;
		alternateName = newAlternateName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuildingPackage.BUILDING__ALTERNATE_NAME, oldAlternateName, alternateName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAreaServed() {
		return areaServed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAreaServed(String newAreaServed) {
		String oldAreaServed = areaServed;
		areaServed = newAreaServed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuildingPackage.BUILDING__AREA_SERVED, oldAreaServed, areaServed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<CategoryValue> getCategory() {
		if (category == null) {
			category = new EDataTypeUniqueEList<CategoryValue>(CategoryValue.class, this, BuildingPackage.BUILDING__CATEGORY);
		}
		return category;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Double getCollapseRisk() {
		return collapseRisk;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCollapseRisk(Double newCollapseRisk) {
		Double oldCollapseRisk = collapseRisk;
		collapseRisk = newCollapseRisk;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuildingPackage.BUILDING__COLLAPSE_RISK, oldCollapseRisk, collapseRisk));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDataProvider() {
		return dataProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDataProvider(String newDataProvider) {
		String oldDataProvider = dataProvider;
		dataProvider = newDataProvider;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuildingPackage.BUILDING__DATA_PROVIDER, oldDataProvider, dataProvider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDateCreated() {
		return dateCreated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDateCreated(String newDateCreated) {
		String oldDateCreated = dateCreated;
		dateCreated = newDateCreated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuildingPackage.BUILDING__DATE_CREATED, oldDateCreated, dateCreated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDateModified() {
		return dateModified;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDateModified(String newDateModified) {
		String oldDateModified = dateModified;
		dateModified = newDateModified;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuildingPackage.BUILDING__DATE_MODIFIED, oldDateModified, dateModified));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuildingPackage.BUILDING__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Integer getFloorsAboveGround() {
		return floorsAboveGround;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFloorsAboveGround(Integer newFloorsAboveGround) {
		Integer oldFloorsAboveGround = floorsAboveGround;
		floorsAboveGround = newFloorsAboveGround;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuildingPackage.BUILDING__FLOORS_ABOVE_GROUND, oldFloorsAboveGround, floorsAboveGround));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Integer getFloorsBelowGround() {
		return floorsBelowGround;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFloorsBelowGround(Integer newFloorsBelowGround) {
		Integer oldFloorsBelowGround = floorsBelowGround;
		floorsBelowGround = newFloorsBelowGround;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuildingPackage.BUILDING__FLOORS_BELOW_GROUND, oldFloorsBelowGround, floorsBelowGround));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuildingPackage.BUILDING__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuildingPackage.BUILDING__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getOccupier() {
		if (occupier == null) {
			occupier = new EDataTypeUniqueEList<String>(String.class, this, BuildingPackage.BUILDING__OCCUPIER);
		}
		return occupier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getOpeningHours() {
		if (openingHours == null) {
			openingHours = new EDataTypeUniqueEList<String>(String.class, this, BuildingPackage.BUILDING__OPENING_HOURS);
		}
		return openingHours;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getOwner() {
		if (owner == null) {
			owner = new EDataTypeUniqueEList<String>(String.class, this, BuildingPackage.BUILDING__OWNER);
		}
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Double getPeopleCapacity() {
		return peopleCapacity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPeopleCapacity(Double newPeopleCapacity) {
		Double oldPeopleCapacity = peopleCapacity;
		peopleCapacity = newPeopleCapacity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuildingPackage.BUILDING__PEOPLE_CAPACITY, oldPeopleCapacity, peopleCapacity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Double getPeopleOccupancy() {
		return peopleOccupancy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPeopleOccupancy(Double newPeopleOccupancy) {
		Double oldPeopleOccupancy = peopleOccupancy;
		peopleOccupancy = newPeopleOccupancy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuildingPackage.BUILDING__PEOPLE_OCCUPANCY, oldPeopleOccupancy, peopleOccupancy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRefMap() {
		return refMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRefMap(String newRefMap) {
		String oldRefMap = refMap;
		refMap = newRefMap;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuildingPackage.BUILDING__REF_MAP, oldRefMap, refMap));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSource(String newSource) {
		String oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuildingPackage.BUILDING__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypeValue getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(TypeValue newType) {
		TypeValue oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuildingPackage.BUILDING__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BuildingPackage.BUILDING__ADDRESS:
				return basicSetAddress(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BuildingPackage.BUILDING__ADDRESS:
				return getAddress();
			case BuildingPackage.BUILDING__ALTERNATE_NAME:
				return getAlternateName();
			case BuildingPackage.BUILDING__AREA_SERVED:
				return getAreaServed();
			case BuildingPackage.BUILDING__CATEGORY:
				return getCategory();
			case BuildingPackage.BUILDING__COLLAPSE_RISK:
				return getCollapseRisk();
			case BuildingPackage.BUILDING__DATA_PROVIDER:
				return getDataProvider();
			case BuildingPackage.BUILDING__DATE_CREATED:
				return getDateCreated();
			case BuildingPackage.BUILDING__DATE_MODIFIED:
				return getDateModified();
			case BuildingPackage.BUILDING__DESCRIPTION:
				return getDescription();
			case BuildingPackage.BUILDING__FLOORS_ABOVE_GROUND:
				return getFloorsAboveGround();
			case BuildingPackage.BUILDING__FLOORS_BELOW_GROUND:
				return getFloorsBelowGround();
			case BuildingPackage.BUILDING__ID:
				return getId();
			case BuildingPackage.BUILDING__NAME:
				return getName();
			case BuildingPackage.BUILDING__OCCUPIER:
				return getOccupier();
			case BuildingPackage.BUILDING__OPENING_HOURS:
				return getOpeningHours();
			case BuildingPackage.BUILDING__OWNER:
				return getOwner();
			case BuildingPackage.BUILDING__PEOPLE_CAPACITY:
				return getPeopleCapacity();
			case BuildingPackage.BUILDING__PEOPLE_OCCUPANCY:
				return getPeopleOccupancy();
			case BuildingPackage.BUILDING__REF_MAP:
				return getRefMap();
			case BuildingPackage.BUILDING__SOURCE:
				return getSource();
			case BuildingPackage.BUILDING__TYPE:
				return getType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BuildingPackage.BUILDING__ADDRESS:
				setAddress((Address)newValue);
				return;
			case BuildingPackage.BUILDING__ALTERNATE_NAME:
				setAlternateName((String)newValue);
				return;
			case BuildingPackage.BUILDING__AREA_SERVED:
				setAreaServed((String)newValue);
				return;
			case BuildingPackage.BUILDING__CATEGORY:
				getCategory().clear();
				getCategory().addAll((Collection<? extends CategoryValue>)newValue);
				return;
			case BuildingPackage.BUILDING__COLLAPSE_RISK:
				setCollapseRisk((Double)newValue);
				return;
			case BuildingPackage.BUILDING__DATA_PROVIDER:
				setDataProvider((String)newValue);
				return;
			case BuildingPackage.BUILDING__DATE_CREATED:
				setDateCreated((String)newValue);
				return;
			case BuildingPackage.BUILDING__DATE_MODIFIED:
				setDateModified((String)newValue);
				return;
			case BuildingPackage.BUILDING__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case BuildingPackage.BUILDING__FLOORS_ABOVE_GROUND:
				setFloorsAboveGround((Integer)newValue);
				return;
			case BuildingPackage.BUILDING__FLOORS_BELOW_GROUND:
				setFloorsBelowGround((Integer)newValue);
				return;
			case BuildingPackage.BUILDING__ID:
				setId((String)newValue);
				return;
			case BuildingPackage.BUILDING__NAME:
				setName((String)newValue);
				return;
			case BuildingPackage.BUILDING__OCCUPIER:
				getOccupier().clear();
				getOccupier().addAll((Collection<? extends String>)newValue);
				return;
			case BuildingPackage.BUILDING__OPENING_HOURS:
				getOpeningHours().clear();
				getOpeningHours().addAll((Collection<? extends String>)newValue);
				return;
			case BuildingPackage.BUILDING__OWNER:
				getOwner().clear();
				getOwner().addAll((Collection<? extends String>)newValue);
				return;
			case BuildingPackage.BUILDING__PEOPLE_CAPACITY:
				setPeopleCapacity((Double)newValue);
				return;
			case BuildingPackage.BUILDING__PEOPLE_OCCUPANCY:
				setPeopleOccupancy((Double)newValue);
				return;
			case BuildingPackage.BUILDING__REF_MAP:
				setRefMap((String)newValue);
				return;
			case BuildingPackage.BUILDING__SOURCE:
				setSource((String)newValue);
				return;
			case BuildingPackage.BUILDING__TYPE:
				setType((TypeValue)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case BuildingPackage.BUILDING__ADDRESS:
				setAddress((Address)null);
				return;
			case BuildingPackage.BUILDING__ALTERNATE_NAME:
				setAlternateName(ALTERNATE_NAME_EDEFAULT);
				return;
			case BuildingPackage.BUILDING__AREA_SERVED:
				setAreaServed(AREA_SERVED_EDEFAULT);
				return;
			case BuildingPackage.BUILDING__CATEGORY:
				getCategory().clear();
				return;
			case BuildingPackage.BUILDING__COLLAPSE_RISK:
				setCollapseRisk(COLLAPSE_RISK_EDEFAULT);
				return;
			case BuildingPackage.BUILDING__DATA_PROVIDER:
				setDataProvider(DATA_PROVIDER_EDEFAULT);
				return;
			case BuildingPackage.BUILDING__DATE_CREATED:
				setDateCreated(DATE_CREATED_EDEFAULT);
				return;
			case BuildingPackage.BUILDING__DATE_MODIFIED:
				setDateModified(DATE_MODIFIED_EDEFAULT);
				return;
			case BuildingPackage.BUILDING__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case BuildingPackage.BUILDING__FLOORS_ABOVE_GROUND:
				setFloorsAboveGround(FLOORS_ABOVE_GROUND_EDEFAULT);
				return;
			case BuildingPackage.BUILDING__FLOORS_BELOW_GROUND:
				setFloorsBelowGround(FLOORS_BELOW_GROUND_EDEFAULT);
				return;
			case BuildingPackage.BUILDING__ID:
				setId(ID_EDEFAULT);
				return;
			case BuildingPackage.BUILDING__NAME:
				setName(NAME_EDEFAULT);
				return;
			case BuildingPackage.BUILDING__OCCUPIER:
				getOccupier().clear();
				return;
			case BuildingPackage.BUILDING__OPENING_HOURS:
				getOpeningHours().clear();
				return;
			case BuildingPackage.BUILDING__OWNER:
				getOwner().clear();
				return;
			case BuildingPackage.BUILDING__PEOPLE_CAPACITY:
				setPeopleCapacity(PEOPLE_CAPACITY_EDEFAULT);
				return;
			case BuildingPackage.BUILDING__PEOPLE_OCCUPANCY:
				setPeopleOccupancy(PEOPLE_OCCUPANCY_EDEFAULT);
				return;
			case BuildingPackage.BUILDING__REF_MAP:
				setRefMap(REF_MAP_EDEFAULT);
				return;
			case BuildingPackage.BUILDING__SOURCE:
				setSource(SOURCE_EDEFAULT);
				return;
			case BuildingPackage.BUILDING__TYPE:
				setType(TYPE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BuildingPackage.BUILDING__ADDRESS:
				return address != null;
			case BuildingPackage.BUILDING__ALTERNATE_NAME:
				return ALTERNATE_NAME_EDEFAULT == null ? alternateName != null : !ALTERNATE_NAME_EDEFAULT.equals(alternateName);
			case BuildingPackage.BUILDING__AREA_SERVED:
				return AREA_SERVED_EDEFAULT == null ? areaServed != null : !AREA_SERVED_EDEFAULT.equals(areaServed);
			case BuildingPackage.BUILDING__CATEGORY:
				return category != null && !category.isEmpty();
			case BuildingPackage.BUILDING__COLLAPSE_RISK:
				return COLLAPSE_RISK_EDEFAULT == null ? collapseRisk != null : !COLLAPSE_RISK_EDEFAULT.equals(collapseRisk);
			case BuildingPackage.BUILDING__DATA_PROVIDER:
				return DATA_PROVIDER_EDEFAULT == null ? dataProvider != null : !DATA_PROVIDER_EDEFAULT.equals(dataProvider);
			case BuildingPackage.BUILDING__DATE_CREATED:
				return DATE_CREATED_EDEFAULT == null ? dateCreated != null : !DATE_CREATED_EDEFAULT.equals(dateCreated);
			case BuildingPackage.BUILDING__DATE_MODIFIED:
				return DATE_MODIFIED_EDEFAULT == null ? dateModified != null : !DATE_MODIFIED_EDEFAULT.equals(dateModified);
			case BuildingPackage.BUILDING__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case BuildingPackage.BUILDING__FLOORS_ABOVE_GROUND:
				return FLOORS_ABOVE_GROUND_EDEFAULT == null ? floorsAboveGround != null : !FLOORS_ABOVE_GROUND_EDEFAULT.equals(floorsAboveGround);
			case BuildingPackage.BUILDING__FLOORS_BELOW_GROUND:
				return FLOORS_BELOW_GROUND_EDEFAULT == null ? floorsBelowGround != null : !FLOORS_BELOW_GROUND_EDEFAULT.equals(floorsBelowGround);
			case BuildingPackage.BUILDING__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case BuildingPackage.BUILDING__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case BuildingPackage.BUILDING__OCCUPIER:
				return occupier != null && !occupier.isEmpty();
			case BuildingPackage.BUILDING__OPENING_HOURS:
				return openingHours != null && !openingHours.isEmpty();
			case BuildingPackage.BUILDING__OWNER:
				return owner != null && !owner.isEmpty();
			case BuildingPackage.BUILDING__PEOPLE_CAPACITY:
				return PEOPLE_CAPACITY_EDEFAULT == null ? peopleCapacity != null : !PEOPLE_CAPACITY_EDEFAULT.equals(peopleCapacity);
			case BuildingPackage.BUILDING__PEOPLE_OCCUPANCY:
				return PEOPLE_OCCUPANCY_EDEFAULT == null ? peopleOccupancy != null : !PEOPLE_OCCUPANCY_EDEFAULT.equals(peopleOccupancy);
			case BuildingPackage.BUILDING__REF_MAP:
				return REF_MAP_EDEFAULT == null ? refMap != null : !REF_MAP_EDEFAULT.equals(refMap);
			case BuildingPackage.BUILDING__SOURCE:
				return SOURCE_EDEFAULT == null ? source != null : !SOURCE_EDEFAULT.equals(source);
			case BuildingPackage.BUILDING__TYPE:
				return type != TYPE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (alternateName: ");
		result.append(alternateName);
		result.append(", areaServed: ");
		result.append(areaServed);
		result.append(", category: ");
		result.append(category);
		result.append(", collapseRisk: ");
		result.append(collapseRisk);
		result.append(", dataProvider: ");
		result.append(dataProvider);
		result.append(", dateCreated: ");
		result.append(dateCreated);
		result.append(", dateModified: ");
		result.append(dateModified);
		result.append(", description: ");
		result.append(description);
		result.append(", floorsAboveGround: ");
		result.append(floorsAboveGround);
		result.append(", floorsBelowGround: ");
		result.append(floorsBelowGround);
		result.append(", id: ");
		result.append(id);
		result.append(", name: ");
		result.append(name);
		result.append(", occupier: ");
		result.append(occupier);
		result.append(", openingHours: ");
		result.append(openingHours);
		result.append(", owner: ");
		result.append(owner);
		result.append(", peopleCapacity: ");
		result.append(peopleCapacity);
		result.append(", peopleOccupancy: ");
		result.append(peopleOccupancy);
		result.append(", refMap: ");
		result.append(refMap);
		result.append(", source: ");
		result.append(source);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //BuildingImpl
