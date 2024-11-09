package com.example.food.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public record CustomerRequest(
    @NotNull(message = "Customer should be present")
    @NotEmpty(message = "Customer is empty")
    @NotBlank(message = "Customer is blank")
    @JsonProperty("first_name")
    String firstName,

    @JsonProperty("last_name")
    String lastName,

    @NotNull(message = "Customer should be present")
    @Email(message = "Email format is incorrect")
    @NotBlank(message = "Customer is blank")
    @JsonProperty("email")
    String email,

    @NotNull(message = "password should be present")
    @NotEmpty(message = "password is empty")
    @NotBlank(message = "password is blank")
    @Size(min = 6, max = 12)
    @JsonProperty("password")
    String password) {

}
