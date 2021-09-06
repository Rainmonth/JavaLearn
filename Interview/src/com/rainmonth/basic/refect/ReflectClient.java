package com.rainmonth.basic.refect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author RandyZhang
 * @date 2021/9/3 3:15 下午
 */
public class ReflectClient {
    public static void main(String[] args) {
//        ReflectObject reflectObject = new ReflectObject("Randy", 608);

//        ReflectObject reflectObject = ReflectUtils.newInstance(ReflectObject.class);
        Constructor<ReflectObject> constructor = ReflectUtils.getConstructor(ReflectObject.class, String.class, long.class);
        if (constructor == null) {
            return;
        }
        ReflectObject reflectObject = null;
        try {
            reflectObject = constructor.newInstance("Randy2", 1000);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        if (reflectObject == null) {
            System.out.println("reflectObject is null");
            return;
        }
        System.out.println("ReflectObject Fields(includeSuper=false):" + ReflectUtils.listObjFields(reflectObject));
        System.out.println("ReflectObject Fields(includeSuper=true):" + ReflectUtils.listObjFields(reflectObject, true));
        System.out.println("ReflectObject Fields(includeSuper=true):" + ReflectUtils.listObjFields(ReflectObject.class, true));

        Method setNameAndId = ReflectUtils.getMethodByNameAndArgs(reflectObject.getClass(), "setNameAndId",
                String.class, long.class);

        Method setIdAndName = ReflectUtils.getDeclaredMethod(reflectObject.getClass(), "setIdAndName", long.class, String.class);

        Method print = ReflectUtils.getDeclaredMethod(reflectObject.getClass(), "print");
        Method testReflect = ReflectUtils.getDeclaredMethod(reflectObject.getClass(), "testReflect");

        System.out.println(setNameAndId);
        System.out.println(setIdAndName);
        System.out.println(print);
        System.out.println(testReflect);

        try {
            setNameAndId.invoke(reflectObject, "Randy", 1L);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(reflectObject);

        reflectObject.setId(100);
        reflectObject.setName("RandySet");
        System.out.println(reflectObject);

        ReflectObject reflectObject1 = ReflectUtils.invokeConstructor(ReflectObject.class, null, String.class, long.class);
        System.out.println(reflectObject1);

        Object[] param = new Object[]{"lisi", 10};
        ReflectObject reflectObject2 = ReflectUtils.invokeConstructor(ReflectObject.class, param, String.class, long.class);
        System.out.println(reflectObject2);
    }

}
