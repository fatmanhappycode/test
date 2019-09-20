package com.test.controller;

import com.test.factory.ServletProxyFactory;
import com.test.pojo.ServletProxyInfo;
import org.junit.Test;

import java.util.Set;

/**
 * @author LeeShuhang 1142245564@qq.com
 */
public class ServletInterceptorTest {

    @Test
    public void test() {
        ServletProxyFactory.init();
        Set<ServletProxyInfo> servletProxyInfos = ServletProxyFactory.getServletProxySet();
        for (ServletProxyInfo servletProxyInfo : servletProxyInfos) {
            System.out.println(servletProxyInfo);
        }
    }
}
