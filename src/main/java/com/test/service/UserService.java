package com.test.service;

import com.test.pojo.Result;

/**
 * @author 肥宅快乐码
 * @date 2018/10/28 - 16:15
 */
public class UserService {
    /**
     * 判断登录成功与否
     * @param userName
     * @param password
     * @return Result<String>
     */
    public Result<String> userLogin(String userName, String password) {
        /*String token = new UserDAO().isLogin(userName, password);
        if (!token.equals("")) {
            if (organization != null && !organization.equals("")) {
                return new ResultDTO<String>(ResultEnum.IS_ORGANIZATION.getCode(), token, ResultEnum.IS_ORGANIZATION.getMsg());
            } else {
                return new Result<String>(ResultEnum.LOGIN_SUCCESS.getCode(), null, ResultEnum.LOGIN_SUCCESS.getMsg());
            }
        } else {
            return new ResultDTO<String>(ResultEnum.LOGIN_ERROR.getCode(), null, ResultEnum.LOGIN_ERROR.getMsg());
        }*/
        return null;
    }
}