package com.company.daoImpl;

import com.company.information.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;


class CustomerDaoImplTest {


    @Test
    void customerLoginUsername()throws SQLException{
        CustomerDaoImpl customerDao = new CustomerDaoImpl();
        assertEquals(true,customerDao.customerLoginUsername("ema123","12345"));
    }


}