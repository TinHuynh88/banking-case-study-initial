package com.example.banking.Model;

public class OrchestratorMessage {

    private Deposit deposit;
    private CreditCard creditCard;
    private AutoLoan autoLoan;

    public OrchestratorMessage(Deposit deposit, CreditCard creditCard, AutoLoan autoLoan) {
        this.deposit = deposit;
        this.creditCard = creditCard;
        this.autoLoan = autoLoan;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AggregatorMessage{");
        sb.append("message='").append('\'');
        sb.append('}');
        return sb.toString();
    }
}
