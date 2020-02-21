package com.example.banking.Service;

import com.example.banking.Model.AutoLoan;
import com.example.banking.Model.CreditCard;
import com.example.banking.Model.Deposit;
import com.example.banking.Model.OrchestratorMessage;
import com.example.banking.RestClient.OrchestratorRestClient;
import org.springframework.stereotype.Service;

@Service
public class OrchestratorService {

    private OrchestratorRestClient restClient;

    public OrchestratorService(OrchestratorRestClient restClient) {
        this.restClient = restClient;
    }

    public String getMessage(String clientId) {

        // Call Deposit
        Deposit deposit = restClient.getDepositAccountsByClientId(clientId);

        // Call Credit Card
        CreditCard creditCard = restClient.getCreditCardsByClientId(clientId);

        // Call Auto Loan
        AutoLoan autoLoan = restClient.getLoandsByClientId(clientId);


        //Aggregate message an return
        StringBuilder builder = new StringBuilder();

        builder.append(deposit);
        builder.append(" ");
        builder.append(creditCard);
        builder.append("!");

        String message = builder.toString();
        System.out.println("Test: "+ message);
        OrchestratorMessage orchestratorMessage = new OrchestratorMessage(deposit,creditCard,autoLoan);
        System.out.println("Test aggregtorMessage: "+ orchestratorMessage);
        return message;
    }
}
