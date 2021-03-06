package com.rainmonth.pattern.behavioral.interpreter;

import java.util.List;

import com.rainmonth.pattern.behavioral.interpreter.expression.Expression;
import com.rainmonth.pattern.behavioral.interpreter.parser.Parser;
import com.rainmonth.pattern.behavioral.interpreter.parser.Token;
import com.rainmonth.pattern.behavioral.interpreter.parser.Tokenizer;

/**
 * 解释器中心，客户端通过该类进行输入文本的解释，不需要关心具体解释器的实现（类似于中介者）
 */
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
