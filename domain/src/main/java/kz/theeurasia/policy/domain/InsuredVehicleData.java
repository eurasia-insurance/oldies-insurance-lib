package kz.theeurasia.policy.domain;

import java.util.UUID;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleAgeClassDict;
import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleClassDict;
import kz.theeurasia.policy.validator.NotNullValue;
import kz.theeurasia.policy.validator.ValidVehicleAgeClass;
import kz.theeurasia.policy.validator.ValidVehicleClass;

public class InsuredVehicleData {
    private final UUID id = UUID.randomUUID();

    private VehicleData vehicleData = new VehicleData();

    @NotNullValue
    @ValidVehicleClass
    private VehicleClassDict vehicleClass;

    @NotNullValue
    @ValidVehicleAgeClass
    private VehicleAgeClassDict vehicleAgeClass;

    private VehicleCertificateData vehicleCertificateData = new VehicleCertificateData();

    private boolean forcedMajorCity;

    private boolean fetched = false;

    @Override
    public int hashCode() {
	return this.getClass().hashCode() * id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
	return obj != null && this.getClass().isInstance(obj) && getId().equals((this.getClass().cast(obj)).getId());
    }

    public String getDisplayName() {
	return vehicleData.getDisplayName();
    }

    public String getSafeId() {
	return id.toString().replaceAll("-", "_");
    }

    @Override
    public String toString() {
	return vehicleData.getDisplayName();
    }

    // GENERATED

    public UUID getId() {
	return id;
    }

    public VehicleClassDict getVehicleClass() {
	return vehicleClass;
    }

    public void setVehicleClass(VehicleClassDict vehicleClass) {
	this.vehicleClass = vehicleClass;
    }

    public VehicleAgeClassDict getVehicleAgeClass() {
	return vehicleAgeClass;
    }

    public void setVehicleAgeClass(VehicleAgeClassDict vehicleAgeClass) {
	this.vehicleAgeClass = vehicleAgeClass;
    }

    public VehicleCertificateData getVehicleCertificateData() {
	return vehicleCertificateData;
    }

    public void setVehicleCertificateData(VehicleCertificateData vehicleCertificateData) {
	this.vehicleCertificateData = vehicleCertificateData;
    }

    public boolean isForcedMajorCity() {
	return forcedMajorCity;
    }

    public void setForcedMajorCity(boolean forcedMajorCity) {
	this.forcedMajorCity = forcedMajorCity;
    }

    public VehicleData getVehicleData() {
	return vehicleData;
    }

    public void setVehicleData(VehicleData vehicleData) {
	this.vehicleData = vehicleData;
    }

    public boolean isFetched() {
	return fetched;
    }

    public void setFetched(boolean fetched) {
	this.fetched = fetched;
    }
}