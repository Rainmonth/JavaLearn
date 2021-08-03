package com.rainmonth.pattern.behavioral.visitor;

/**
 * 定义元素接口
 */
public interface ComputerPart {
    void accept(ComputerPartVisitor computerPartVisitor);

    void accept(UserInputVisitor userInputVisitor);
}
