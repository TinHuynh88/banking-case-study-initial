package com.example.banking.Controller;

import com.example.banking.Service.OrchestratorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrchestratorController {

    OrchestratorService service;

    public OrchestratorController(OrchestratorService service) {
        this.service = service;
    }

    @GetMapping(value ="/getAccountSummaryByClientId/{clientId}", produces = "application/json")
    public String getMessage(@PathVariable String clientId){

        return service.getMessage(clientId);
    }

}
