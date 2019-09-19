package com.test.dao;


import com.test.pojo.User;

import java.sql.SQLException;

/**
 * @author 肥宅快乐码
 */
public interface UserDao {

    /**
     * 验证用户名和密码是否正确
     * @param username 用户名
     * @param password 密码
     * @return 若登录成功返回用户信息
     * @throws SQLException sql异常
     */
    User login(String username, String password) throws SQLException;
}
