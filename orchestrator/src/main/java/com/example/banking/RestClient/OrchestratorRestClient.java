package com.example.banking.RestClient;

import com.example.banking.Model.AutoLoan;
import com.example.banking.Model.CreditCard;
import com.example.banking.Model.Deposit;
import org.springframework.http.ResponseEntity;
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
        ResponseEntity<Deposit> responseEntity = restTemplate.getForEntity(uri, Deposit.class);
        Deposit result = responseEntity.getBody();
        return result;
    }

    public CreditCard getCreditCardsByClientId(String clientId) {
        final String uri = "http://localhost:9092/creditcard/getCreditCardsByClientId/"+clientId;

        ResponseEntity<CreditCard> responseEntity = restTemplate.getForEntity(uri, CreditCard.class);
        CreditCard result = responseEntity.getBody();
        return result;
    }

    public AutoLoan getLoandsByClientId(String clientId) {
        final String uri = "http://localhost:9091/autoloan/getLoandsByClientId/"+clientId;

        ResponseEntity<AutoLoan> responseEntity = restTemplate.getForEntity(uri, AutoLoan.class);
        AutoLoan result = responseEntity.getBody();
        return result;
    }

}
