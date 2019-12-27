package com.insurance.crm.dto.agent;

import com.insurance.crm.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoleDto {
    private Role[] roles;
}
