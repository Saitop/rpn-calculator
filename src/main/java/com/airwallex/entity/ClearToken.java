package com.airwallex.entity;

import com.airwallex.Operation;
import com.airwallex.exception.CalculatorException;

import java.util.Stack;

public class ClearToken extends Token {
    public ClearToken() {
        super("Operator", "clear");

    }

    @Override
    public void execute(Stack<Token> tokens, Stack<Operation> cachedOperations) throws CalculatorException {
        tokens.clear();
        cachedOperations.clear();
    }
}
