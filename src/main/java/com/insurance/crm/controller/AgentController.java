package com.insurance.crm.controller;

import com.insurance.crm.service.impl.AgentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agent")
@AllArgsConstructor
public class AgentController {
    private AgentServiceImpl agentService;

//    @ApiOperation(value = "Update status of agent")
//    @ApiResponses(value = {
//            @ApiResponse(code=200, message = HttpStatuses.OK,response = AgentStatus.class),
//            @ApiResponse(code=303, message = HttpStatuses.SEE_OTHER),
//            @ApiResponse(code =400,message = HttpStatuses.BAD_REQUEST),
//            @ApiResponse(code=403,message = HttpStatuses.FORBIDDEN)
//    })
//    @PatchMapping("status")
//    public ResponseEntity<AgentStatusDto> updateStatus(
//            @Valid @RequestBody AgentStatusDto agentStatusDto, @ApiIgnore Principal principal){
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(agentService.update(
//                        agentStatusDto.getId(),agentStatusDto.getAgentStatus());
//
//    }
}
