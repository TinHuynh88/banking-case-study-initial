package com.example.banking.DepositRepository;

import com.example.banking.DepositModel.Deposit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepositRepository extends CrudRepository<Deposit, Long> {

    List<Deposit> getDepositsByClientId(String clientId);

    Deposit getDepositById(Long id);

    Deposit getDepositByAccountNumber(Long accountNumber);
}
