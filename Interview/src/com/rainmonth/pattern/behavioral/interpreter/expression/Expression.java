package com.rainmonth.pattern.behavioral.interpreter.expression;

import com.rainmonth.pattern.behavioral.interpreter.InterpreterException;

import java.util.Map;

public interface Expression {
    double interpret(Map<String, Double> context) throws InterpreterException;
}
