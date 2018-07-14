package com.airwallex.entity;

import java.util.Stack;

public class NumberToken extends Token {

    @Override
    public void execute(Stack<Token> input) {
    }

    public NumberToken(String value) {
        super("NumberToken", value);
    }
}
