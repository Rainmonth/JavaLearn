package com.rainmonth.pattern.behavioral.visitor;

public interface ComputerPart {
    public void accept(ComputerPartVisitor computerPartVisitor);
    public void accept(UserInputVisitor userInputVisitor);
}
