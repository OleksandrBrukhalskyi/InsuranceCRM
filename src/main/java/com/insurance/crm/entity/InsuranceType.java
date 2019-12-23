package com.insurance.crm.entity;

public class InsuranceType {
    private Long id;
    private String name;
    private double sumInsured;
    private String tag;
    private InsurancePolicy insurancePolicy;

    public InsuranceType(Long id, String name, double sumInsured, String tag, InsurancePolicy insurancePolicy) {
        this.id = id;
        this.name = name;
        this.sumInsured = sumInsured;
        this.tag = tag;
        this.insurancePolicy = insurancePolicy;
    }

    public InsuranceType() {
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

    public double getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(double sumInsured) {
        this.sumInsured = sumInsured;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public InsurancePolicy getInsurancePolicy() {
        return insurancePolicy;
    }

    public void setInsurancePolicy(InsurancePolicy insurancePolicy) {
        this.insurancePolicy = insurancePolicy;
    }

    @Override
    public String toString() {
        return "InsuranceType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sumInsured=" + sumInsured +
                ", tag='" + tag + '\'' +
                ", insurancePolicy=" + insurancePolicy +
                '}';
    }
}
