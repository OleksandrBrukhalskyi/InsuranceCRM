package com.insurance.crm.security;

import com.insurance.crm.entity.Filiation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpDto {
    private static final String INVALID_PASSWORD = "Invalid password" ;
    private static final String INVALID_EMAIL = "Invalid email";

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

    private Integer age;
    @NotBlank
    private String login;
    @NotBlank
//    @Pattern(
//            regexp = "^(?=.*[a-z]+)(?=.*[A-Z]+)(?=.*\\d+)(?=.*[~`!@#$%^&*()+=_{}|:;”’?/<>,.\\]\\[]+).{8,}$",
//            message = INVALID_PASSWORD
//    )
    private String password;
    private Filiation filiation;
}
