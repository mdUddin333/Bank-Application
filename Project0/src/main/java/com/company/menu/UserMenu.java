package com.company.menu;

import com.company.dao.AdminDao;
import com.company.dao.CustomerDao;
import com.company.dao.factory.AdminDaoFactory;
import com.company.dao.factory.CustomerDaoFactory;
import com.company.information.*;

import java.sql.SQLException;
import java.util.Scanner;

public class UserMenu {

    static int menu = 0;
    static Scanner input = new Scanner(System.in);
    //admin
    static Admin admin = new Admin();
    static AdminDao adminDao = AdminDaoFactory.getAdminDao();
    //customer
    static Customer customer = new Customer();
    static CustomerDao customerDao = CustomerDaoFactory.getCustomerDao();


    public static void option() throws SQLException {

        do {


            System.out.println("Welcome to our Bank.\nPlease select your option here");

            System.out.println("1. Open an Account");
            System.out.println("2. Customer Login");
            System.out.println("3. Admin Login");
            System.out.println("4. Quit");

            menu = input.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("Thank you for Opening an Account\n");
                    OpenCustomerAccount.openAccount();
                    break;
                case 2:
                    System.out.println("Welcome to Customer portal!!!!!!!!!!!!\n");
                    customerLogin();
                    break;
                case 3:
                    System.out.println("Welcome to Admin page\n");
                    adminLogin();
                    break;
                case 4:
                    System.out.println("Thank you for choosing our Bank Application\n");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option!! Please select your option from 1 to 4\n");
                    option();
            }

        }while (menu!=4);

    }


    //2.
    public static void customerLogin() throws SQLException {

        LoginAll.customerLogin();

    }

    public static void customerLog() throws SQLException {

        do {


            System.out.println("Welcome to the customer portal.");

            System.out.println("1. View Balance.");
            System.out.println("2. Deposit.");
            System.out.println("3. Withdraw.");
            System.out.println("4. Update information.");
            System.out.println("5. Transfer money to other account.");
            System.out.println("6. Logout.");

            menu = input.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("Please enter your customer id");
                    int custId = input.nextInt();

                        customerDao.viewBalance(custId);
                    break;

                    //deposit
                case 2:
                    System.out.println("How much do you like to deposit: ");
                    double amount=input.nextDouble();
                    System.out.println("what is your Account number: ");
                    int accId1=input.nextInt();

                    customerDao.deposit(accId1,amount);
                    break;

                    //withdraw
                case 3:
                    System.out.println("How much do you like to withdraw: ");
                    double withAmount=input.nextInt();
                    System.out.println("what is your Account number: ");
                    int accId3=input.nextInt();
                    customerDao.withdraw(accId3,withAmount);
                    break;

                    //Update
                case 4:
                    System.out.println("Enter your Customer Id: ");
                    int upid = input.nextInt();
                    System.out.println("Enter your first name: ");
                    String fName = input.next();
                    System.out.println("Enter your last name: ");
                    String lName = input.next();
                    System.out.println("Enter your username: ");
                    String upUName = input.next();
                    System.out.println("Enter your Password: ");
                    String upPWord = input.next();

                    customer.setCustId(upid);
                    customer.setFirstName(fName);
                    customer.setLastName(lName);
                    customer.setUsername(upUName);
                    customer.setPassword(upPWord);
                    customerDao.updateCustomer(customer);
                    break;
                    //Transfer
                case 5:
                    System.out.println("Enter your transfer from the Account id:");
                    int withd=input.nextInt();
                    System.out.println("Enter your transfer to the Account id:");
                    int accid=input.nextInt();
                    System.out.println("Enter your transfer amount: ");
                    double amount2=input.nextDouble();

                    customerDao.transferAmount(accid,amount2);
                    customerDao.withdraw(withd,amount2);
                    break;

                case 6:
                    System.out.println("Successfully Logout.\n");
                    break;
                default:
                    System.out.println("Wrong option!!! Try again");
                    option();
                    break;
            }
        }while (menu!=6);
    }

    //3.
    public static void adminLogin() throws SQLException {
        LoginAll.adminLogin();
    }

    public static void adminLog() throws SQLException {

        do {


            System.out.println("\nWelcome to admin portal.");
            // all customer operations
            System.out.println("All the Customer operations here:\n");
            System.out.println("1. View all Customer.");
            System.out.println("2. create Customer Account.");
            System.out.println("3. Delete Customer.");
            System.out.println("4. Update Customer Information.");
            System.out.println("5. Find Customer by id.");
            System.out.println("6. Find Customer by last name.");
            System.out.println("7. Find Customer by Username.");
            System.out.println("8. Find Customer by Password.\n");
            System.out.println("All the Admin operations here:\n");
            // all admin operations
            System.out.println("9. Add admin..");
            System.out.println("10. Update Admin.");
            System.out.println("11. Delete Admin.");
            System.out.println("12. View All the Admins.");
            System.out.println("13. Find Admin by id.");
            System.out.println("14. Find Admin by last name.");
            System.out.println("15. Find Admin by Username.");
            System.out.println("16. Find Admin by Password.");
            // Lastly Admin Logout!!!
            System.out.println("17. Logout.");


            menu = input.nextInt();

            switch (menu) {
                //1. View all Customer.
                case 1:
                    System.out.println("All customer Information here\n");
                    adminDao.getCustomer();
                    adminLog();
                    break;
                    //2. create Customer Account.
                case 2:
                    OpenCustomerAccount.openAccount();
                    break;
                    //3. Delete Customer.
                case 3:
                    System.out.println("Please enter customer Id here ");
                    int custId = input.nextInt();
                    adminDao.deleteCustomer(custId);
                    break;
                    //4. Update Customer Information.
                case 4:
                    System.out.println("Enter your Customer Id: ");
                    int upid = input.nextInt();
                    System.out.println("Enter your first name: ");
                    String fName = input.next();
                    System.out.println("Enter your last name: ");
                    String lName = input.next();
                    System.out.println("Enter your username: ");
                    String upUName = input.next();
                    System.out.println("Enter your Password: ");
                    String upPWord = input.next();

                    customer.setCustId(upid);
                    customer.setFirstName(fName);
                    customer.setLastName(lName);
                    customer.setUsername(upUName);
                    customer.setPassword(upPWord);
                    adminDao.updateCustomer(customer);
                    break;

                    //5. Find Customer by id.
                case 5:
                    System.out.println("Enter customer id here");
                    int custId2 = input.nextInt();
                    adminDao.customerById(custId2);
                    break;

                    //6. Find Customer by last name.
                case 6:
                    System.out.println("Enter Customer last name: ");
                    String cLName=input.next();
                    adminDao.customerByLastName(cLName);
                    break;
                    //7. Find Customer by Username.
                case 7:
                    System.out.println("Enter Customer Username: ");
                    String cUName=input.next();
                    adminDao.customerByUsername(cUName);
                    break;
                    //8. Find Customer by Password.
                case 8:
                    System.out.println("Enter Customer Password: ");
                    String cpName=input.next();
                    adminDao.customerByPassword(cpName);
                    break;

                // All admin operations start here:

                //9. Add admin.
                case 9:
                    System.out.println("Enter your first name: ");
                    String adfName = input.next();
                    System.out.println("Enter your last name: ");
                    String adlName = input.next();
                    System.out.println("Enter your username: ");
                    String adUName = input.next();
                    System.out.println("Enter your Password: ");
                    String adPWord = input.next();

                    admin.setFirstName(adfName);
                    admin.setLastName(adlName);
                    admin.setUsername(adUName);
                    admin.setPassword(adPWord);

                    adminDao.addAdmin(admin);

                    break;

                //10. Update Admin.

                case 10:
                    System.out.println("Enter your admin Id: ");
                    int adid = input.nextInt();
                    System.out.println("Enter your first name: ");
                    String adName = input.next();
                    System.out.println("Enter your last name: ");
                    String alName = input.next();
                    System.out.println("Enter your username: ");
                    String aUName = input.next();
                    System.out.println("Enter your Password: ");
                    String aPWord = input.next();

                    admin.setAdminId(adid);
                    admin.setFirstName(adName);
                    admin.setLastName(alName);
                    admin.setUsername(aUName);
                    admin.setPassword(aPWord);
                    adminDao.updateAdmin(admin);
                    break;

                    //11. Delete Admin.
                case 11:
                    System.out.println("Please enter admin Id here ");
                    int adid1 = input.nextInt();
                    adminDao.deleteAdmin(adid1);
                    break;

                    //12. View All the Admins.
                case 12:
                    System.out.println("All Admin Information here ");
                    adminDao.getAdmin();
                    adminLog();
                    break;

                    //13. Find Admin by id.
                case 13:
                    System.out.println("Enter Admin id here");
                    int adminId = input.nextInt();
                    adminDao.adminById(adminId);
                    break;

                    //14. Find Admin by last name.
                case 14:
                    System.out.println("Enter Admin last name: ");
                    String adLName=input.next();
                    adminDao.adminByLastName(adLName);
                    break;

                    //15. Find Admin by Username.
                case 15:
                    System.out.println("Enter Admin Username: ");
                    String admUName=input.next();
                    adminDao.adminByUsername(admUName);
                    break;
                //16. Find Admin by Password.
                case 16:
                    System.out.println("Enter Admin Password: ");
                    String admpName=input.next();
                    adminDao.adminByPassword(admpName);
                    break;

                    //17. Logout.
                case 17:
                    System.out.println("Thank you using our bank application.  ");
                    option();
                    break;

                default:
                    System.out.println("Wrong option!!! Try again");
                    option();
                    break;
            }
        }while (menu!=17);

    }

}
