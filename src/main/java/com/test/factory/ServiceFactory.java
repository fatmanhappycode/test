package com.test.factory;

import com.test.service.BookService;
import com.test.service.UserService;
import com.test.service.impl.BookServiceImpl;
import com.test.service.impl.UserServiceImpl;

/**
 * @author LeeShuhang 1142245564@qq.com
 */
public class ServiceFactory {

    private static final UserService USER_SERVICE;

    private static final BookService BOOK_SERVICE;

    static {
        USER_SERVICE = UserServiceImpl.getInstance();
        BOOK_SERVICE = BookServiceImpl.getInstance();
    }

    public static UserService getUserService(){
        return ServiceFactory.USER_SERVICE;
    }

    public static BookService getBookService(){
        return ServiceFactory.BOOK_SERVICE;
    }
}
