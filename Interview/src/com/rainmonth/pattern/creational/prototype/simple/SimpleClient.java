package com.rainmonth.pattern.creational.prototype.simple;

/**
 * @author randy
 * @date 2021/7/16 2:09 下午
 */
public class SimpleClient {
    private final AbsPrototype prototype;

    public SimpleClient(AbsPrototype prototype) {
        this.prototype = prototype;
    }

    public AbsPrototype makePrototype() {
        return (AbsPrototype) prototype.clone();
    }

    public static void main(String[] args) {
        RealPrototype realPrototype = new RealPrototype();

        SimpleClient client = new SimpleClient(realPrototype);
        RealPrototype copy = (RealPrototype) client.makePrototype();
        copy.setName("copyOne");
        System.out.println(realPrototype.getName());
        System.out.println(copy.getName());

    }
}
