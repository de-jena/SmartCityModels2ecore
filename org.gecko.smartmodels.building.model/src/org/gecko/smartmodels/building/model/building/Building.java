/**
 */
package org.gecko.smartmodels.building.model.building;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Building</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Information on a given Building
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.smartmodels.building.model.building.Building#getAddress <em>Address</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.Building#getAlternateName <em>Alternate Name</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.Building#getAreaServed <em>Area Served</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.Building#getCategory <em>Category</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.Building#getCollapseRisk <em>Collapse Risk</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.Building#getDataProvider <em>Data Provider</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.Building#getDateCreated <em>Date Created</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.Building#getDateModified <em>Date Modified</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.Building#getDescription <em>Description</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.Building#getFloorsAboveGround <em>Floors Above Ground</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.Building#getFloorsBelowGround <em>Floors Below Ground</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.Building#getId <em>Id</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.Building#getName <em>Name</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.Building#getOccupier <em>Occupier</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.Building#getOpeningHours <em>Opening Hours</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.Building#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.Building#getPeopleCapacity <em>People Capacity</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.Building#getPeopleOccupancy <em>People Occupancy</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.Building#getRefMap <em>Ref Map</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.Building#getSource <em>Source</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.Building#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.gecko.smartmodels.building.model.building.BuildingPackage#getBuilding()
 * @model
 * @generated
 */
public interface Building extends EObject {
	/**
	 * Returns the value of the '<em><b>Address</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The mailing address
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Address</em>' containment reference.
	 * @see #setAddress(Address)
	 * @see org.gecko.smartmodels.building.model.building.BuildingPackage#getBuilding_Address()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Address getAddress();

	/**
	 * Sets the value of the '{@link org.gecko.smartmodels.building.model.building.Building#getAddress <em>Address</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Address</em>' containment reference.
	 * @see #getAddress()
	 * @generated
	 */
	void setAddress(Address value);

	/**
	 * Returns the value of the '<em><b>Alternate Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An alternative name for this item
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Alternate Name</em>' attribute.
	 * @see #setAlternateName(String)
	 * @see org.gecko.smartmodels.building.model.building.BuildingPackage#getBuilding_AlternateName()
	 * @model
	 * @generated
	 */
	String getAlternateName();

	/**
	 * Sets the value of the '{@link org.gecko.smartmodels.building.model.building.Building#getAlternateName <em>Alternate Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alternate Name</em>' attribute.
	 * @see #getAlternateName()
	 * @generated
	 */
	void setAlternateName(String value);

	/**
	 * Returns the value of the '<em><b>Area Served</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The geographic area where a service or offered item is provided
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Area Served</em>' attribute.
	 * @see #setAreaServed(String)
	 * @see org.gecko.smartmodels.building.model.building.BuildingPackage#getBuilding_AreaServed()
	 * @model
	 * @generated
	 */
	String getAreaServed();

	/**
	 * Sets the value of the '{@link org.gecko.smartmodels.building.model.building.Building#getAreaServed <em>Area Served</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Area Served</em>' attribute.
	 * @see #getAreaServed()
	 * @generated
	 */
	void setAreaServed(String value);

	/**
	 * Returns the value of the '<em><b>Category</b></em>' attribute list.
	 * The list contents are of type {@link org.gecko.smartmodels.building.model.building.CategoryValue}.
	 * The literals are from the enumeration {@link org.gecko.smartmodels.building.model.building.CategoryValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Category</em>' attribute list.
	 * @see org.gecko.smartmodels.building.model.building.CategoryValue
	 * @see org.gecko.smartmodels.building.model.building.BuildingPackage#getBuilding_Category()
	 * @model required="true"
	 * @generated
	 */
	EList<CategoryValue> getCategory();

	/**
	 * Returns the value of the '<em><b>Collapse Risk</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Probability of total collapse of the building.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Collapse Risk</em>' attribute.
	 * @see #setCollapseRisk(Double)
	 * @see org.gecko.smartmodels.building.model.building.BuildingPackage#getBuilding_CollapseRisk()
	 * @model
	 * @generated
	 */
	Double getCollapseRisk();

	/**
	 * Sets the value of the '{@link org.gecko.smartmodels.building.model.building.Building#getCollapseRisk <em>Collapse Risk</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Collapse Risk</em>' attribute.
	 * @see #getCollapseRisk()
	 * @generated
	 */
	void setCollapseRisk(Double value);

	/**
	 * Returns the value of the '<em><b>Data Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A sequence of characters identifying the provider of the harmonised data entity.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Data Provider</em>' attribute.
	 * @see #setDataProvider(String)
	 * @see org.gecko.smartmodels.building.model.building.BuildingPackage#getBuilding_DataProvider()
	 * @model
	 * @generated
	 */
	String getDataProvider();

	/**
	 * Sets the value of the '{@link org.gecko.smartmodels.building.model.building.Building#getDataProvider <em>Data Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Provider</em>' attribute.
	 * @see #getDataProvider()
	 * @generated
	 */
	void setDataProvider(String value);

	/**
	 * Returns the value of the '<em><b>Date Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Entity creation timestamp. This will usually be allocated by the storage platform.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Date Created</em>' attribute.
	 * @see #setDateCreated(String)
	 * @see org.gecko.smartmodels.building.model.building.BuildingPackage#getBuilding_DateCreated()
	 * @model
	 * @generated
	 */
	String getDateCreated();

	/**
	 * Sets the value of the '{@link org.gecko.smartmodels.building.model.building.Building#getDateCreated <em>Date Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date Created</em>' attribute.
	 * @see #getDateCreated()
	 * @generated
	 */
	void setDateCreated(String value);

	/**
	 * Returns the value of the '<em><b>Date Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Timestamp of the last modification of the entity. This will usually be allocated by the storage platform.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Date Modified</em>' attribute.
	 * @see #setDateModified(String)
	 * @see org.gecko.smartmodels.building.model.building.BuildingPackage#getBuilding_DateModified()
	 * @model
	 * @generated
	 */
	String getDateModified();

	/**
	 * Sets the value of the '{@link org.gecko.smartmodels.building.model.building.Building#getDateModified <em>Date Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date Modified</em>' attribute.
	 * @see #getDateModified()
	 * @generated
	 */
	void setDateModified(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A description of this item
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.gecko.smartmodels.building.model.building.BuildingPackage#getBuilding_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.gecko.smartmodels.building.model.building.Building#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Floors Above Ground</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Floors above the ground level
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Floors Above Ground</em>' attribute.
	 * @see #setFloorsAboveGround(Integer)
	 * @see org.gecko.smartmodels.building.model.building.BuildingPackage#getBuilding_FloorsAboveGround()
	 * @model
	 * @generated
	 */
	Integer getFloorsAboveGround();

	/**
	 * Sets the value of the '{@link org.gecko.smartmodels.building.model.building.Building#getFloorsAboveGround <em>Floors Above Ground</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Floors Above Ground</em>' attribute.
	 * @see #getFloorsAboveGround()
	 * @generated
	 */
	void setFloorsAboveGround(Integer value);

	/**
	 * Returns the value of the '<em><b>Floors Below Ground</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Floors below the ground level
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Floors Below Ground</em>' attribute.
	 * @see #setFloorsBelowGround(Integer)
	 * @see org.gecko.smartmodels.building.model.building.BuildingPackage#getBuilding_FloorsBelowGround()
	 * @model
	 * @generated
	 */
	Integer getFloorsBelowGround();

	/**
	 * Sets the value of the '{@link org.gecko.smartmodels.building.model.building.Building#getFloorsBelowGround <em>Floors Below Ground</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Floors Below Ground</em>' attribute.
	 * @see #getFloorsBelowGround()
	 * @generated
	 */
	void setFloorsBelowGround(Integer value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Unique identifier of the entity
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.gecko.smartmodels.building.model.building.BuildingPackage#getBuilding_Id()
	 * @model required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.gecko.smartmodels.building.model.building.Building#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of this item.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.gecko.smartmodels.building.model.building.BuildingPackage#getBuilding_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.gecko.smartmodels.building.model.building.Building#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Occupier</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Person or entity using the building
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Occupier</em>' attribute list.
	 * @see org.gecko.smartmodels.building.model.building.BuildingPackage#getBuilding_Occupier()
	 * @model
	 * @generated
	 */
	EList<String> getOccupier();

	/**
	 * Returns the value of the '<em><b>Opening Hours</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opening Hours</em>' attribute list.
	 * @see org.gecko.smartmodels.building.model.building.BuildingPackage#getBuilding_OpeningHours()
	 * @model
	 * @generated
	 */
	EList<String> getOpeningHours();

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A List containing a JSON encoded sequence of characters referencing the unique Ids of the owner(s)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owner</em>' attribute list.
	 * @see org.gecko.smartmodels.building.model.building.BuildingPackage#getBuilding_Owner()
	 * @model
	 * @generated
	 */
	EList<String> getOwner();

	/**
	 * Returns the value of the '<em><b>People Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Allowed people present at the building
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>People Capacity</em>' attribute.
	 * @see #setPeopleCapacity(Double)
	 * @see org.gecko.smartmodels.building.model.building.BuildingPackage#getBuilding_PeopleCapacity()
	 * @model
	 * @generated
	 */
	Double getPeopleCapacity();

	/**
	 * Sets the value of the '{@link org.gecko.smartmodels.building.model.building.Building#getPeopleCapacity <em>People Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>People Capacity</em>' attribute.
	 * @see #getPeopleCapacity()
	 * @generated
	 */
	void setPeopleCapacity(Double value);

	/**
	 * Returns the value of the '<em><b>People Occupancy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * People present at the building
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>People Occupancy</em>' attribute.
	 * @see #setPeopleOccupancy(Double)
	 * @see org.gecko.smartmodels.building.model.building.BuildingPackage#getBuilding_PeopleOccupancy()
	 * @model
	 * @generated
	 */
	Double getPeopleOccupancy();

	/**
	 * Sets the value of the '{@link org.gecko.smartmodels.building.model.building.Building#getPeopleOccupancy <em>People Occupancy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>People Occupancy</em>' attribute.
	 * @see #getPeopleOccupancy()
	 * @generated
	 */
	void setPeopleOccupancy(Double value);

	/**
	 * Returns the value of the '<em><b>Ref Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Reference to the map containing the building
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ref Map</em>' attribute.
	 * @see #setRefMap(String)
	 * @see org.gecko.smartmodels.building.model.building.BuildingPackage#getBuilding_RefMap()
	 * @model
	 * @generated
	 */
	String getRefMap();

	/**
	 * Sets the value of the '{@link org.gecko.smartmodels.building.model.building.Building#getRefMap <em>Ref Map</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref Map</em>' attribute.
	 * @see #getRefMap()
	 * @generated
	 */
	void setRefMap(String value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A sequence of characters giving the original source of the entity data as a URL. Recommended to be the fully qualified domain name of the source provider, or the URL to the source object.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source</em>' attribute.
	 * @see #setSource(String)
	 * @see org.gecko.smartmodels.building.model.building.BuildingPackage#getBuilding_Source()
	 * @model
	 * @generated
	 */
	String getSource();

	/**
	 * Sets the value of the '{@link org.gecko.smartmodels.building.model.building.Building#getSource <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' attribute.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.gecko.smartmodels.building.model.building.TypeValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * NGSI Entity type
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.gecko.smartmodels.building.model.building.TypeValue
	 * @see #setType(TypeValue)
	 * @see org.gecko.smartmodels.building.model.building.BuildingPackage#getBuilding_Type()
	 * @model required="true"
	 * @generated
	 */
	TypeValue getType();

	/**
	 * Sets the value of the '{@link org.gecko.smartmodels.building.model.building.Building#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.gecko.smartmodels.building.model.building.TypeValue
	 * @see #getType()
	 * @generated
	 */
	void setType(TypeValue value);

} // Building
