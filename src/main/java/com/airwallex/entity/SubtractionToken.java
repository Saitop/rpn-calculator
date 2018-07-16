package com.airwallex.entity;

import com.airwallex.Operation;
import com.airwallex.exception.InsufficientParamsException;

import java.util.Arrays;
import java.util.Stack;

public class SubtractionToken extends Token {
    public SubtractionToken() {
        super("Operator", "-");
    }

    @Override
    public void execute(Stack<Token> tokens, Stack<Operation> cachedOperations) throws InsufficientParamsException {
        if (tokens.size() < 2) {
            throw new InsufficientParamsException();
        }

        final Token subtrahend = tokens.pop();
        final Token minuend = tokens.pop();
        final Double difference = Double.valueOf(minuend.getValue()) - Double.valueOf(subtrahend.getValue());

        tokens.push(new NumberToken(difference.toString()));
        final Operation operation = new Operation(Arrays.asList(minuend, subtrahend), this);
        cachedOperations.push(operation);
    }
}
