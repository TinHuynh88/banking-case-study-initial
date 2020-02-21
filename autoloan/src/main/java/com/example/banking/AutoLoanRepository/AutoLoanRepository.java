package com.example.banking.AutoLoanRepository;

import com.example.banking.AutoLoanModel.AutoLoan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AutoLoanRepository extends CrudRepository<AutoLoan, Long> {

   List<AutoLoan> getAutoLoansByClientId(String clientId);

}
