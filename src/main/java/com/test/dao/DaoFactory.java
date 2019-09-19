package com.test.dao;

import com.test.dao.impl.UserDaoImpl;

/**
 * @author LeeShuhang 1142245564@qq.com
 */
public class DaoFactory {

    private static final UserDao USER_DAO;

    static {
        USER_DAO = new UserDaoImpl();
    }

    public static UserDao getUserDao(){
        return DaoFactory.USER_DAO;
    }
}
