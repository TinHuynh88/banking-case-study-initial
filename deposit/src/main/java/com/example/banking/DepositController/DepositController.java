package com.example.banking.DepositController;

import com.example.banking.DepositModel.Deposit;
import com.example.banking.DepositService.DepositService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class DepositController {
    private DepositService service;

    public DepositController(DepositService service) {
        this.service = service;
    }

    // create
    @PostMapping(value = "/deposit/createDepositAccount", produces = "application/json")
    public Deposit createLoan(@RequestBody Deposit deposit){
        if(deposit.getClientId()== null || deposit.getName()==null)
            return this.service.createDeposit("No Deposit Accounts available to show currently");

        return this.service.createDeposit(deposit.getClientId(),deposit.getName(),deposit.getBalance());
    }

    // getDepositsByClientId
    @GetMapping(value = "/deposit/getDepositAccountsByClientId/{clientId}", produces = "application/json")
    public List<Deposit> getDepositsByClientId(@PathVariable String clientId){
        List<Deposit> list;
        try {
            list = this.service.getDepositsByClientId(clientId);
        }catch(Exception e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ClientId [" + clientId + "] Not Found", e);
        }
        return list;
    }

    // getAllDeposit
    @GetMapping(value = "/deposit/getAllDepositAccounts", produces = "application/json")
    public List<Deposit> getAllDeposits(){
        List<Deposit> list;
        try {
            list = this.service.getAllDeposits();
        }catch(Exception e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "There is no Deposit", e);
        }
        return list;
    }

    //updateLoan
    @PutMapping(value = "/deposit/updateDepositAccount/{id}", produces = "application/json")
    public Deposit udpdateDeposit(@PathVariable Long id, @RequestBody Deposit deposit){
        deposit.setId(id);
        Deposit depositUpdate;
        try {
            depositUpdate = this.service.updateDeposit(deposit);
        }catch(Exception e){

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "False to update Deposit id =" + deposit.getId(), e);

        }
        return depositUpdate;
    }

    //deleteDeposit
    @DeleteMapping(value = "/deposit/deleteDepositAccount/{id}", produces = "application/json")
    public String deleteDeposit(@PathVariable Long id){

        try {
            boolean isdelete = this.service.deleteDeposit(id);
            if(!isdelete){
                return "Recode not deleted";
            }
        }catch(Exception e){

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "False to delete Deposit id =" + id, e);

        }
        return "Deposit id = "+ id + " deleted success.";
    }
}
