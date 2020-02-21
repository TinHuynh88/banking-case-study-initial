package com.example.banking.RestClient;

import com.example.banking.Model.AutoLoan;
import com.example.banking.Model.CreditCard;
import com.example.banking.Model.Deposit;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OrchestratorRestClient {

    private RestTemplate restTemplate;

    public OrchestratorRestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Deposit getDepositAccountsByClientId(String clientId) {

        final String uri = "http://localhost:9093/deposit/getDepositAccountsByClientId/"+clientId;
        Deposit result = restTemplate.getForObject(uri, Deposit.class);
        return result;
    }

    public CreditCard getCreditCardsByClientId(String clientId) {
        final String uri = "http://localhost:9092/creditcard/getCreditCardsByClientId/"+clientId;

        CreditCard result = restTemplate.getForObject(uri, CreditCard.class);

        return result;
    }

    public AutoLoan getLoandsByClientId(String clientId) {
        final String uri = "http://localhost:9091/autoloan/getLoandsByClientId/"+clientId;

        AutoLoan result = restTemplate.getForObject(uri, AutoLoan.class);

        return result;
    }

}
