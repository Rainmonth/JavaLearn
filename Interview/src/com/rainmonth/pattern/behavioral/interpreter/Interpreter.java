package com.rainmonth.pattern.behavioral.interpreter;

import java.util.List;

import com.rainmonth.pattern.behavioral.interpreter.expression.Expression;
import com.rainmonth.pattern.behavioral.interpreter.parser.Parser;
import com.rainmonth.pattern.behavioral.interpreter.parser.Token;
import com.rainmonth.pattern.behavioral.interpreter.parser.Tokenizer;

public class Interpreter {
	
	private final List<Token> tokens;
	private final Expression rootExpression;

	public Interpreter(String expressionString) throws InterpreterException {
		tokens = Tokenizer.tokenize(expressionString);
		rootExpression = Parser.parse(tokens);
	}

	public List<Token> getTokens() {
		return tokens;
	}

	public Expression getRootExpression() {
		return rootExpression;
	}

}
