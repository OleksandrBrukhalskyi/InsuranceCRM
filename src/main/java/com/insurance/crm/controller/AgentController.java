package com.insurance.crm.controller;

import com.insurance.crm.constant.HttpStatuses;
import com.insurance.crm.dto.agent.AgentStatusDto;
import com.insurance.crm.entity.enums.AgentStatus;
import com.insurance.crm.service.impl.AgentServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/agent")
@AllArgsConstructor
public class AgentController {
    private AgentServiceImpl agentService;

    @ApiOperation(value = "Update status of agent")
    @ApiResponses(value = {
            @ApiResponse(code=200, message = HttpStatuses.OK,response = AgentStatus.class),
            @ApiResponse(code=303, message = HttpStatuses.SEE_OTHER),
            @ApiResponse(code =400,message = HttpStatuses.BAD_REQUEST),
            @ApiResponse(code=403,message = HttpStatuses.FORBIDDEN)
    })
    @PatchMapping("status")
    public ResponseEntity<AgentStatusDto> updateStatus(
            @Valid @RequestBody AgentStatusDto agentStatusDto, @ApiIgnore Principal principal){
        return ResponseEntity.status(HttpStatus.OK)
                .body(agentService.updateStatus(
                        agentStatusDto.getId(),agentStatusDto.getAgentStatus()));

    }
}
