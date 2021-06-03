package com.rainmonth.pattern.structural.proxy.startDemo;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.*;

import java.lang.reflect.Method;

/**
 * 通过Cglib实现代理
 * @author randy
 * @date 2021/6/1 1:50 下午
 */

class UserDao {

    public UserDao() {
        update();
    }

    public void update() {
        System.out.println("UserDao.update()");
    }

    public void select() {
        System.out.println("UserDao.select()");
    }
}

class UpdateProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("Before method invoke...");
        proxy.invokeSuper(obj, args);
        System.out.println("After method invoke...");
        return obj;
    }
}

class SelectProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("StartTime=[" + System.currentTimeMillis() + "]");
        proxy.invokeSuper(obj, args);
        System.out.println("EndTime=[" + System.currentTimeMillis() + "]");
        return obj;
    }
}

class ProxyCallbackFilter implements CallbackFilter {

    @Override
    public int accept(Method method) {
        if ("select".equals(method.getName())) {
            return 0;// 对应于Enhancer的Callbacks的索引值为0
        }
        return 1;// 对应于Enhancer的Callbacks的索引值为1
    }
}

public class UserDaoDemo  {

    public Object getTarget() {

        SelectProxy selectProxy = new SelectProxy();
        UpdateProxy updateProxy = new UpdateProxy();

        CallbackFilter callbackFilter = new ProxyCallbackFilter();

        Enhancer enhancer = new Enhancer();
        // 设置要代理的类为 UserDao
        enhancer.setSuperclass(UserDao.class);
        // 设置回调（即MethodInterceptor的实现类）
        enhancer.setCallbacks(new Callback[]{selectProxy, updateProxy});
        enhancer.setCallbackFilter(callbackFilter);
        // 设置不代理构造函数里面的方法
        enhancer.setInterceptDuringConstruction(false);
        return enhancer.create();
    }


    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "Interview/target/cglib");
        UserDao helloObj = (UserDao) new UserDaoDemo().getTarget();
        helloObj.update();
        helloObj.select();
    }
}
