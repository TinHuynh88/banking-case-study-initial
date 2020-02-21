package com.example.banking.AutoLoanModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AutoLoan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String clientId;
    private String name;
    private double balance;


    public AutoLoan() {
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
}
