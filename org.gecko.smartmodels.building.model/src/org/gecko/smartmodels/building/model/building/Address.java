/**
 */
package org.gecko.smartmodels.building.model.building;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Address</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The mailing address
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.smartmodels.building.model.building.Address#getAddressCountry <em>Address Country</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.Address#getAddressLocality <em>Address Locality</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.Address#getAddressRegion <em>Address Region</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.Address#getPostOfficeBoxNumber <em>Post Office Box Number</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.Address#getPostalCode <em>Postal Code</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.Address#getStreetAddress <em>Street Address</em>}</li>
 * </ul>
 *
 * @see org.gecko.smartmodels.building.model.building.BuildingPackage#getAddress()
 * @model
 * @generated
 */
public interface Address extends EObject {
	/**
	 * Returns the value of the '<em><b>Address Country</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Property. The country. For example, Spain. Model:'https://schema.org/addressCountry'
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Address Country</em>' attribute.
	 * @see #setAddressCountry(String)
	 * @see org.gecko.smartmodels.building.model.building.BuildingPackage#getAddress_AddressCountry()
	 * @model
	 * @generated
	 */
	String getAddressCountry();

	/**
	 * Sets the value of the '{@link org.gecko.smartmodels.building.model.building.Address#getAddressCountry <em>Address Country</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Address Country</em>' attribute.
	 * @see #getAddressCountry()
	 * @generated
	 */
	void setAddressCountry(String value);

	/**
	 * Returns the value of the '<em><b>Address Locality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Property. The locality in which the street address is, and which is in the region. Model:'https://schema.org/addressLocality'
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Address Locality</em>' attribute.
	 * @see #setAddressLocality(String)
	 * @see org.gecko.smartmodels.building.model.building.BuildingPackage#getAddress_AddressLocality()
	 * @model
	 * @generated
	 */
	String getAddressLocality();

	/**
	 * Sets the value of the '{@link org.gecko.smartmodels.building.model.building.Address#getAddressLocality <em>Address Locality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Address Locality</em>' attribute.
	 * @see #getAddressLocality()
	 * @generated
	 */
	void setAddressLocality(String value);

	/**
	 * Returns the value of the '<em><b>Address Region</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Property. The region in which the locality is, and which is in the country. Model:'https://schema.org/addressRegion'
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Address Region</em>' attribute.
	 * @see #setAddressRegion(String)
	 * @see org.gecko.smartmodels.building.model.building.BuildingPackage#getAddress_AddressRegion()
	 * @model
	 * @generated
	 */
	String getAddressRegion();

	/**
	 * Sets the value of the '{@link org.gecko.smartmodels.building.model.building.Address#getAddressRegion <em>Address Region</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Address Region</em>' attribute.
	 * @see #getAddressRegion()
	 * @generated
	 */
	void setAddressRegion(String value);

	/**
	 * Returns the value of the '<em><b>Post Office Box Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Property. The post office box number for PO box addresses. For example, 03578. Model:'https://schema.org/postOfficeBoxNumber'
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Post Office Box Number</em>' attribute.
	 * @see #setPostOfficeBoxNumber(String)
	 * @see org.gecko.smartmodels.building.model.building.BuildingPackage#getAddress_PostOfficeBoxNumber()
	 * @model
	 * @generated
	 */
	String getPostOfficeBoxNumber();

	/**
	 * Sets the value of the '{@link org.gecko.smartmodels.building.model.building.Address#getPostOfficeBoxNumber <em>Post Office Box Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Post Office Box Number</em>' attribute.
	 * @see #getPostOfficeBoxNumber()
	 * @generated
	 */
	void setPostOfficeBoxNumber(String value);

	/**
	 * Returns the value of the '<em><b>Postal Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Property. The postal code. For example, 24004. Model:'https://schema.org/https://schema.org/postalCode'
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Postal Code</em>' attribute.
	 * @see #setPostalCode(String)
	 * @see org.gecko.smartmodels.building.model.building.BuildingPackage#getAddress_PostalCode()
	 * @model
	 * @generated
	 */
	String getPostalCode();

	/**
	 * Sets the value of the '{@link org.gecko.smartmodels.building.model.building.Address#getPostalCode <em>Postal Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Postal Code</em>' attribute.
	 * @see #getPostalCode()
	 * @generated
	 */
	void setPostalCode(String value);

	/**
	 * Returns the value of the '<em><b>Street Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Property. The street address. Model:'https://schema.org/streetAddress'
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Street Address</em>' attribute.
	 * @see #setStreetAddress(String)
	 * @see org.gecko.smartmodels.building.model.building.BuildingPackage#getAddress_StreetAddress()
	 * @model
	 * @generated
	 */
	String getStreetAddress();

	/**
	 * Sets the value of the '{@link org.gecko.smartmodels.building.model.building.Address#getStreetAddress <em>Street Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Street Address</em>' attribute.
	 * @see #getStreetAddress()
	 * @generated
	 */
	void setStreetAddress(String value);

} // Address
