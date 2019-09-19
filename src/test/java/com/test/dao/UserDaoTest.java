package com.test.dao;

import com.test.pojo.User;
import org.junit.Test;

import java.io.Serializable;
import java.sql.SQLException;

/**
 * @author LeeShuhang 1142245564@qq.com
 */

public class UserDaoTest {


    @Test
    public void testLogin() throws SQLException {
        UserDao userDao = DaoFactory.getUserDao();
        User user = userDao.login("lsh","123456");
        System.out.println(user);
    }
}
