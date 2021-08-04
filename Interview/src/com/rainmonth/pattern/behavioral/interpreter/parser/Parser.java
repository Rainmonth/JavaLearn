package com.rainmonth.pattern.behavioral.interpreter.parser;

import java.util.List;

import com.rainmonth.pattern.behavioral.interpreter.InterpreterException;
import com.rainmonth.pattern.behavioral.interpreter.expression.*;
import com.rainmonth.pattern.behavioral.interpreter.parser.Token.TokenType;

/**
 * 定义词法解析器，根据规则将输入的Tokens转化成待解释的表达式
 */
public class Parser {
    private final List<Token> tokens;
    int next = 0;

    public static Expression parse(List<Token> tokens) throws InterpreterException {
        return new Parser(tokens).parse();
    }

    private Parser(List<Token> tokens) {
        this.tokens = tokens;
    }

    private Expression parse() throws InterpreterException {
        next = 0;
        Expression expression = expression();
        except(TokenType.EPSILON);
        return expression;
    }

    private Expression expression() throws InterpreterException {
        Expression expression = term();// 先乘法
        while (accept(TokenType.ADD)) {// 在加法
            expression = new AddExpression(expression, term());
        }
        return expression;

    }

    private Expression term() throws InterpreterException {
        Expression expression = factor();
        while (accept(TokenType.MULTIPLY)) {
            expression = new MultiplyExpression(expression, term());
        }
        return expression;
    }

    /**
     * 获取 常量或变量表达式
     * @return 常量或变量表达式
     * @throws InterpreterException 不是商量两种类型就抛异常
     */
    private Expression factor() throws InterpreterException {
        if (accept(TokenType.NUMBER)) {
            return new NumberExpression(current().getAsNumber());
        }
        except(TokenType.VARIABLE);
        return new VariableExpression(current().getString());
    }

    /**
     * 获取指定类型Token
     * @param tokenType 获取的token类型
     * @return 如果是期待的类型，返回true，同时更新next指针；不是则返回false；
     */
    private boolean accept(TokenType tokenType) {
        if (tokens.get(next).getType() == tokenType) {
            ++next;
            return true;
        } else {
            return false;
        }
    }

    /**
     * 需要的类型
     * @param tokenType 期待的类型
     * @throws InterpreterException 不是期待的token类型则抛出异常
     */
    private void except(TokenType tokenType) throws InterpreterException {
        if (!accept(tokenType)) {
            throw new InterpreterException(
                    "Parser error. Unexcepted token at: \""
                            + getRemainingString() + "\"");
        }
    }

    /**
     * 当前处理的token
     * @return 当前处理的token
     */
    private Token current() {
        return tokens.get(next - 1);
    }

    private String getRemainingString() {
        StringBuffer buffer = new StringBuffer();
        for (int i = next; i < tokens.size(); ++i) {
            if (i != next)
                buffer.append(" ");
            buffer.append(tokens.get(i).getString());
        }
        return buffer.toString();
    }

}
