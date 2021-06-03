package com.rainmonth.pattern.structural.proxy.startDemo;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author randy
 * @date 2021/6/1 10:06 上午
 */
public class StarClient {
    public static void main(String[] args) {
        Star star = new Star();

        System.out.println("采用静态代理实现：");
        StarManager starManager = new StarManager(star);
        // 一个300000的产品代言
        starManager.productProxy(180000);

        // 一个8000的舞蹈表演
        starManager.danceShow(10000);

        // 一个6000的歌曲演唱
        starManager.singShow(6000);

        System.out.println("采用动态代理实现：");
        InvocationHandler handler = new StarProxy(star);

        try {
            IAcceptAnnounce acceptAnnounce = (IAcceptAnnounce) Proxy.newProxyInstance(handler.getClass().getClassLoader(), star.getClass().getInterfaces(), handler);

            acceptAnnounce.productProxy(180000);
            acceptAnnounce.danceShow(10000);
            acceptAnnounce.singShow(6000);
        } catch (Exception e) {
            System.out.println(e);
        }

        writeClassToDisk("Interview/target/Proxy4.class"); // 在项目根目录生成文件
    }

    /**
     * 将动态代理生成的类写入到 path 路径
     */
    public static void writeClassToDisk(String path) {
        byte[] classFile = ProxyGenerator.generateProxyClass("$proxy4", new Class[]{IAcceptAnnounce.class});
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
            fos.write(classFile);
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
