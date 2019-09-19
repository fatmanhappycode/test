package com.test.service;

import com.test.service.impl.UserServiceImpl;

import java.io.Serializable;

/**
 * @author LeeShuhang 1142245564@qq.com
 */
public class ServiceFactory {

    private static final UserService USER_SERVICE;

    static {
        USER_SERVICE = new UserServiceImpl();
    }

    public static UserService getUserService(){
        return ServiceFactory.USER_SERVICE;
    }
}
