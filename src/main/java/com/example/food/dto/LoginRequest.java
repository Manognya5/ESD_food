package com.example.food.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Data;


public record LoginRequest(
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
        String password)
{

}
