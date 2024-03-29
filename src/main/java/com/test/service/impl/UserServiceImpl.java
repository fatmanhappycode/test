package com.test.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.test.code.ResultEnum;
import com.test.dao.DaoFactory;
import com.test.dao.UserDao;
import com.test.pojo.Result;
import com.test.pojo.User;
import com.test.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * @author LeeShuhang 1142245564@qq.com
 */
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private UserDao userDao = DaoFactory.getUserDao();

    private static final UserServiceImpl USER_SERVICE;

    static {
        USER_SERVICE = new UserServiceImpl();
    }

    private UserServiceImpl(){

    }

    @Override
    public Result<Boolean> login(String username, String password, HttpSession session) {
        Result<Boolean> result = new Result<>();
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            // 用户名或密码为空，直接返回错误信息
            return result.setResult(ResultEnum.USERNAME_PASSWORD_EMPTY);
        }
        User user = null;
        try {
            user = userDao.login(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user == null) {
            return result.setResult(ResultEnum.LOGIN_PASSWORD_ERROR);
        }

        session.setAttribute("user", user);
        logger.info("用户{}登录成功！", username);
        return result.setResult(ResultEnum.LOGIN_SUCCESS);
    }

    public static UserServiceImpl getInstance(){
        return USER_SERVICE;
    }
}
