package com.lapsa.insurance.domain;

import java.util.List;

import com.lapsa.image.ImageContent;
import com.lapsa.insurance.validation.NotEmptyString;
import com.lapsa.insurance.validation.NotNullValue;

public class CompanyPointOfSale extends BaseEntity<Integer> {

    @NotNullValue
    @NotEmptyString
    private String name;

    private PostAddress address;

    private GeoPoint geoPoint;

    private boolean available;

    private boolean companyOwnOffice;

    private boolean pickupAvailable;

    private boolean deliveryServicesAvailable;

    private ImageContent photo;

    private List<CompanyContactPhone> phones;

    private List<CompanyContactEmail> emailAddresses;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public PostAddress getAddress() {
	return address;
    }

    public void setAddress(PostAddress address) {
	this.address = address;
    }

    public GeoPoint getGeoPoint() {
	return geoPoint;
    }

    public void setGeoPoint(GeoPoint geoPoint) {
	this.geoPoint = geoPoint;
    }

    public List<CompanyContactEmail> getEmailAddresses() {
	return emailAddresses;
    }

    public void setEmailAddresses(List<CompanyContactEmail> emailAddresses) {
	this.emailAddresses = emailAddresses;
    }

    public boolean isAvailable() {
	return available;
    }

    public void setAvailable(boolean available) {
	this.available = available;
    }

    public List<CompanyContactPhone> getPhones() {
	return phones;
    }

    public void setPhones(List<CompanyContactPhone> phones) {
	this.phones = phones;
    }

    public boolean isCompanyOwnOffice() {
	return companyOwnOffice;
    }

    public void setCompanyOwnOffice(boolean companyOwnOffice) {
	this.companyOwnOffice = companyOwnOffice;
    }

    public boolean isPickupAvailable() {
	return pickupAvailable;
    }

    public void setPickupAvailable(boolean pickupAvailable) {
	this.pickupAvailable = pickupAvailable;
    }

    public boolean isDeliveryServicesAvailable() {
	return deliveryServicesAvailable;
    }

    public void setDeliveryServicesAvailable(boolean deliveryServicesAvailable) {
	this.deliveryServicesAvailable = deliveryServicesAvailable;
    }

    public ImageContent getPhoto() {
	return photo;
    }

    public void setPhoto(ImageContent photo) {
	this.photo = photo;
    }
}
