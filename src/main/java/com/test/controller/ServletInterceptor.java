package com.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.test.pojo.Result;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * @author LeeShuhang 1142245564@qq.com
 */
public class ServletInterceptor implements MethodInterceptor {


    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        // 先执行servlet的方法
        Object methodResult = proxy.invokeSuper(obj, args);

        HttpServletRequest request = null;
        HttpServletResponse response = null;
        if (args != null && args.length == 2) {
            if (args[0] instanceof HttpServletRequest) {
                request = (HttpServletRequest) args[0];
            }
            if (args[1] instanceof HttpServletResponse) {
                response = (HttpServletResponse) args[1];
            }
        }
        if (request != null && response != null) {
            Result result = (Result) request.getAttribute("result");
            PrintWriter out = response.getWriter();
            if (result != null) {
                out.write(JSONObject.toJSONString(result));
                out.flush();
                out.close();
            }
        }
        return methodResult;
    }


}
