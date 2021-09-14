package com.company.dao.factory;

import com.company.dao.CustomerDao;
import com.company.daoImpl.CustomerDaoImpl;

public class CustomerDaoFactory {

    private static CustomerDao dao;

    private CustomerDaoFactory(){

    }
    public static CustomerDao getCustomerDao(){
        if (dao==null){
            dao=new CustomerDaoImpl();
        }

        return dao;
    }

}
