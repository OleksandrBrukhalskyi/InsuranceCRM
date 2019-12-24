package com.insurance.crm.entity;

import com.insurance.crm.entity.enums.Role;
import lombok.*;
import org.aspectj.lang.annotation.DeclareAnnotation;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "agents")
public class Agent extends User {
    @ManyToOne
    private Filiation filiation;
    @OneToMany(mappedBy = "agent")
    private List<InsurancePolicy> insurancePolicies;


}
