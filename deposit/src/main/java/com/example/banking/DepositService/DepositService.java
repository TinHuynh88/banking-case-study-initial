package com.example.banking.DepositService;

import com.example.banking.DepositModel.Deposit;
import com.example.banking.DepositRepository.DepositRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class DepositService {

    private DepositRepository depositRepository;

    public DepositService(DepositRepository depositRepository) {
        this.depositRepository = depositRepository;
    }

    //Create
    public Deposit createDeposit(String clientId, String name, double balance){
        Long accountNumber ;
        {
            accountNumber = generateRandom(9);
        }while(this.depositRepository.getDepositByAccountNumber(accountNumber)!=null);

        Deposit deposit = Deposit.builder()
                .withClientId(clientId)
                .withAccountNumber(accountNumber)
                .withName(name)
                .withBalance(balance)
                .build();
        return this.depositRepository.save(deposit);
    }
    public Deposit createDeposit(String defaulMessage){
        Deposit autoLoan = Deposit.builder()
                .withDefaulMessage(defaulMessage)
                .build();
        return autoLoan;
    }

    //Update
    public Deposit updateDeposit(Deposit deposit){

        Deposit depositUpdate = this.depositRepository.getDepositById(deposit.getId());
        if(deposit.getClientId() != null){
            depositUpdate.setClientId(deposit.getClientId());
        }
        if(deposit.getName() != null){
            depositUpdate.setName(deposit.getName());
        }
        if(deposit.getBalance() != 0){
            depositUpdate.setBalance(deposit.getBalance());
        }
        if(deposit.getAccountNumber() != 0){
            depositUpdate.setAccountNumber(deposit.getAccountNumber());
        }
        return this.depositRepository.save(depositUpdate);
    }

    //deleteDeposit
    public boolean deleteDeposit(Long id){

        boolean success = true;

        try {
            this.depositRepository.deleteById(id);
        }catch(Exception e){
            success = false;
        }
        return success;
    }

    //getDepositsByClientId
    public List<Deposit> getDepositsByClientId(String clientId){
        return (List<Deposit>) this.depositRepository.getDepositsByClientId(clientId);
    }

    //getAllDeposit
    public List<Deposit> getAllDeposits(){
        return (List<Deposit>) this.depositRepository.findAll();
    }


    public static long generateRandom(int length) {
        Random random = new Random();
        char[] digits = new char[length];
        digits[0] = (char) (random.nextInt(9) + '1');
        for (int i = 1; i < length; i++) {
            digits[i] = (char) (random.nextInt(10) + '0');
        }
        return Long.parseLong(new String(digits));
    }
}
