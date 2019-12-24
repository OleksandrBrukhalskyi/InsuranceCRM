package com.insurance.crm.entity;

import com.insurance.crm.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.lang.annotation.DeclareAnnotation;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "agents")
public class Agent extends User {
    @ManyToOne
    private Filiation filiation;
    @OneToMany(mappedBy = "agent")
    private InsurancePolicy insurancePolicy;


}
