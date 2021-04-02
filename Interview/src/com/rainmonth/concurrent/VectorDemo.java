package com.rainmonth.concurrent;

import java.util.Vector;

/**
 * 本实例演示 Vector 不是绝对安全的
 * @author randy
 * @date 2021/4/1 4:12 下午
 */
public class VectorDemo {
    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            Thread removeThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        // 循环删除元素会遇到问题，可采用逆序遍历来解决
                        vector.remove(i);
                    }

//                    for (int i = vector.size() - 1; i >= 0; i--) {
//                        vector.remove(i);
//                    }
                }
            });

            Thread printThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (Integer integer : vector) {
                        System.out.println(integer);
                    }
                }
            });
            removeThread.start();
            printThread.start();

            while (Thread.activeCount() > 20) ;
        }
    }
}
