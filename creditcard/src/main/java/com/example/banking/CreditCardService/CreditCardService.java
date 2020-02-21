package com.example.banking.CreditCardService;

import com.example.banking.CreditCardModel.CreditCard;
import com.example.banking.CreditCardRepository.CreditCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardService {
    private CreditCardRepository creditCardRepository;

    public CreditCardService(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    //Create
    public CreditCard createCreditCard(String clientId,String number, String name, double balance){
        CreditCard autoLoan = CreditCard.builder()
                .withClientId(clientId)
                .withNumber(number)
                .withName(name)
                .withBalance(balance)
                .build();
        return this.creditCardRepository.save(autoLoan);
    }
    public CreditCard createCreditCard(String defaulMessage){
        CreditCard autoLoan = CreditCard.builder()
                .withDefaulMessage(defaulMessage)
                .build();
        return autoLoan;
    }

    //Update
    public CreditCard updateCreditCard(CreditCard autoLoan){

        CreditCard autoLoanupdate = this.creditCardRepository.getCreditCardById(autoLoan.getId());
        if(autoLoan.getClientId() != null){
            autoLoanupdate.setClientId(autoLoan.getClientId());
        }
        if(autoLoan.getName() != null){
            autoLoanupdate.setName(autoLoan.getName());
        }
        if(autoLoan.getBalance() != 0){
            autoLoanupdate.setBalance(autoLoan.getBalance());
        }
        return this.creditCardRepository.save(autoLoanupdate);
    }

    //deleteLoan
    public boolean deleteCreditCard(Long id){

        boolean success = true;

        try {
            this.creditCardRepository.deleteById(id);
        }catch(Exception e){
            success = false;
        }
        return success;
    }

    //getLoansByClientId
    public List<CreditCard> getCreditCardsByClientId(String clientId){
        return (List<CreditCard>) this.creditCardRepository.getCreditCardsByClientId(clientId);
    }

    //getAllLoans
    public List<CreditCard> getAllCreditCards(){
        return (List<CreditCard>) this.creditCardRepository.findAll();
    }

    //getCreditCardByNumber
    public CreditCard getCreditCardByNumber(String number){
        return this.creditCardRepository.getCreditCardByNumber(number);
    }
}
