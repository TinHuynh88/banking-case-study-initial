package com.example.banking.AutoLoanService;
import com.example.banking.AutoLoanModel.AutoLoan;
import com.example.banking.AutoLoanRepository.AutoLoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoLoanService {


    private AutoLoanRepository autoLoanRepository;

    public AutoLoanService(AutoLoanRepository autoLoanRepository) {
        this.autoLoanRepository = autoLoanRepository;
    }

    //Create
    public AutoLoan createLoan(String clientId, String name, double balance){
        AutoLoan autoLoan = AutoLoan.builder()
                .withClientId(clientId)
                .withName(name)
                .withBalance(balance)
                .build();
        return this.autoLoanRepository.save(autoLoan);
    }
    public AutoLoan createLoan(String defaulMessage){
        AutoLoan autoLoan = AutoLoan.builder()
                .withDefaulMessage(defaulMessage)
                .build();
        return autoLoan;
    }

    //Update
    public AutoLoan updateLoan(AutoLoan autoLoan){

        AutoLoan autoLoanupdate = this.autoLoanRepository.getAutoLoanById(autoLoan.getId());
        if(autoLoan.getClientId() != null){
            autoLoanupdate.setClientId(autoLoan.getClientId());
        }
        if(autoLoan.getName() != null){
            autoLoanupdate.setName(autoLoan.getName());
        }
        if(autoLoan.getBalance() != 0){
            autoLoanupdate.setBalance(autoLoan.getBalance());
        }
        return this.autoLoanRepository.save(autoLoanupdate);
    }

    //deleteLoan
    public boolean deleteLoan(Long id){

        boolean success = true;

        try {
            this.autoLoanRepository.deleteById(id);
        }catch(Exception e){
            success = false;
        }
        return success;
    }

    //getLoansByClientId
    public List<AutoLoan> getLoansByClientId(String clientId){
        return (List<AutoLoan>) this.autoLoanRepository.getAutoLoansByClientId(clientId);
    }

    //getAllLoans
    public List<AutoLoan> getAllLoans(){
        return (List<AutoLoan>) this.autoLoanRepository.findAll();
    }
}
