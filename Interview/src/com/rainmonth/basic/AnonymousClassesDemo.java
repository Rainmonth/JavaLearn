package com.rainmonth.basic;

/**
 * @author randy
 * @date 2021/8/23 2:24 下午
 */
public class AnonymousClassesDemo {
    public static void main(String[] args) {
        String xx = "haha";
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(xx);
            }
        }).start();
    }


}
