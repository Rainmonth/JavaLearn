package com.rainmonth.pattern.creational.prototype.simple;

/**
 * @author randy
 * @date 2021/7/16 2:08 下午
 */
public class RealPrototype implements AbsPrototype {
    private String name = "real";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object clone() {
        return new RealPrototype();
    }
}
