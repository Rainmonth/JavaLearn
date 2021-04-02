package com.rainmonth.basic;

/**
 * @author randy
 * @date 2021/4/1 2:58 下午
 */
public class EqualsDemo {
    public static void main(String[] args) {
        String a = "hello";
        String b = a;

        System.out.println(a == b);
        System.out.println(a.equals(b));
    }
}
