package com.airwallex.entity;

import java.util.Stack;

public class SubtractionToken extends Token {
    public SubtractionToken(String value) {
        super("SubtractionToken", value);
    }

    @Override
    public void execute(Stack<Token> tokens) {
        final Token secondNumber = tokens.pop();
        final Token firstNumber = tokens.pop();
        final Double result = Double.valueOf(firstNumber.getValue()) - Double.valueOf(secondNumber.getValue());
        tokens.push(new NumberToken(result.toString()));
    }
}
