package com.rainmonth.pattern.creational.singleton;

/**
 * @author Randy Zhang
 */
public class AccountClient {
    public static void main(String[] args) {
        ATM atmKH = new ATM();
        atmKH.deposit(3000);

        ATM atmTP = new ATM();
        atmTP.withdraw(5000);

        // TODO: 2017/3/20 模拟出线程不安全的情况

        // TODO: 2017/3/20 利用反射机制来创建出单例类的对象
    }
}
