package com.test.dao.impl;

import com.test.dao.BaseDao;
import com.test.dao.UserDao;
import com.test.pojo.User;
import com.test.util.JdbcUtil;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author LeeShuhang 1142245564@qq.com
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {

    private static final UserDaoImpl USER_DAO;
    static {
        USER_DAO = new UserDaoImpl();
    }

    private static final String LOGIN_SQL = "SELECT `id`,`username`,`password` " +
            "FROM `user` " +
            "WHERE `username` = ? AND `password` = ? " +
            "LIMIT 1;";

    private UserDaoImpl() {
        super(User.class);
    }

    @Override
    public User login(String username, String password) throws SQLException {
        Connection conn = JdbcUtil.getConnection();
        User user = super.selectOne(conn, LOGIN_SQL, username, password);
        JdbcUtil.closeConnection(conn);
        return user;
    }

    public static UserDaoImpl getInstance(){
        return UserDaoImpl.USER_DAO;
    }
}
