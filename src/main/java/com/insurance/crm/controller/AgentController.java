package com.insurance.crm.controller;

import com.insurance.crm.service.impl.AgentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("/agent")
@AllArgsConstructor
public class AgentController {
    private AgentServiceImpl agentService;

    @ApiOperation
}
