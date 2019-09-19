package com.test.dao;

import com.test.dao.impl.BookDaoImpl;
import com.test.dao.impl.UserDaoImpl;

/**
 * @author LeeShuhang 1142245564@qq.com
 */
public class DaoFactory {

    private static final UserDao USER_DAO;

    private static final BookDao BOOK_DAO;

    static {
        USER_DAO = new UserDaoImpl();
        BOOK_DAO = new BookDaoImpl();
    }

    public static UserDao getUserDao(){
        return DaoFactory.USER_DAO;
    }

    public static BookDao getBookDao(){
        return DaoFactory.BOOK_DAO;
    }
}
