package com.rainmonth.pattern.structural.proxy.startDemo;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 通过Cglib实现代理
 * @author randy
 * @date 2021/6/1 1:50 下午
 */

class HelloObj {
    public String hello() {
        System.out.println("execute hello method!");
        return "hello cglib";
    }
}

public class CglibProxy implements MethodInterceptor {

    public Object getTarget() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloObj.class);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        return proxy.invokeSuper(obj, args);
    }

    public static void main(String[] args) {
        HelloObj helloObj = (HelloObj) new CglibProxy().getTarget();
        System.out.println(helloObj.hello());
    }
}
