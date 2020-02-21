package com.example.banking.AutoLoanController;

import com.example.banking.AutoLoanModel.AutoLoan;
import com.example.banking.AutoLoanService.AutoLoanService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class AutoLoanController {


    private AutoLoanService service;

    public AutoLoanController(AutoLoanService service) {
        this.service = service;
    }

    // create
    @PostMapping(value = "/createLoan", produces = "application/json")
    public AutoLoan createLoan(@RequestBody AutoLoan autoLoan){
        if(autoLoan.getClientId()== null || autoLoan.getName()==null)
            return this.service.createLoan("No accounts available to show currently");

    return this.service.createLoan(autoLoan.getClientId(),autoLoan.getName(),autoLoan.getBalance());
    }

    // getLoansByClientId
    @GetMapping(value = "/getLoandsByClientId/{clientId}", produces = "application/json")
    public List<AutoLoan> getLoandsByClientId(@PathVariable String clientId){
        List<AutoLoan> list;
        try {
            list = this.service.getLoansByClientId(clientId);
        }catch(Exception e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ClientId [" + clientId + "] Not Found", e);
        }
        return list;
    }

    // getAllLoans
    @GetMapping(value = "/getAllLoans", produces = "application/json")
    public List<AutoLoan> getAllLoans(){
        List<AutoLoan> list;
        try {
            list = this.service.getAllLoans();
        }catch(Exception e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "There is no Loans", e);
        }
        return list;
    }

    //updateLoan
    @PutMapping(value = "/updateLoan/{id}", produces = "application/json")
    public AutoLoan getLoandsByClientId(@PathVariable Long id, @RequestBody AutoLoan autoLoan){
        autoLoan.setId(id);
        AutoLoan autoLoanUpdate;
        try {
            autoLoanUpdate = this.service.updateLoan(autoLoan);
        }catch(Exception e){

                    throw new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "False to update Loan id =" + autoLoan.getId(), e);

        }
        return autoLoanUpdate;
    }

    //deleteloan
    @DeleteMapping(value = "/deleteLoan/{id}", produces = "application/json")
    public String deleteLoan(@PathVariable Long id){

        try {
            boolean isdelete = this.service.deleteLoan(id);
            if(!isdelete){
                return "Recode not deleted";
            }
        }catch(Exception e){

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "False to delete Loan id =" + id, e);

        }
        return "Loan id = "+ id + " deleted success.";
    }
}
