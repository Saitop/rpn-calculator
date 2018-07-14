package com.airwallex.entity;

import java.util.Stack;

public class MultiplicationToken extends Token {

    public MultiplicationToken(String value) {
        super("MultiplicationToken", value);
    }

    @Override
    public void execute(Stack<Token> tokens) {
        final Token secondNumber = tokens.pop();
        final Token firstNumber = tokens.pop();
        final Double result = Double.valueOf(firstNumber.getValue()) * Double.valueOf(secondNumber.getValue());
        tokens.push(new NumberToken(result.toString()));
    }
}
