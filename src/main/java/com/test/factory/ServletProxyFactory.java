package com.test.factory;

import com.test.annotation.ServletProxyTarget;
import com.test.controller.ServletInterceptor;
import com.test.pojo.ServletProxyInfo;
import net.sf.cglib.proxy.Enhancer;
import org.reflections.Reflections;

import javax.servlet.http.HttpServlet;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author LeeShuhang 1142245564@qq.com
 */
public class ServletProxyFactory {

    private static Set<ServletProxyInfo> servletProxySet;

    public static void init() {
        // 创建cglib组件
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new ServletInterceptor());

        // 获取指定包名下所有带有@Controller注解的类信息
        Reflections reflections = new Reflections("com.test.controller");
        Set<Class<?>> servletTypes = reflections.getTypesAnnotatedWith(ServletProxyTarget.class);

        if (servletTypes.isEmpty()) {
            return;
        }
        servletProxySet = new HashSet<>(servletTypes.size());

        // 为servlet创建代理对象
        for (Class<?> servletType : servletTypes) {
            // 获取controller的注解
            ServletProxyTarget annotation = servletType.getAnnotation(ServletProxyTarget.class);
            // 创建servlet实例
            enhancer.setSuperclass(servletType);
            HttpServlet proxy = (HttpServlet) enhancer.create();
            // 封装controller信息
            ServletProxyInfo servletProxyInfo = new ServletProxyInfo(annotation.name(), annotation.urlPatterns(), proxy);
            ServletProxyFactory.servletProxySet.add(servletProxyInfo);
        }
    }

    public static Set<ServletProxyInfo> getServletProxySet() {
        return servletProxySet;
    }

}
