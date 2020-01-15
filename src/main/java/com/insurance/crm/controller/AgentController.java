package com.insurance.crm.controller;

import com.insurance.crm.constant.HttpStatuses;
import com.insurance.crm.entity.Agent;
import com.insurance.crm.service.FiliationService;
import com.insurance.crm.service.impl.AgentServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agent")

public class AgentController {
    @Autowired
    private AgentServiceImpl agentService;
    @Autowired
    private FiliationService filiationService;




    @ApiOperation(value = "Update Agent info")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = HttpStatuses.CREATED),
            @ApiResponse(code = 303, message = HttpStatuses.SEE_OTHER),
            @ApiResponse(code = 400, message = HttpStatuses.BAD_REQUEST),
            @ApiResponse(code = 403, message = HttpStatuses.FORBIDDEN)
    })
    @PutMapping("/{agentId}")
    public ResponseEntity updateAgent(@Valid @RequestBody Agent dto){
        return ResponseEntity.status(HttpStatus.OK)
                .body(agentService.update(dto));
    }
    @GetMapping(value = "/agent/")
    public List<Agent> getAll(){
        return agentService.getAgents();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Agent>> getById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(agentService.getById(id));
    }


}
