package com.example.banking.Model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;


public class Deposit {

    private Long id;
    private String clientId;
    private Long accountNumber;
    private String name;
    private double balance;

    private String defaultMessage;

    public Deposit() {
    }

    public Deposit(String clientId, String name, double balance){
        this.clientId = clientId;
        this.name = name;
        this.balance = balance;
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

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
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

    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "id=" + id +
                ", clientId='" + clientId + '\'' +
                ", accountNumber=" + accountNumber +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", defaultMessage='" + defaultMessage + '\'' +
                '}';
    }

    //Builder
    public static DepositBuilder builder(){
        return new DepositBuilder();
    }

    public static final class DepositBuilder {
        private Deposit deposit;

        private DepositBuilder() {deposit = new Deposit();}

        public DepositBuilder withId(Long id){
            deposit.setId(id);
            return this;
        }
        public DepositBuilder withClientId(String clientId){
            deposit.setClientId(clientId);
            return this;
        }

        public DepositBuilder withAccountNumber(Long number){
            deposit.setAccountNumber(number);
            return this;
        }
        public DepositBuilder withName(String name){
            deposit.setName(name);
            return this;
        }

        public DepositBuilder withDefaulMessage(String message){
            deposit.setDefaultMessage(message);
            return this;
        }
        public DepositBuilder withBalance(double balance){
            deposit.setBalance(balance);
            return this;
        }

        public Deposit build(){return deposit;}
    }
}
