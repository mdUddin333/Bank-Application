package com.company.information;

public class BankAccount {


    private int accId;
    private int custId;
    private double balance;

    public BankAccount(){


    }

    public BankAccount(int accId, int custId, double balance) {
        this.accId = accId;
        this.custId = custId;
        this.balance = balance;
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accId=" + accId +
                ", custId=" + custId +
                ", balance=" + balance +
                '}';
    }




}
