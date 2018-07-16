package com.airwallex.entity;

import com.airwallex.Operation;
import com.airwallex.exception.InsufficientParamsException;

import java.util.Arrays;
import java.util.Stack;

public class AdditionToken extends Token {

    public AdditionToken() {
        super("Operation", "+");
    }

    @Override
    public void execute(Stack<Token> tokens, Stack<Operation> cachedOperations) throws InsufficientParamsException {
        if (tokens.size() < 2) {
            throw new InsufficientParamsException();
        }

        final Token addend = tokens.pop();
        final Token augend = tokens.pop();
        final Double sum = Double.valueOf(augend.getValue()) + Double.valueOf(addend.getValue());

        tokens.push(new NumberToken(sum.toString()));
        final Operation operation = new Operation(Arrays.asList(augend, addend), this);
        cachedOperations.push(operation);
    }
}
