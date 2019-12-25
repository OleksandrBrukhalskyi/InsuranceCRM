package com.insurance.crm.entity;

import com.insurance.crm.entity.enums.Role;
import lombok.*;
import org.aspectj.lang.annotation.DeclareAnnotation;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Table(name = "agents")
public class Agent extends User {
    @ManyToOne(fetch = FetchType.LAZY)
    private Filiation filiation;
    @OneToMany(mappedBy = "agent",cascade = CascadeType.ALL)
    private List<InsurancePolicy> insurancePolicies;


}
