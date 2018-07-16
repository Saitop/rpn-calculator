package com.airwallex.entity;

import com.airwallex.Operation;
import com.airwallex.exception.InsufficientParamsException;

import java.util.Arrays;
import java.util.Stack;

public class MultiplicationToken extends Token {

    public MultiplicationToken() {
        super("Operation", "*");
    }

    @Override
    public void execute(Stack<Token> tokens, Stack<Operation> cachedOperations) throws InsufficientParamsException {
        if (tokens.size() < 2) {
            throw new InsufficientParamsException();
        }

        Token multiplicand = tokens.pop();
        Token multiplier = tokens.pop();
        final Double product = Double.valueOf(multiplier.getValue()) * Double.valueOf(multiplicand.getValue());

        tokens.push(new NumberToken(product.toString()));
        final Operation operation = new Operation(Arrays.asList(multiplier, multiplicand), this);
        cachedOperations.push(operation);
    }
}
