package com.rainmonth.basic;

/**
 * @author randy
 * @date 2021/4/1 2:26 下午
 */
class AdbInterfaceDemo {
    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.fly();
    }
}


/**
 * 功能抽象
 */
abstract class AbsCar {
    // 向普通类一样，可以定义自己才能访问的成员
    private int a;

    // 向普通类一样，可以定义自己才能访问的方法
    private void privateMethod() {

    }

    abstract int wheelNums();
}

class Bird implements DemoInterface {

    @Override
    public void eat() {

    }

    @Override
    public void drink() {

    }
}

/**
 * 规范制定，要实现，就必须实现我定义的规则
 */
interface DemoInterface {
    // 默认静态常量
    int a = 10;
    // 默认静态常量
    static int c = 10;

    // 必须定义常量，不能定义变量
//    int b;
    void eat();

    void drink();

    default void fly() {
        System.out.println("I can fly");
    }
}
