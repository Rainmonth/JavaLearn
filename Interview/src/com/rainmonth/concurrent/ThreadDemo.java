package com.rainmonth.concurrent;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 1. 如何让两个线程依次执行（join的使用）
 * 2. 如何让两个线程按照指定方式有序交叉执行（锁的使用，Object.wait()、Object.notify()）
 * 3. 四个线程A、B、C、D，其中D要等到A B C全部执行完成后才能执行，而且A B C 是同步运行的（CountDownLatch的使用）
 * 4. 三个运动员各自准备，等到三个人都准备好了，再一起跑（CyclicBarrier的使用）
 * 5. 子线程完成某个任务后，把得到的结果回传给主线程（Callable、FutureTask的使用）
 * @author randy
 * @date 2021/8/28 11:21 上午
 */
public class ThreadDemo {
    public static void main(String[] args) {
        // 一般线程处理
//        demo0();
        // 问题1
//        demo1();
        // 问题2
//        demo2();
        // 问题3
//        demo3RunDAfterAbc();
        // 问题4
//        demo4RunAbcAfterAllReady();
        // 问题4
        demo5GetRunResult();
    }

    public static void demo0() {
        System.out.println("======普通线程示例======");
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                printNumber("a");
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                printNumber("b");
            }
        });
        a.start();
        b.start();
    }

    public static void demo1() {
        System.out.println("======两个线程依次执行======");
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                printNumber("a");
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("b 开始等待 a");
                try {
                    a.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                printNumber("b");
            }
        });
        a.start();
        b.start();
    }

    public static void demo2() {
        System.out.println("======两个线程交替有序执行======");
        Object lock = new Object();
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
//                printNumber("a");
                synchronized (lock) {
                    System.out.println("A 1");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("A 2");
                    System.out.println("A 3");
                }
                System.out.println();
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("B 1");
                    System.out.println("B 2");
                    System.out.println("B 3");
                    lock.notify();
                }
            }
        });
        a.start();
        b.start();
    }

    public static void demo3RunDAfterAbc() {
        int worker = 3;
        CountDownLatch countDownLatch = new CountDownLatch(worker);
        Thread d = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("d is waiting for other three threads");
                try {
                    countDownLatch.await();
                    System.out.println("all done, D starts working");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        d.start();
        for (char threadName = 'A'; threadName <= 'C'; threadName++) {
            final String tn = String.valueOf(threadName);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(tn + " is working...");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(tn + " is finish");
                    countDownLatch.countDown();
                }
            }).start();
        }
    }


    /**
     * A B C三个线程都准备好后，再同时运行
     */
    public static void demo4RunAbcAfterAllReady() {
        int worker = 3;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(worker);
        final Random random = new Random();
        for (char threadName = 'A'; threadName <= 'C'; threadName++) {
            final String tn = String.valueOf(threadName);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    long prepareTime = random.nextInt(10000) + 100;
                    System.out.println(tn + " is preparing  for time:" + prepareTime);
                    try {
                        Thread.sleep(prepareTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        System.out.println(tn + " is prepared， waiting for others");
                        cyclicBarrier.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println(tn + " start running...");
                }
            }).start();
        }
    }

    public static void demo5GetRunResult() {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("task starts...");
                Thread.sleep(1000);
                int result = 0;
                for (int i = 0; i <= 100; i++) {
                    result += i;
                }
                System.out.println("task finished and return result");
                return result;
            }
        };

        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();
        try {
            System.out.println("Before futureTask.get()");
            System.out.println("Result: " + futureTask.get());
            System.out.println("Aster futureTask.get()");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void printNumber(String threadName) {
        int i = 0;
        while (i++ < 3) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + " print: " + i);
        }
    }
}
