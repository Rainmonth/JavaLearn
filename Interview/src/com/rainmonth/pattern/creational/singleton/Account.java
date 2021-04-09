package com.rainmonth.pattern.creational.singleton;

/**
 * 单例模式代码实例
 * Created by RandyZhang on 2017/3/20.
 */
public class Account {
    private static Account account = null;
    /**
     * 饿汉式
     */
//    private static Account account = new Account();

    // 账户余额
    private double money = 6000D;

    /**
     * 懒汉式（非线程安全）
     *
     * @return Account
     */
    public static Account getInstance1() {
        if (null == account) {
            account = new Account();
        }
        return account;
    }

    /**
     * 懒汉式（线程安全）
     *
     * @return Account
     */
    public static synchronized Account getInstance2() {
        if (null == account) {
            account = new Account();
        }
        return account;
    }

    /**
     * 懒汉式 双重检查锁 （线程安全）
     *
     * @return Account
     */
    public static Account getInstance3() {
        if (null == account) {
            synchronized (Account.class) {
                if (null == account) {
                    account = new Account();
                }
            }
        }
        return account;
    }

    /**
     * 懒汉式（变种）双重检查锁（变种） （线程安全）
     *
     * @return Account
     */
    public static Account getInstance4() {
        if (null == account) {
            syncInit();
        }
        return account;
    }

    private static synchronized void syncInit() {
        if (null == account) {
            account = new Account();
        }
    }

    /**
     * 静态内部类 线程安全
     *
     * @return Account
     */
    public static Account getInstance5() {
        return AccountHolder.instance;
    }

    /**
     * 单元素枚举 线程安全，支持序列化
     *
     * @return Account
     */
    public static Account getInstance6() {
        return AccountEnum.INSTANCE.getInstance();
    }

    private Account() {

    }

    /**
     * 存款
     *
     * @param depositMoney 存款金额
     */
    public void deposit(double depositMoney) {
        money += depositMoney;
        System.out.println("deposit " + depositMoney + ", Account balance is " + money);
    }

    /**
     * 提现
     *
     * @param withdrawMoney 提现金额
     */
    public void withdraw(double withdrawMoney) {
        money -= withdrawMoney;
        System.out.println("withdraw " + withdrawMoney + ", Account balance is " + money);
    }

    /**
     * 静态内部类实现单例模式
     */
    private static class AccountHolder {
        private static final Account instance = new Account();
    }

    /**
     * 单元素枚举实现单例模式
     */
    public enum AccountEnum {
        INSTANCE;
        private Account instance;

        AccountEnum() {
            instance = new Account();
        }

        public Account getInstance() {
            return instance;
        }
    }
}
