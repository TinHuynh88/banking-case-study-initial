package com.example.banking.AutoLoanService;
import com.example.banking.AutoLoanModel.AutoLoan;
import com.example.banking.AutoLoanRepository.AutoLoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoLoanService {


    private AutoLoanRepository autoLoanRepository;

  // public  AutoLoanService(){}
    public AutoLoanService(AutoLoanRepository autoLoanRepository) {
        this.autoLoanRepository = autoLoanRepository;
    }

    public AutoLoan createLoan(String clientId, String name, double balance){
        AutoLoan autoLoan = AutoLoan.builder()
                .withClientId(clientId)
                .withName(name)
                .withBalance(balance)
                .build();
        return this.autoLoanRepository.save(autoLoan);
    }
    public AutoLoan updateLoan(Long id, String clientId){
        AutoLoan newAutoLoan = AutoLoan.builder()
                .withId(id)
                .withClientId(clientId)
                .build();
        return this.autoLoanRepository.save(newAutoLoan);
    }

    public AutoLoan updateLoan(Long id, String clientId, String name){
        AutoLoan newAutoLoan = AutoLoan.builder()
                .withId(id)
                .withClientId(clientId)
                .withName(name)
                .build();
        return this.autoLoanRepository.save(newAutoLoan);
    }

    public AutoLoan updateLoan(Long id, String clientId, String name, double balance){
        AutoLoan newAutoLoan = AutoLoan.builder()
                .withId(id)
                .withClientId(clientId)
                .withName(name)
                .withBalance(balance)
                .build();
        return this.autoLoanRepository.save(newAutoLoan);
    }
    public boolean deleteLoan(Long id){

        boolean success = true;

        try {
            this.autoLoanRepository.deleteById(id);
        }catch(Exception e){
            success = false;
        }
        return success;
    }

//    public List<AutoLoan> getLoansByClientId(String clientId){
//        return (List<AutoLoan>) this.autoLoanRepository.getAutoLoanByClientId(clientId);
//    }
//
    public List<AutoLoan> getAllLoans(){
        return (List<AutoLoan>) this.autoLoanRepository.findAll();
    }
}
