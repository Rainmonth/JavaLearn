package com.rainmonth.pattern.behavioral.visitor;

/**
 * 电脑（结构固定的元素对象）
 */
public class Computer implements ComputerPart {

    ComputerPart[] parts;

    public Computer(){
        parts = new ComputerPart[] {new Mouse(), new Keyboard(), new Monitor()};
    }

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        for (int i = 0; i < parts.length; i++) {
            parts[i].accept(computerPartVisitor);
        }
        computerPartVisitor.visit(this);
    }

    @Override
    public void accept(UserInputVisitor userInputVisitor) {
        for (int i = 0; i < parts.length; i++) {
            parts[i].accept(userInputVisitor);
        }
        userInputVisitor.visit(this);
    }
}