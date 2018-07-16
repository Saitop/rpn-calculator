package com.airwallex.entity;

import com.airwallex.Operation;
import com.airwallex.exception.InsufficientParamsException;

import java.util.Collections;
import java.util.Stack;

import static java.lang.Math.sqrt;

public class SquareRootToken extends Token {
    public SquareRootToken() {
        super("Operator", "sqrt");
    }

    @Override
    public void execute(Stack<Token> tokens, Stack<Operation> cachedOperations) throws InsufficientParamsException {
        if (tokens.size() < 1) {
            throw new InsufficientParamsException();
        }

        final Token square = tokens.pop();
        final Double root = sqrt(Double.valueOf(square.getValue()));

        tokens.push(new NumberToken(root.toString()));
        final Operation operation = new Operation(Collections.singletonList(square), this);
        cachedOperations.push(operation);
    }
}
