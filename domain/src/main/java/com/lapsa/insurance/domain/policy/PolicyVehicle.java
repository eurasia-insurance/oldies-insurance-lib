package com.lapsa.insurance.domain.policy;

import static com.lapsa.insurance.domain.DisplayNameElements.*;

import java.util.Locale;
import java.util.StringJoiner;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.lapsa.insurance.domain.Vehicle;
import com.lapsa.insurance.domain.VehicleCertificateData;
import com.lapsa.insurance.elements.VehicleAgeClass;
import com.lapsa.insurance.elements.VehicleClass;
import com.lapsa.insurance.validation.ValidPolicyVehicleAgeClass;
import com.lapsa.insurance.validation.ValidPolicyVehicleClass;

import tech.lapsa.java.commons.function.MyOptionals;
import tech.lapsa.java.commons.localization.Localized;
import tech.lapsa.javax.validation.NotNullValue;
import tech.lapsa.kz.vehicle.VehicleRegNumber;
import tech.lapsa.patterns.domain.HashCodePrime;

@Entity
@Table(name = "POLICY_VEHICLE")
@HashCodePrime(53)
public class PolicyVehicle extends Vehicle {

    private static final long serialVersionUID = 1L;

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "VEHICLE_CLASS")
    @NotNullValue
    @ValidPolicyVehicleClass
    private VehicleClass vehicleClass;

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "VEHICLE_AGE_CLASS")
    @NotNullValue
    @ValidPolicyVehicleAgeClass
    private VehicleAgeClass vehicleAgeClass;

    @Basic
    @Column(name = "TEMPORARYENTRY")
    private boolean temporaryEntry = false;

    @Basic
    @Column(name = "FORCED_MAJOR_CITY")
    private boolean forcedMajorCity;

    @Transient
    private boolean fetched = false;

    @Override
    public String localized(LocalizationVariant variant, Locale locale) {
	StringBuilder sb = new StringBuilder();

	sb.append(MyOptionals.of(getFullName()) //
		.orElseGet(() -> POLICY_VEHICLE.localized(variant, locale)));

	StringJoiner sj = new StringJoiner(", ", " ", "");
	sj.setEmptyValue("");

	MyOptionals.of(vehicleClass) //
		.map(Localized.toLocalizedMapper(variant, locale))
		.map(POLICY_VEHICLE_CLASS.fieldAsCaptionMapper(variant, locale))
		.ifPresent(sj::add);

	MyOptionals.of(certificateData) //
		.map(VehicleCertificateData::getRegistrationNumber) //
		.map(VehicleRegNumber::getNumber) //
		.map(POLICY_VEHICLE_REG_NUMBER.fieldAsCaptionMapper(variant, locale)) //
		.ifPresent(sj::add);

	MyOptionals.of(vehicleAgeClass) //
		.map(Localized.toLocalizedMapper(variant, locale)) //
		.map(POLICY_VEHICLE_AGE_CLASS.fieldAsCaptionMapper(variant, locale))
		.ifPresent(sj::add);

	return sb.append(sj.toString()) //
		.append(appendEntityId()) //
		.toString();
    }

    // GENERATED

    public VehicleClass getVehicleClass() {
	return vehicleClass;
    }

    public void setVehicleClass(VehicleClass vehicleClass) {
	this.vehicleClass = vehicleClass;
    }

    public VehicleAgeClass getVehicleAgeClass() {
	return vehicleAgeClass;
    }

    public void setVehicleAgeClass(VehicleAgeClass vehicleAgeClass) {
	this.vehicleAgeClass = vehicleAgeClass;
    }

    public boolean isTemporaryEntry() {
	return temporaryEntry;
    }

    public void setTemporaryEntry(boolean temporaryEntry) {
	this.temporaryEntry = temporaryEntry;
    }

    public boolean isForcedMajorCity() {
	return forcedMajorCity;
    }

    public void setForcedMajorCity(boolean forcedMajorCity) {
	this.forcedMajorCity = forcedMajorCity;
    }

    public boolean isFetched() {
	return fetched;
    }

    public void setFetched(boolean fetched) {
	this.fetched = fetched;
    }
}
