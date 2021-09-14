package com.company.dao.factory;

import com.company.dao.AdminDao;
import com.company.daoImpl.AdminDapImpl;

public class AdminDaoFactory {

    private static AdminDao dao;

    private AdminDaoFactory() {

    }

    public static AdminDao getAdminDao() {
        if (dao == null) {
            dao = new AdminDapImpl();
        }
        return dao;
    }


}
