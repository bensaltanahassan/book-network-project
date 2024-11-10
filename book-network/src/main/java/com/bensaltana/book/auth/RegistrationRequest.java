package com.bensaltana.book.auth;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class RegistrationRequest {
    @NotEmpty(message = "firstName cannot be empty")
    @NotBlank(message = "firstName cannot be blank")
    private String firstName;

    @NotEmpty(message = "lastName cannot be empty")
    @NotBlank(message = "lastName cannot be blank")
    private String lastName;

    @Email(message = "email must be valid")
    @NotEmpty(message = "email cannot be empty")
    @NotBlank(message = "email cannot be blank")
    private String email;

    @Size(min = 8, max = 100, message = "password must be between 8 and 100 characters long")
    @NotEmpty(message = "password cannot be empty")
    @NotBlank(message = "password cannot be blank")
    private String password;
}
