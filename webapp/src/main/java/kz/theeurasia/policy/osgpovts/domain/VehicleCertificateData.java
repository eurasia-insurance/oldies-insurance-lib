package kz.theeurasia.policy.osgpovts.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.primefaces.model.UploadedFile;

import kz.theeurasia.esbdproxy.domain.dict.general.CountryRegionDict;

public class VehicleCertificateData {

    private String vehicleRegisterNumber;
    private String number;
    private Calendar dateOfIssue;
    private CountryRegionDict region = CountryRegionDict.UNSPECIFIED;
    private boolean majorCity;
    private List<UploadedFile> scanFiles = new ArrayList<>();

    // GENERATED

    public String getVehicleRegisterNumber() {
	return vehicleRegisterNumber;
    }

    public void setVehicleRegisterNumber(String vehicleRegisterNumber) {
	this.vehicleRegisterNumber = vehicleRegisterNumber;
    }

    public String getNumber() {
	return number;
    }

    public void setNumber(String number) {
	this.number = number;
    }

    public Calendar getDateOfIssue() {
	return dateOfIssue;
    }

    public void setDateOfIssue(Calendar dateOfIssue) {
	this.dateOfIssue = dateOfIssue;
    }

    public CountryRegionDict getRegion() {
	return region;
    }

    public void setRegion(CountryRegionDict region) {
	this.region = region;
    }

    public boolean isMajorCity() {
	return majorCity;
    }

    public void setMajorCity(boolean majorCity) {
	this.majorCity = majorCity;
    }

    public List<UploadedFile> getScanFiles() {
	return scanFiles;
    }

    public void setScanFiles(List<UploadedFile> scanFiles) {
	this.scanFiles = scanFiles;
    }
}
