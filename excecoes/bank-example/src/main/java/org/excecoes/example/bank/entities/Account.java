package org.excecoes.example.bank.entities;

import org.excecoes.example.bank.exceptions.BusinessExcepetion;

public class Account {
    private Integer number;
    private String name;
    private Double balance;
    private Double withdrawLimit;

    public Account() {
    }

    public Account(Integer number, String name, Double balance, Double withdrawLimit) {
        this.number = number;
        this.name = name;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double amount){
        this.balance += amount;
    }

    public void withdraw(Double amount){
        validateWithdraw(amount);
        this.balance -= amount;
    }

    private void validateWithdraw(Double amount){
        if(amount > getWithdrawLimit()){
            throw new BusinessExcepetion("Erro de saque: A quantia excede o limte de saque.");
        }
        if(amount > getBalance()){
            throw new BusinessExcepetion("Erro de saque: Saldo insuficiente.");
        }
    }
}
