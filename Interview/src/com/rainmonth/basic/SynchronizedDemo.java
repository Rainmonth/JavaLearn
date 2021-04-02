package com.rainmonth.basic;

/**
 * 本例用于 synchronized 原理
 * @author randy
 * @date 2021/4/1 3:32 下午
 */
public class SynchronizedDemo {

    public static void main(String[] args) {
        String s = "Hello word!";

        System.out.println("s:" + s);
        System.out.println("s.replace:" + s.replace("H","M"));
        System.out.println("s:" + s);
    }
}
