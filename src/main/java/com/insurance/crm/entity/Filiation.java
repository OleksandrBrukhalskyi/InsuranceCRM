package com.insurance.crm.entity;

public class Filiation {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private Agent agent;
    private InsurancePolicy insurancePolicy;

    public Filiation(Long id, String name, String address, String phone, Agent agent, InsurancePolicy insurancePolicy) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.agent = agent;
        this.insurancePolicy = insurancePolicy;
    }

    public Filiation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public InsurancePolicy getInsurancePolicy() {
        return insurancePolicy;
    }

    public void setInsurancePolicy(InsurancePolicy insurancePolicy) {
        this.insurancePolicy = insurancePolicy;
    }
}
