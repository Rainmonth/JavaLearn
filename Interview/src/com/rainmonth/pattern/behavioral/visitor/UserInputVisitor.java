package com.rainmonth.pattern.behavioral.visitor;

/**
 * 输入设备访问者
 */
public class UserInputVisitor implements ComputerPartVisitor {

    @Override
    public void visit(Computer computer) {}

    @Override
    public void visit(Mouse mouse) {
        System.out.println("Displaying Mouse.");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("Displaying Keyboard.");
    }

    @Override
    public void visit(Monitor monitor) {}
}