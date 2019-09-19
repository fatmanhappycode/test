package com.test.dao;

import com.test.dao.impl.BookDaoImpl;
import com.test.dao.impl.UserDaoImpl;

/**
 * @author LeeShuhang 1142245564@qq.com
 */
public class DaoFactory {

    private static UserDao USER_DAO;

    private static BookDao BOOK_DAO;


    public static UserDao getUserDao(){
        if (USER_DAO == null){
            USER_DAO = UserDaoImpl.getInstance();
        }
        return DaoFactory.USER_DAO;
    }

    public static BookDao getBookDao(){
        if (BOOK_DAO == null){
            BOOK_DAO = BookDaoImpl.getInstance();
        }
        return DaoFactory.BOOK_DAO;
    }
}
