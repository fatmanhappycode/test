package com.test.dao;

import com.test.dao.impl.BookDaoImpl;
import com.test.dao.impl.UserDaoImpl;

/**
 * @author LeeShuhang 1142245564@qq.com
 */
public class DaoFactory {

    private static UserDao USER_DAO;

    private static BookDao BOOK_DAO;

    static {
        USER_DAO = UserDaoImpl.getInstance();
        BOOK_DAO = BookDaoImpl.getInstance();
    }

    public static UserDao getUserDao() {
        return DaoFactory.USER_DAO;
    }

    public static BookDao getBookDao() {
        return DaoFactory.BOOK_DAO;
    }
}
