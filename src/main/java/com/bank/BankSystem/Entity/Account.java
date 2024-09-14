package com.bank.BankSystem.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountNumber;
    @Column
    private String accountOwner;
    @Column
    private Double accountBalance;

    public Account(){

    }

    public Account(String accountOwner, Double accountBalance) {
        this.accountOwner = accountOwner;
        this.accountBalance = accountBalance;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "Emloyee{" +
                "accountNumber=" + accountNumber +
                ", accountOwner='" + accountOwner + '\'' +
                ", accountBalance=" + accountBalance +
                '}';
    }
}
