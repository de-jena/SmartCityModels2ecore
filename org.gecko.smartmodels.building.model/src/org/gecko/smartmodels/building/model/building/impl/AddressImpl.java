/*
 */
package org.gecko.smartmodels.building.model.building.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.gecko.smartmodels.building.model.building.Address;
import org.gecko.smartmodels.building.model.building.BuildingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Address</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gecko.smartmodels.building.model.building.impl.AddressImpl#getAddressCountry <em>Address Country</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.impl.AddressImpl#getAddressLocality <em>Address Locality</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.impl.AddressImpl#getAddressRegion <em>Address Region</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.impl.AddressImpl#getPostOfficeBoxNumber <em>Post Office Box Number</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.impl.AddressImpl#getPostalCode <em>Postal Code</em>}</li>
 *   <li>{@link org.gecko.smartmodels.building.model.building.impl.AddressImpl#getStreetAddress <em>Street Address</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AddressImpl extends MinimalEObjectImpl.Container implements Address {
	/**
	 * The default value of the '{@link #getAddressCountry() <em>Address Country</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddressCountry()
	 * @generated
	 * @ordered
	 */
	protected static final String ADDRESS_COUNTRY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAddressCountry() <em>Address Country</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddressCountry()
	 * @generated
	 * @ordered
	 */
	protected String addressCountry = ADDRESS_COUNTRY_EDEFAULT;

	/**
	 * The default value of the '{@link #getAddressLocality() <em>Address Locality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddressLocality()
	 * @generated
	 * @ordered
	 */
	protected static final String ADDRESS_LOCALITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAddressLocality() <em>Address Locality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddressLocality()
	 * @generated
	 * @ordered
	 */
	protected String addressLocality = ADDRESS_LOCALITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getAddressRegion() <em>Address Region</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddressRegion()
	 * @generated
	 * @ordered
	 */
	protected static final String ADDRESS_REGION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAddressRegion() <em>Address Region</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddressRegion()
	 * @generated
	 * @ordered
	 */
	protected String addressRegion = ADDRESS_REGION_EDEFAULT;

	/**
	 * The default value of the '{@link #getPostOfficeBoxNumber() <em>Post Office Box Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostOfficeBoxNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String POST_OFFICE_BOX_NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPostOfficeBoxNumber() <em>Post Office Box Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostOfficeBoxNumber()
	 * @generated
	 * @ordered
	 */
	protected String postOfficeBoxNumber = POST_OFFICE_BOX_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getPostalCode() <em>Postal Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostalCode()
	 * @generated
	 * @ordered
	 */
	protected static final String POSTAL_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPostalCode() <em>Postal Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostalCode()
	 * @generated
	 * @ordered
	 */
	protected String postalCode = POSTAL_CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStreetAddress() <em>Street Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStreetAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String STREET_ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStreetAddress() <em>Street Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStreetAddress()
	 * @generated
	 * @ordered
	 */
	protected String streetAddress = STREET_ADDRESS_EDEFAULT;


	private final BuildingPackage ePackage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddressImpl(EClass instanceEClass) {
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
		return ePackage.getAddress();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAddressCountry() {
		return addressCountry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAddressCountry(String newAddressCountry) {
		String oldAddressCountry = addressCountry;
		addressCountry = newAddressCountry;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuildingPackage.ADDRESS__ADDRESS_COUNTRY, oldAddressCountry, addressCountry));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAddressLocality() {
		return addressLocality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAddressLocality(String newAddressLocality) {
		String oldAddressLocality = addressLocality;
		addressLocality = newAddressLocality;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuildingPackage.ADDRESS__ADDRESS_LOCALITY, oldAddressLocality, addressLocality));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAddressRegion() {
		return addressRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAddressRegion(String newAddressRegion) {
		String oldAddressRegion = addressRegion;
		addressRegion = newAddressRegion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuildingPackage.ADDRESS__ADDRESS_REGION, oldAddressRegion, addressRegion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPostOfficeBoxNumber() {
		return postOfficeBoxNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPostOfficeBoxNumber(String newPostOfficeBoxNumber) {
		String oldPostOfficeBoxNumber = postOfficeBoxNumber;
		postOfficeBoxNumber = newPostOfficeBoxNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuildingPackage.ADDRESS__POST_OFFICE_BOX_NUMBER, oldPostOfficeBoxNumber, postOfficeBoxNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPostalCode(String newPostalCode) {
		String oldPostalCode = postalCode;
		postalCode = newPostalCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuildingPackage.ADDRESS__POSTAL_CODE, oldPostalCode, postalCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getStreetAddress() {
		return streetAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStreetAddress(String newStreetAddress) {
		String oldStreetAddress = streetAddress;
		streetAddress = newStreetAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BuildingPackage.ADDRESS__STREET_ADDRESS, oldStreetAddress, streetAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BuildingPackage.ADDRESS__ADDRESS_COUNTRY:
				return getAddressCountry();
			case BuildingPackage.ADDRESS__ADDRESS_LOCALITY:
				return getAddressLocality();
			case BuildingPackage.ADDRESS__ADDRESS_REGION:
				return getAddressRegion();
			case BuildingPackage.ADDRESS__POST_OFFICE_BOX_NUMBER:
				return getPostOfficeBoxNumber();
			case BuildingPackage.ADDRESS__POSTAL_CODE:
				return getPostalCode();
			case BuildingPackage.ADDRESS__STREET_ADDRESS:
				return getStreetAddress();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BuildingPackage.ADDRESS__ADDRESS_COUNTRY:
				setAddressCountry((String)newValue);
				return;
			case BuildingPackage.ADDRESS__ADDRESS_LOCALITY:
				setAddressLocality((String)newValue);
				return;
			case BuildingPackage.ADDRESS__ADDRESS_REGION:
				setAddressRegion((String)newValue);
				return;
			case BuildingPackage.ADDRESS__POST_OFFICE_BOX_NUMBER:
				setPostOfficeBoxNumber((String)newValue);
				return;
			case BuildingPackage.ADDRESS__POSTAL_CODE:
				setPostalCode((String)newValue);
				return;
			case BuildingPackage.ADDRESS__STREET_ADDRESS:
				setStreetAddress((String)newValue);
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
			case BuildingPackage.ADDRESS__ADDRESS_COUNTRY:
				setAddressCountry(ADDRESS_COUNTRY_EDEFAULT);
				return;
			case BuildingPackage.ADDRESS__ADDRESS_LOCALITY:
				setAddressLocality(ADDRESS_LOCALITY_EDEFAULT);
				return;
			case BuildingPackage.ADDRESS__ADDRESS_REGION:
				setAddressRegion(ADDRESS_REGION_EDEFAULT);
				return;
			case BuildingPackage.ADDRESS__POST_OFFICE_BOX_NUMBER:
				setPostOfficeBoxNumber(POST_OFFICE_BOX_NUMBER_EDEFAULT);
				return;
			case BuildingPackage.ADDRESS__POSTAL_CODE:
				setPostalCode(POSTAL_CODE_EDEFAULT);
				return;
			case BuildingPackage.ADDRESS__STREET_ADDRESS:
				setStreetAddress(STREET_ADDRESS_EDEFAULT);
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
			case BuildingPackage.ADDRESS__ADDRESS_COUNTRY:
				return ADDRESS_COUNTRY_EDEFAULT == null ? addressCountry != null : !ADDRESS_COUNTRY_EDEFAULT.equals(addressCountry);
			case BuildingPackage.ADDRESS__ADDRESS_LOCALITY:
				return ADDRESS_LOCALITY_EDEFAULT == null ? addressLocality != null : !ADDRESS_LOCALITY_EDEFAULT.equals(addressLocality);
			case BuildingPackage.ADDRESS__ADDRESS_REGION:
				return ADDRESS_REGION_EDEFAULT == null ? addressRegion != null : !ADDRESS_REGION_EDEFAULT.equals(addressRegion);
			case BuildingPackage.ADDRESS__POST_OFFICE_BOX_NUMBER:
				return POST_OFFICE_BOX_NUMBER_EDEFAULT == null ? postOfficeBoxNumber != null : !POST_OFFICE_BOX_NUMBER_EDEFAULT.equals(postOfficeBoxNumber);
			case BuildingPackage.ADDRESS__POSTAL_CODE:
				return POSTAL_CODE_EDEFAULT == null ? postalCode != null : !POSTAL_CODE_EDEFAULT.equals(postalCode);
			case BuildingPackage.ADDRESS__STREET_ADDRESS:
				return STREET_ADDRESS_EDEFAULT == null ? streetAddress != null : !STREET_ADDRESS_EDEFAULT.equals(streetAddress);
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
		result.append(" (addressCountry: ");
		result.append(addressCountry);
		result.append(", addressLocality: ");
		result.append(addressLocality);
		result.append(", addressRegion: ");
		result.append(addressRegion);
		result.append(", postOfficeBoxNumber: ");
		result.append(postOfficeBoxNumber);
		result.append(", postalCode: ");
		result.append(postalCode);
		result.append(", streetAddress: ");
		result.append(streetAddress);
		result.append(')');
		return result.toString();
	}

} //AddressImpl
