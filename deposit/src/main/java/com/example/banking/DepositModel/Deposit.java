package com.example.banking.DepositModel;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="seq", initialValue=100000000, allocationSize=1)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String clientId;
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
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
}
