package com.airwallex.entity;

import java.util.Stack;

import static java.lang.Math.sqrt;

public class SquareRootToken extends Token {
    public SquareRootToken(String value) {
        super("SquareRootToken", value);
    }

    @Override
    public void execute(Stack<Token> tokens) {
        final Token firstNumber = tokens.pop();
        final Double result = sqrt(Double.valueOf(firstNumber.getValue()));
        tokens.push(new NumberToken(result.toString()));
    }
}
