package com.insurance.crm.dto.agent;

import com.insurance.crm.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgentRoleDto {

    private Long id;

    @NotNull
    private Role role;
}
