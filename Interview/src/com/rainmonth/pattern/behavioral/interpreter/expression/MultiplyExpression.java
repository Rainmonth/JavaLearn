package com.rainmonth.pattern.behavioral.interpreter.expression;

import com.rainmonth.pattern.behavioral.interpreter.InterpreterException;

import java.util.Map;

public class MultiplyExpression implements Expression {

	private final Expression leftExpression; 
	private final Expression rightExpression; 
	
	public MultiplyExpression(Expression leftExpression, Expression rightExpression) {
		this.leftExpression = leftExpression;
		this.rightExpression = rightExpression;
	}

	@Override
	public double interpret(Map<String, Double> context) throws InterpreterException {
		return leftExpression.interpret(context) * rightExpression.interpret(context);
	}
	
	@Override
	public String toString() {
		return String.format("(%s * %s)", leftExpression, rightExpression);
	}

}
