package com.test.filter;

import com.alibaba.fastjson.JSONObject;
import com.test.code.ResultEnum;
import com.test.pojo.Result;
import com.test.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

/**
 * @author LeeShuhang 1142245564@qq.com
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        User user = (User) req.getSession().getAttribute("user");

        if (user == null) {
            HttpServletResponse resp = (HttpServletResponse) response;
            PrintWriter out = resp.getWriter();
            Result result = new Result();
            result.setResult(ResultEnum.USER_NOT_LOGIN_IN);
            out.print(JSONObject.toJSONString(result));
            out.flush();
            out.close();
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
