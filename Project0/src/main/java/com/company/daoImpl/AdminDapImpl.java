package com.company.daoImpl;

import com.company.connection.ConnectionFactory;
import com.company.dao.AdminDao;
import com.company.information.Admin;
import com.company.information.Customer;
import com.company.util.LogClass;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminDapImpl implements AdminDao {

    private static Statement statement = null;
    Connection connection = null;

    public AdminDapImpl() {
        try {
            this.connection = ConnectionFactory.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public void addAdmin(Admin admin) throws SQLException {
        String sql = "insert into admin(first_name,last_name,username,password) values (?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, admin.getFirstName());
        preparedStatement.setString(2, admin.getLastName());
        preparedStatement.setString(3, admin.getUsername());
        preparedStatement.setString(4, admin.getPassword());

        int count = preparedStatement.executeUpdate();
        if (count > 0)
            System.out.println("Admin added...");
        else
            System.out.println("Something went wrong.\nPlease try again");

    }

    @Override
    public void updateAdmin(Admin admin) throws SQLException {
        String sql = "update admin set first_name=?,last_name=?,username=?,password=? where admin_id=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, admin.getFirstName());
        preparedStatement.setString(2, admin.getLastName());
        preparedStatement.setString(3, admin.getUsername());
        preparedStatement.setString(4, admin.getPassword());
        preparedStatement.setInt(5, admin.getAdminId());

        int count = preparedStatement.executeUpdate();

        if (count > 0)
            System.out.println("Admin Updated!!!!!!!!!");
        else
            System.out.println("Something went wrong.\nPlease try again");


    }

    @Override
    public void deleteAdmin(int adminId) throws SQLException {
        String sql = "delete from admin where admin_id=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, adminId);

        int count = preparedStatement.executeUpdate();

        if (count > 0)
            System.out.println("Admin Deleted!!!!!!!!!1");
        else
            System.out.println("Something went wrong.\nPlease try again");

    }

    @Override
    public List<Admin> getAdmin() throws SQLException {
        List<Admin> admins = new ArrayList<>();

        String sql = "select * from admin";
        statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) {
            Admin admin = new Admin();

            admin.setAdminId(rs.getInt(1));
            admin.setFirstName(rs.getString(2));
            admin.setLastName(rs.getString(3));
            admin.setUsername(rs.getString(4));
            admin.setPassword(rs.getString(5));

            //adding to ArrayList
            admins.add(admin);
            // print out all admin from the database
            System.out.println(admin);

        }

        return admins;
    }

    @Override
    public Admin adminById(int adminId) throws SQLException {
        String sql = "select * from admin where admin_id=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, adminId);
        ResultSet rs = preparedStatement.executeQuery();

        Admin a = null;

        while (rs.next()) {
            a = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
        }

        if (a == null)
            System.out.println("Please provide the right Admin id.\n");
        else
            System.out.println(a + "\n");

        return a;
    }

    @Override
    public Admin adminByLastName(String lastName) throws SQLException {

        String sql = "select * from admin where last_name=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, lastName);
        ResultSet rs = preparedStatement.executeQuery();

        Admin a = null;

        while (rs.next()) {
            a = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
        }

        if (a == null)
            System.out.println("Please provide the right Admin last name.\n");
        else
            System.out.println(a + "\n");

        return a;


    }

    @Override
    public Admin adminByUsername(String username) throws SQLException {
        String sql = "select * from admin where username=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        ResultSet rs = preparedStatement.executeQuery();

        Admin a = null;

        while (rs.next()) {
            a = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
        }

        if (a == null)
            System.out.println("Please provide the right Admin username.\n");
        else
            System.out.println(a + "\n");

        return a;
    }

    @Override
    public Admin adminByPassword(String password) throws SQLException {
        String sql = "select * from admin where password=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, password);
        ResultSet rs = preparedStatement.executeQuery();

        Admin a = null;

        while (rs.next()) {
            a = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
        }

        if (a == null)
            System.out.println("Please provide the right Admin password.\n");
        else
            System.out.println(a + "\n");
        return a;
    }

    @Override
    public boolean adminLoginUsername(String username, String password) throws SQLException {

        String sql = "select username,password from admin where username=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            rs.getString("username");
            rs.getString("password");
            return true;
        }


        return false;
    }

    @Override
    public boolean adminLoginPassword(String username, String password) throws SQLException {
        String sql = "select username,password from admin where password=?";
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
    public void addCustomer(Customer customer) throws SQLException {
        String sql = "insert into customer(first_name,last_name,username,password) values (?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, customer.getFirstName());
        preparedStatement.setString(2, customer.getLastName());
        preparedStatement.setString(3, customer.getUsername());
        preparedStatement.setString(4, customer.getPassword());

        int count = preparedStatement.executeUpdate();
        if (count > 0)
            System.out.println(" Customer added...");
        else
            System.out.println("Something went wrong.\nPlease try again");
        LogClass.LogIt("info", "New Customer added to database for " + customer.getFirstName() + " " + customer.getLastName());

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
            System.out.println(" Customer Updated!!!!!!!!!");
        else
            System.out.println("Something went wrong.\nPlease try again");


    }

    @Override
    public void deleteCustomer(int custId) throws SQLException {
        String sql = "delete from customer where cust_id=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, custId);

        int count = preparedStatement.executeUpdate();

        if (count > 0)
            System.out.println(" Customer Deleted!!!!!!!!!");
        else
            System.out.println("Something went wrong.\nPlease try again");
        LogClass.LogIt("info", "Customer deleted: " + custId);
    }

    @Override
    public List<Customer> getCustomer() throws SQLException {
        List<Customer> customers = new ArrayList<>();

        String sql = "select * from customer";
        statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) {
            Customer customer = new Customer();

            customer.setCustId(rs.getInt(1));
            customer.setFirstName(rs.getString(2));
            customer.setLastName(rs.getString(3));
            customer.setUsername(rs.getString(4));
            customer.setPassword(rs.getString(5));

            //adding to ArrayList
            customers.add(customer);
            // print out all customers from the database
            System.out.println(customer);

        }

        return customers;
    }

    @Override
    public Customer customerById(int custId) throws SQLException {
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
    public Customer customerByLastName(String lastName) throws SQLException {
        String sql = "select * from customer where last_name=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, lastName);
        ResultSet rs = preparedStatement.executeQuery();

        Customer c = null;

        while (rs.next()) {
            c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
        }

        if (c == null)
            System.out.println("Please provide the right Customer Last Name.\n");
        else
            System.out.println(c + "\n");

        return c;
    }

    @Override
    public Customer customerByUsername(String username) throws SQLException {
        String sql = "select * from customer where username=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        ResultSet rs = preparedStatement.executeQuery();

        Customer c = null;

        while (rs.next()) {
            c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
        }

        if (c == null)
            System.out.println("Please provide the right Customer Username.\n");
        else
            System.out.println(c + "\n");

        return c;
    }

    @Override
    public Customer customerByPassword(String password) throws SQLException {
        String sql = "select * from customer where password=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, password);
        ResultSet rs = preparedStatement.executeQuery();

        Customer c = null;

        while (rs.next()) {
            c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
        }

        if (c == null)
            System.out.println("Please provide the right Customer password.\n");
        else
            System.out.println(c + "\n");

        return c;
    }
}
