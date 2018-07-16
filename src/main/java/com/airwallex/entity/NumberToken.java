package com.airwallex.entity;

import com.airwallex.Operation;

import java.util.Collections;
import java.util.Stack;

public class NumberToken extends Token {

    public NumberToken(String value) {
        super("Number", value);
    }

    @Override
    public void execute(Stack<Token> input, Stack<Operation> cachedNumbers) {
        final Operation operation = new Operation(Collections.emptyList(), null);
        cachedNumbers.push(operation);
    }
}
