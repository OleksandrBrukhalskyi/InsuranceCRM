package com.insurance.crm.controller;

import com.insurance.crm.constant.HttpStatuses;
import com.insurance.crm.dto.agent.AgentRoleDto;
import com.insurance.crm.dto.agent.AgentStatusDto;
import com.insurance.crm.dto.agent.RoleDto;
import com.insurance.crm.entity.enums.AgentStatus;
import com.insurance.crm.service.impl.AgentServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    @ApiOperation(value = "Update role of agent")
    @ApiResponses(value = {
            @ApiResponse(code=200, message = HttpStatuses.OK,response = AgentRoleDto.class),
            @ApiResponse(code=303, message = HttpStatuses.SEE_OTHER),
            @ApiResponse(code =400,message = HttpStatuses.BAD_REQUEST),
            @ApiResponse(code=403,message = HttpStatuses.FORBIDDEN)
    })
    @PatchMapping("role")
    public ResponseEntity<AgentRoleDto> updateRole(
            @Valid @RequestBody AgentRoleDto agentRoleDto,@ApiIgnore Principal principal){
        return ResponseEntity.status(HttpStatus.OK)
                .body(agentService.updateRole(
                                agentRoleDto.getId(),agentRoleDto.getRole()));
    }
    @ApiOperation(value = "Get all roles")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = HttpStatuses.OK, response = RoleDto.class),
            @ApiResponse(code = 303, message = HttpStatuses.SEE_OTHER),
            @ApiResponse(code = 403, message = HttpStatuses.FORBIDDEN)
    })
    @GetMapping("roles")
    public ResponseEntity<RoleDto> getRoles(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(agentService.getRoles());
    }

}
