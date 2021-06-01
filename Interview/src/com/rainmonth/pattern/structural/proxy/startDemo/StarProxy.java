package com.rainmonth.pattern.structural.proxy.startDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理
 * @author randy
 * @date 2021/6/1 11:25 上午
 */
public class StarProxy implements InvocationHandler {
    Object obj;

    public StarProxy(Object o) {
        this.obj = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        /*
         * 代理之前：doSomething
         */
        Object result = method.invoke(obj, args);

        /*
         * 代理之后: doSomething
         */
        return result;
    }
}
