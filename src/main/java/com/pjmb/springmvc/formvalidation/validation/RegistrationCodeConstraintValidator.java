package com.pjmb.springmvc.formvalidation.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RegistrationCodeConstraintValidator implements ConstraintValidator<RegistrationCode, String> {

    private String registrationPrefix;

    @Override
    public void initialize(RegistrationCode registrationCode) {
        registrationPrefix = registrationCode.value().toLowerCase();
    }

    @Override
    public boolean isValid(String registrationCode, ConstraintValidatorContext constraintValidatorContext) {
        return (registrationCode!=null && registrationCode.toLowerCase().startsWith(registrationPrefix));
    }
}






