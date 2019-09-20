package com.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.test.annotation.ServletProxyTarget;
import com.test.pojo.Result;
import com.test.factory.ServiceFactory;
import com.test.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 肥宅快乐码
 * @date 2018/10/11 - 22:50
 */
@ServletProxyTarget(name = "loginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = -1446516228185627862L;

    private final UserService userService = ServiceFactory.getUserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        JSONObject requestBody = (JSONObject) req.getAttribute("requestBody");
        Result result = userService.login(requestBody.getString("username"),
                requestBody.getString("password"),
                session);
        req.setAttribute("result", result);
    }
}
