package com.insurance.crm.entity;

public class InsurancePolicy {
    private Long id;
    private String signDate;
    private String expiryDate;
    private Filiation filiation;
    private InsuranceType insuranceType;
    private Agent agent;
    private Customer customer;

    public InsurancePolicy(Long id, String signDate, String expiryDate, Filiation filiation, InsuranceType insuranceType, Agent agent, Customer customer) {
        this.id = id;
        this.signDate = signDate;
        this.expiryDate = expiryDate;
        this.filiation = filiation;
        this.insuranceType = insuranceType;
        this.agent = agent;
        this.customer = customer;
    }

    public InsurancePolicy() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Filiation getFiliation() {
        return filiation;
    }

    public void setFiliation(Filiation filiation) {
        this.filiation = filiation;
    }

    public InsuranceType getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(InsuranceType insuranceType) {
        this.insuranceType = insuranceType;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "InsurancePolicy{" +
                "id=" + id +
                ", signDate='" + signDate + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", filiation=" + filiation +
                ", insuranceType=" + insuranceType +
                ", agent=" + agent +
                ", customer=" + customer +
                '}';
    }
}
