package com.company.information;

import com.company.dao.AdminDao;
import com.company.dao.CustomerDao;
import com.company.daoImpl.AdminDapImpl;
import com.company.daoImpl.CustomerDaoImpl;
import com.company.menu.UserMenu;

import java.sql.*;
import java.util.Scanner;

public class LoginAll {

    static Scanner input = new Scanner(System.in);
    static CustomerDao customerDao = new CustomerDaoImpl();

    public static void adminLogin() throws SQLException {

        System.out.println("Enter admin username: ");
        String username = input.next();
        System.out.println("Enter admin password: ");
        String password = input.next();

        //from database
        AdminDapImpl adminDao = new AdminDapImpl();

        if ( adminDao.adminLoginUsername(username,password) && adminDao.adminLoginPassword(username,password)){
            System.out.println("Admin logged in!!!!!!!!!!!!!");
            UserMenu.adminLog();
        }else {
            System.out.println("Try next time!!!!! Thanks");

        }
    }

    public static void customerLogin() throws SQLException {

        Customer customer = new Customer();

        System.out.println("Enter customer username: ");
        String username = input.next();
        System.out.println("Enter customer password: ");
        String password = input.next();

        //from database
        CustomerDao cd = new CustomerDaoImpl();


        if ( cd.customerLoginUsername(username,password) && cd.customerLoginPassword(username,password)){
            System.out.println("Customer logged in!!!!!!!!!!!!!\n");
            cd.findByUsername(username);
            UserMenu.customerLog();
        }else {
            System.out.println("Try next time!!!!! Thanks");

        }

    }


}
