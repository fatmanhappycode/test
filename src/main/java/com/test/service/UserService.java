package com.test.service;


import com.test.pojo.Result;

import javax.servlet.http.HttpSession;

/**
 * @author 肥宅快乐码
 */
public interface UserService {

    /**
     * 登录业务，失败返回错误信息，成功则将用户信息保存到session
     * @param username 用户名
     * @param password 密码
     * @param session HttpSession
     * @return
     */
    Result<Boolean> login(String username, String password, HttpSession session);
}