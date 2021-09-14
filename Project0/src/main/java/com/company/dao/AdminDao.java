package com.company.dao;

import com.company.information.Admin;
import com.company.information.Customer;

import java.sql.SQLException;
import java.util.List;

public interface AdminDao {

    // admin
    void addAdmin(Admin admin) throws SQLException;
    void updateAdmin(Admin admin) throws SQLException;
    void deleteAdmin(int adminId) throws SQLException;
    List<Admin> getAdmin() throws SQLException;
    Admin adminById(int adminId) throws SQLException;
    Admin adminByLastName(String lastName) throws SQLException;
    Admin adminByUsername(String username) throws SQLException;
    Admin adminByPassword(String password) throws SQLException;
    boolean adminLoginUsername(String username,String password) throws SQLException;
    boolean adminLoginPassword(String username,String password) throws SQLException;


    //Customers

    void  addCustomer(Customer customer) throws SQLException;
    void updateCustomer(Customer customer) throws SQLException;
    void  deleteCustomer(int custId) throws SQLException;
    List<Customer> getCustomer() throws SQLException;
    Customer customerById(int custId) throws SQLException;
    Customer customerByLastName(String lastName) throws SQLException;
    Customer customerByUsername(String username) throws SQLException;
    Customer customerByPassword(String password) throws SQLException;









    /*
    public Admin getAllCustomer() throws SQLException;

    public Admin getCustomerById(int custid);

    public Admin createCustomer();

    public Admin deleteCustomer(int custId);

    public Admin updateCustomer(int custId);

    public Admin findByUserName(String username) throws SQLException;

    public Admin findByPassword(String password) throws SQLException;


     */

}
