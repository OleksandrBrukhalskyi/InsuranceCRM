package com.insurance.crm.entity;

import com.insurance.crm.entity.enums.Role;

import java.util.Set;

public class Agent extends User {
    private Filiation filiation;
    private InsurancePolicy insurancePolicy;

    public Agent(Long id, String surname, String firstname, String patronymic, String login, String password, Integer age, boolean active, Set<Role> roles, Filiation filiation, InsurancePolicy insurancePolicy) {
        super(id, surname, firstname, patronymic, login, password, age, active, roles);
        this.filiation = filiation;
        this.insurancePolicy = insurancePolicy;
    }

    public Filiation getFiliation() {
        return filiation;
    }

    public void setFiliation(Filiation filiation) {
        this.filiation = filiation;
    }

    public InsurancePolicy getInsurancePolicy() {
        return insurancePolicy;
    }

    public void setInsurancePolicy(InsurancePolicy insurancePolicy) {
        this.insurancePolicy = insurancePolicy;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "filiation=" + filiation +
                ", insurancePolicy=" + insurancePolicy +
                '}';
    }
}
