package com.rainmonth.pattern.creational.prototype.checkout;

import com.rainmonth.pattern.creational.prototype.simple.AbsPrototype;

/**
 * @author randy
 * @date 2021/7/16 2:40 下午
 */
public class AnotherPrototype implements AbsPrototype {
    private String name = "another";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object clone() {
        return new AnotherPrototype();
    }
}
