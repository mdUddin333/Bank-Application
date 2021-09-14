package com.company.dao;

import com.company.information.BankAccount;
import com.company.information.Customer;

import java.sql.SQLException;

public interface CustomerDao {


    //add new customer
    void  addCustomer(Customer customer) throws SQLException;
    void addBankAccount(BankAccount bankAccount) throws SQLException;

    void viewBalance(int cust_id) throws SQLException;

    // update information
    void updateCustomer(Customer customer) throws SQLException;

    // they can see their information on the database
    // using account id,customer id, last name,username, and password


    public int findByAccId() throws SQLException;

    Customer findById(int custId) throws SQLException;

    Customer findByLastName(String lastName) throws SQLException;

    Customer findByUsername(String username) throws SQLException;

    Customer findByPassword(String password) throws SQLException;

    void deposit(int accId,double balance) throws SQLException;
    void withdraw(int accId,double balance) throws SQLException;

    boolean customerLoginUsername(String username,String password) throws SQLException;
    boolean customerLoginPassword(String username,String password) throws SQLException;


    void transferAmount(int custId, double amount) throws SQLException;
}
