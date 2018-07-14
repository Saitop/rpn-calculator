package com.airwallex.entity;

import com.airwallex.exception.CalculatorException;

import java.util.Stack;

public class ClearToken extends Token {
    public ClearToken(String value) {
        super("ClearToken", value);
    }

    @Override
    public void execute(Stack<Token> tokens) throws CalculatorException {
        tokens.clear();
    }
}