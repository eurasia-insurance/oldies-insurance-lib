package com.lapsa.insurance.validation.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.insurance.elements.VehicleAgeClass;
import com.lapsa.insurance.validation.ValidVehicleAgeClass;

public class ValidVehicleAgeClassConstraintValidator
	implements ConstraintValidator<ValidVehicleAgeClass, VehicleAgeClass> {

    private VehicleAgeClass[] invalidTypes;

    @Override
    public void initialize(ValidVehicleAgeClass constraintAnnotation) {
	this.invalidTypes = constraintAnnotation.invalidValues();
    }

    @Override
    public boolean isValid(VehicleAgeClass value, ConstraintValidatorContext context) {
	if (value == null)
	    return true;
	for (VehicleAgeClass i : invalidTypes)
	    if (i.equals(value))
		return false;
	return true;
    }

}