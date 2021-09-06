package com.rainmonth.pattern.behavioral.interpreter.expression;

import com.rainmonth.pattern.behavioral.interpreter.InterpreterException;

import java.util.Map;

/**
 * 定义解释器（表达式）接口
 */
public interface Expression {
    double interpret(Map<String, Double> context) throws InterpreterException;
}
