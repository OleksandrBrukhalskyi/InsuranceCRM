package com.insurance.crm.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpDto {
    private static final String INVALID_PASSWORD = "Invalid password" ;
    private static final String INVALID_EMAIL = "Invalid email";
    @NotBlank
    @Length(max = 40)
    private String surname;
    @NotBlank
    @Length(max = 40)
    private String firstname;
    @NotBlank
    @Length(max = 40)
    private String patronymic;
    @Email(message = INVALID_EMAIL)
    private String email;
    @NotBlank
    private Integer age;
    @NotBlank
    private String login;
    @NotBlank
    @Pattern(
            regexp = "^(?=.*[a-z]+)(?=.*[A-Z]+)(?=.*\\d+)(?=.*[~`!@#$%^&*()+=_{}|:;”’?/<>,.\\]\\[]+).{8,}$",
            message = INVALID_PASSWORD
    )
    private String password;
}
