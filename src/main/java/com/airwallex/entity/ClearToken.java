package com.airwallex.entity;

import com.airwallex.Step;
import com.airwallex.exception.CalculatorException;

import java.util.Stack;

public class ClearToken extends Token {
    public ClearToken() {
        super("Operation", "clear");

    }

    @Override
    public void execute(Stack<Token> tokens, Stack<Step> cachedNumbers) throws CalculatorException {
        tokens.clear();
    }
}
