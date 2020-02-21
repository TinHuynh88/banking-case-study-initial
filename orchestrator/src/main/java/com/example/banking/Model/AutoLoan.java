package com.example.banking.Model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class AutoLoan {


    private Long id;
    private String clientId;
    private String name;
    private double balance;

    private String defaultMessage;


    public AutoLoan() {
    }

    public AutoLoan(String clientId, String name, double balance){
        this.clientId = clientId;
        this.name = name;
        this.balance = balance;
    }

    public String getDefaultMessage() {
        return defaultMessage;
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

    @Override
    public String toString() {
        return "AutoLoan{" +
                "id=" + id +
                ", clientId='" + clientId + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

    //Builder
    public static AutoLoanBuilder builder(){
        return new AutoLoanBuilder();
    }

    public static final class AutoLoanBuilder {
        private AutoLoan autoLoan;

        private AutoLoanBuilder() {autoLoan = new AutoLoan();}

        public AutoLoanBuilder withId(Long id){
            autoLoan.setId(id);
            return this;
        }
        public AutoLoanBuilder withClientId(String clientId){
            autoLoan.setClientId(clientId);
            return this;
        }

        public AutoLoanBuilder withName(String name){
            autoLoan.setName(name);
            return this;
        }

        public AutoLoanBuilder withDefaulMessage(String message){
            autoLoan.setDefaultMessage(message);
            return this;
        }
        public AutoLoanBuilder withBalance(double balance){
            autoLoan.setBalance(balance);
            return this;
        }

        public AutoLoan build(){return autoLoan;}
    }
}
