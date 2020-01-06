package com.insurance.crm.dto.agent;

import com.insurance.crm.entity.enums.AgentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgentStatusDto {

    private Long id;

    @NotNull
    private AgentStatus agentStatus;
}
