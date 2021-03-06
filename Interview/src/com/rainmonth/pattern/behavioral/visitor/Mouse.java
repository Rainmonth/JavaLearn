package com.rainmonth.pattern.behavioral.visitor;

/**
 * 鼠标
 */
public class Mouse implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }

    @Override
    public void accept(UserInputVisitor userInputVisitor) {
        userInputVisitor.visit(this);
    }
}
