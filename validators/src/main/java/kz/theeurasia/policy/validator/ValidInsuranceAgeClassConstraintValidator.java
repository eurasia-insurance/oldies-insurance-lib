package kz.theeurasia.policy.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.insurance.elements.InsuredAgeClass;

public class ValidInsuranceAgeClassConstraintValidator
	implements ConstraintValidator<ValidInsuranceAgeClass, InsuredAgeClass> {

    private InsuredAgeClass[] invalidTypes;

    @Override
    public void initialize(ValidInsuranceAgeClass constraintAnnotation) {
	this.invalidTypes = constraintAnnotation.invalidValues();
    }

    @Override
    public boolean isValid(InsuredAgeClass value, ConstraintValidatorContext context) {
	if (value == null)
	    return true;
	for (InsuredAgeClass i : invalidTypes)
	    if (i.equals(value))
		return false;
	return true;
    }

}