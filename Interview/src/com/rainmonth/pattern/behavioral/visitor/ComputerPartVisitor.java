package com.rainmonth.pattern.behavioral.visitor;

/**
 * 定义访问者接口
 */
public interface ComputerPartVisitor {
    void visit(Computer computer);

    void visit(Mouse mouse);

    void visit(Keyboard keyboard);

    void visit(Monitor monitor);
}