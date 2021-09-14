package com.company.daoImpl;

import com.company.connection.ConnectionFactory;
import com.company.dao.CustomerDao;
import com.company.information.BankAccount;
import com.company.information.Customer;
import com.company.util.LogClass;

import java.sql.*;

public class CustomerDaoImpl implements CustomerDao {

    private static Statement statement = null;
    Connection connection = null;
    public static int findId;

    public CustomerDaoImpl() {
        try {
            this.connection = ConnectionFactory.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void addCustomer(Customer customer) throws SQLException {
        String sql = "insert into customer(first_name,last_name,username,password) values (?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, customer.getFirstName());
        preparedStatement.setString(2, customer.getLastName());
        preparedStatement.setString(3, customer.getUsername());
        preparedStatement.setString(4, customer.getPassword());
        //preparedStatement.setDouble(5,customer.getBalance());
        int count = preparedStatement.executeUpdate();

        if (count > 0)
            System.out.println(" Customer added...");

        else
            System.out.println("Something went wrong.\nPlease try again");

        LogClass.LogIt("info", "New Customer added to database for " + customer.getFirstName() + " " + customer.getLastName());
    }


    @Override
    public void addBankAccount(BankAccount bankAccount) throws SQLException {
        String sql = "insert into bank_account (cust_id,balance) values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, bankAccount.getCustId());
        preparedStatement.setDouble(2, bankAccount.getBalance());

        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("Bank account created!!!!");
        } else {
            System.out.println("Something went wrong!!!!");
        }

    }

    @Override
    public void viewBalance(int cust_id) throws SQLException {

        String sql = "select balance from bank_account where cust_id=" + cust_id;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // preparedStatement.setInt(1, cust_id);
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            double balance = rs.getDouble("balance");
            System.out.println("Your balance is :$" + balance);
        }

    }

    @Override
    public void updateCustomer(Customer customer) throws SQLException {
        String sql = "update customer set first_name=?,last_name=?,username=?,password=? where cust_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, customer.getFirstName());
        preparedStatement.setString(2, customer.getLastName());
        preparedStatement.setString(3, customer.getUsername());
        preparedStatement.setString(4, customer.getPassword());
        preparedStatement.setInt(5, customer.getCustId());

        int count = preparedStatement.executeUpdate();
        if (count > 0)
            System.out.println("Customer Updated!!!!");
        else
            System.out.println("Something went wrong");
    }

    @Override
    public int findByAccId() throws SQLException {

        String sql = "select acc_id from bank_account";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            findId = rs.getInt(1);
        }
        return findId;
    }


    @Override
    public Customer findById(int custId) throws SQLException {
        String sql = "select * from customer where cust_id=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, custId);
        ResultSet rs = preparedStatement.executeQuery();

        Customer c = null;

        while (rs.next()) {
            c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
        }

        if (c == null)
            System.out.println("Please provide the right Customer id.\n");
        else
            System.out.println(c + "\n");

        return c;
    }

    @Override
    public Customer findByLastName(String lastName) throws SQLException {
        String sql = "select * from customer where lastname=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, lastName);
        ResultSet rs = preparedStatement.executeQuery();

        Customer c = null;

        while (rs.next()) {
            c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
        }

        if (c == null)
            System.out.println("Please provide the right Customer last name.\n");
        else
            System.out.println(c + "\n");

        return c;

    }

    @Override
    public Customer findByUsername(String username) throws SQLException {
        String sql = "select * from customer where username=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        ResultSet rs = preparedStatement.executeQuery();
        Customer c = null;

        while (rs.next()) {
            c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));

        }
        if (c == null)
            System.out.println("Please provide the right Customer Username .\n");
        else {
            System.out.println(c + "\n");
            System.out.println("Customer username correct!!!!\n");
        }
        return c;
    }

    @Override
    public Customer findByPassword(String password) throws SQLException {
        String sql = "select * from customer where password=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, password);
        ResultSet rs = preparedStatement.executeQuery();
        Customer c = null;

        while (rs.next()) {
            c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            System.out.println("This is your all information\n:" + c + "\n");
        }
        if (c == null)
            System.out.println("Please provide the right Customer Password .\n");
        else {
            System.out.println("This is your all information\n:" + c + "\n");
            System.out.println("Customer password correct!!!!\n");
        }

        return c;
    }

    @Override
    public void deposit(int accId, double balance) throws SQLException {

        String sql = "select * from bank_account where acc_id= " + accId;

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {

            String sql2 = "update bank_account set balance=? where acc_id=?";
            PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);

            double updateBalance = balance + rs.getDouble("balance");
            preparedStatement2.setDouble(1, updateBalance);
            preparedStatement2.setInt(2, accId);

            int count = preparedStatement2.executeUpdate();

            if (count > 0) {

                System.out.println("$"+balance + " has been deposit to this account number :"+accId);
                System.out.println("*****************************************");
                System.out.println("Your updated balance is $"+updateBalance+"\n");

            } else {
                System.out.println("Something went wrong with deposit!!!!");
            }

        }
    }

    @Override
    public void withdraw(int accId, double balance) throws SQLException {


        String sql = "select * from bank_account where acc_id= " + accId;

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            String sql2 = "update bank_account set balance=? where acc_id=?";
            PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);

            double updateBalance = rs.getDouble("balance");

            if ((updateBalance - balance) > 0) {
                updateBalance -= balance;
                preparedStatement2.setDouble(1, updateBalance);
                preparedStatement2.setInt(2, accId);

                int count = preparedStatement2.executeUpdate();
                if (count > 0) {
                    System.out.println("$"+balance + " has been withdrawed from this account number :"+accId);
                    System.out.println("*****************************************");
                    System.out.println("Your updated balance is $"+updateBalance+"\n");
                } else {
                    System.out.println("You do not sufficient balance on your account!!!");
                }
            } else {
                System.out.println("Balance not updated!!!!");
            }


        }


    }

    @Override
    public boolean customerLoginUsername(String username, String password) throws SQLException {


        String sql = "select username,password from customer where username=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        ResultSet rs = preparedStatement.executeQuery();

        Customer c = null;

        while (rs.next()) {
            rs.getString("username");
            rs.getString("password");
            return true;
        }
        return false;
    }

    @Override
    public boolean customerLoginPassword(String username, String password) throws SQLException {

        String sql = "select username,password from customer where password=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, password);
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            rs.getString("username");
            rs.getString("password");
            return true;
        }
        return false;
    }


    @Override
    public void transferAmount(int accid, double amount) throws SQLException {
        String sql = "select * from bank_account where acc_id=" + accid;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {

            int id = rs.getInt("acc_id");

            deposit(id, amount);
        }

    }

}
