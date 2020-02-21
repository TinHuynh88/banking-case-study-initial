package com.example.banking.CreditCardModel;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String clientId;
    private String number;
    private String name;
    private double balance;

    private String defaultMessage;

    public CreditCard() {
    }

    public CreditCard(String clientId, String number, String name, double balance){
        this.clientId = clientId;
        this.number = number;
        this.name = name;
        this.balance = balance;
    }

    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "id=" + id +
                ", clientId='" + clientId + '\'' +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

    //Builder
    public static CreditCardBuilder builder(){
        return new CreditCardBuilder();
    }

    public static final class CreditCardBuilder {
        private CreditCard creditCard;

        private CreditCardBuilder() {creditCard = new CreditCard();}

        public CreditCardBuilder withId(Long id){
            creditCard.setId(id);
            return this;
        }
        public CreditCardBuilder withClientId(String clientId){
            creditCard.setClientId(clientId);
            return this;
        }

        public CreditCardBuilder withNumber(String number){
            creditCard.setNumber(number);
            return this;
        }
        public CreditCardBuilder withName(String name){
            creditCard.setName(name);
            return this;
        }

        public CreditCardBuilder withDefaulMessage(String message){
            creditCard.setDefaultMessage(message);
            return this;
        }
        public CreditCardBuilder withBalance(double balance){
            creditCard.setBalance(balance);
            return this;
        }

        public CreditCard build(){return creditCard;}
    }
}
