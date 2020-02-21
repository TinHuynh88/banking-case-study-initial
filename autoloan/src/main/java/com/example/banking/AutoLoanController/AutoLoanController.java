package com.example.banking.AutoLoanController;

import com.example.banking.AutoLoanModel.AutoLoan;
import com.example.banking.AutoLoanService.AutoLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutoLoanController {


    private AutoLoanService service;

  //  public  AutoLoanController(){}
    public AutoLoanController(AutoLoanService service) {
        this.service = service;
    }

    // create
    @PostMapping(value = "/createLoan", produces = "application/json")
    public AutoLoan createLoan(@RequestBody AutoLoan autoLoan){
    return this.service.createLoan(autoLoan.getClientId(),autoLoan.getName(),autoLoan.getBalance());
    }
}
