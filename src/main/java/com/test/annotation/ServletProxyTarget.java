package com.test.annotation;

import java.lang.annotation.*;

/**
 * @author LeeShuhang
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServletProxyTarget {

    /**
     * The name of the servlet
     */
    String name();

    /**
     * The URL patterns of the servlet
     */
    String[] urlPatterns();
}
