package com.insurance.crm.security;

import javax.validation.constraints.Email;

public class SignUpRequest {
    private String surname;
    private String firstname;
    private String patronymic;
    @Email
    private String email;
    private String username;
    private String password;
    private Long filiation;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getFiliation() {
        return filiation;
    }

    public void setFiliation(Long filiation) {
        this.filiation = filiation;
    }
}
