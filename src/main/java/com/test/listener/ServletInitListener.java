package com.test.listener;

import com.test.controller.ServletInterceptor;
import com.test.factory.ServletProxyFactory;
import com.test.pojo.ServletProxyInfo;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Set;

/**
 * @author LeeShuhang 1142245564@qq.com
 */
public class ServletInitListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 获取servlet上下文
        ServletContext context = sce.getServletContext();
        // 初始化ServletProxyFactory
        ServletProxyFactory.init();

        Set<ServletProxyInfo> servletProxyInfos = ServletProxyFactory.getServletProxySet();
        // 向tomcat中注册servlet
        for (ServletProxyInfo servletProxyInfo : servletProxyInfos) {
            context.addServlet(servletProxyInfo.getName(), servletProxyInfo.getServlet())
                    .addMapping(servletProxyInfo.getUrlMapping());
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
