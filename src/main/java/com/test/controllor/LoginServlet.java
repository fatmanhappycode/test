package com.test.controllor;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.test.pojo.Result;
import com.test.pojo.User;
import com.test.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author 肥宅快乐码
 * @date 2018/10/11 - 22:50
 */
@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应编码
        resp.setContentType("application/json;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        // 读取json
        BufferedReader br = req.getReader();
        String str,str2 = "";
        while((str = br.readLine()) != null){
            str2 += str;
        }

        // 使用gson将json字符串转化成User类
        User user = new Gson().fromJson(str2, User.class);

        String userName = user.getUsername();
        String password = user.getPassword();

        PrintWriter writer = resp.getWriter();

        Result<String> result = new UserService().userLogin(userName,password);
        writer.print(JSONObject.toJSON(result));
    }
}
