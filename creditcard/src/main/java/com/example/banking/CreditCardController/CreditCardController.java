package com.example.banking.CreditCardController;

import com.example.banking.CreditCardModel.CreditCard;
import com.example.banking.CreditCardService.CreditCardService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CreditCardController {
    private CreditCardService service;

    public CreditCardController(CreditCardService service) {
        this.service = service;
    }
    // create
    @PostMapping(value = "/createCreditCard", produces = "application/json")
    public CreditCard createLoan(@RequestBody CreditCard creditCard){
        if(creditCard.getClientId()== null || creditCard.getName()==null || creditCard.getNumber()== null)
            return this.service.createCreditCard("No accounts available to show currently");

        if((creditCard.getNumber().length()!= 19 && creditCard.getNumber().length()!= 16  )||!creditCard.getNumber().startsWith("1234"))
            return this.service.createCreditCard("Credit Card Number is not follow the format");

        if(this.service.getCreditCardByNumber(creditCard.getNumber()) != null)
            return this.service.createCreditCard("This Credit Card Number had in system");

        return this.service.createCreditCard(creditCard.getClientId(),creditCard.getNumber(),creditCard.getName(),creditCard.getBalance());
    }

    // getLoansByClientId
    @GetMapping(value = "/getCreditCardsByClientId/{clientId}", produces = "application/json")
    public List<CreditCard> getCreditCardsByClientId(@PathVariable String clientId){
        List<CreditCard> list;
        try {
            list = this.service.getCreditCardsByClientId(clientId);
        }catch(Exception e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ClientId [" + clientId + "] Not Found", e);
        }
        return list;
    }

    // getAllLoans
    @GetMapping(value = "/getAllCreditCards", produces = "application/json")
    public List<CreditCard> getAllCreditCards(){
        List<CreditCard> list;
        try {
            list = this.service.getAllCreditCards();
        }catch(Exception e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "There is no CreditCard", e);
        }
        return list;
    }

    //updateLoan
    @PutMapping(value = "/updateCreditCard/{id}", produces = "application/json")
    public CreditCard udpdateCreditCard(@PathVariable Long id, @RequestBody CreditCard creditCard){
        creditCard.setId(id);
        CreditCard autoCreditCardUpdate;
        try {
            autoCreditCardUpdate = this.service.updateCreditCard(creditCard);
        }catch(Exception e){

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "False to update CreditCard id =" + creditCard.getId(), e);

        }
        return autoCreditCardUpdate;
    }

    //deleteloan
    @DeleteMapping(value = "/deleteCreditCard/{id}", produces = "application/json")
    public String deleteCreditCard(@PathVariable Long id){

        try {
            boolean isdelete = this.service.deleteCreditCard(id);
            if(!isdelete){
                return "Recode not deleted";
            }
        }catch(Exception e){

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "False to delete CreditCard id =" + id, e);

        }
        return "CreditCard id = "+ id + " deleted success.";
    }
}
