package com.rainmonth.pattern.behavioral.interpreter.expression;

import com.rainmonth.pattern.behavioral.interpreter.InterpreterException;

import java.util.Map;

public class VariableExpression implements Expression {

	private final String name;

	public VariableExpression(String name) {
		this.name = name;
	}

	@Override
	public double interpret(Map<String, Double> context) throws InterpreterException {
		if (context.containsKey(name)) {
			return context.get(name);
		} else {
			throw new InterpreterException("Variable not found: " + name);
		}
	}
	
	@Override
	public String toString() {
		return name;
	}

}
