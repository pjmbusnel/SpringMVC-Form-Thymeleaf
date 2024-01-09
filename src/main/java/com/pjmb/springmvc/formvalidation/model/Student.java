package com.pjmb.springmvc.formvalidation.model;

import com.pjmb.springmvc.formvalidation.validation.RegistrationCode;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Student {

    @NotNull(message="is required")
    @Size(min=2, message="minimum 2 characters")
    private String firstName;

    @NotNull(message="is required")
    @Size(min=2, message="minimum 2 characters")
    private String lastName = "";

    @NotNull(message="is required")
    private String gender = "PreferNotToSay";

    @Min(value=18, message="must be greater than or equal to 18")
    @Max(value=110, message="must be less than or equal to 110")
    private Integer age;

    @Pattern(regexp = "^[a-zA-Z0-9]{5,6}", message = "only 5 or 6 characters or digits")
    private String postalCode;

    @RegistrationCode(value="IFT-", message="must start with IFT-")
    private String registrationCode;
}
