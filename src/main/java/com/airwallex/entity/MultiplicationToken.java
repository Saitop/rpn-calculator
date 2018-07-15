package com.airwallex.entity;

import com.airwallex.Step;
import com.airwallex.exception.InsufficientParamsException;

import java.util.Arrays;
import java.util.Stack;

public class MultiplicationToken extends Token {

    public MultiplicationToken() {
        super("Operation", "*");
    }

    @Override
    public void execute(Stack<Token> tokens, Stack<Step> cachedSteps) throws InsufficientParamsException {
        if (tokens.size() < 2) {
            throw new InsufficientParamsException();
        }
        Token multiplicand = tokens.pop();
        Token multiplier = tokens.pop();
        final Double result = Double.valueOf(multiplier.getValue()) * Double.valueOf(multiplicand.getValue());
        tokens.push(new NumberToken(result.toString()));
        final Step step = new Step(Arrays.asList(multiplier, multiplicand), this);
        cachedSteps.push(step);
    }
}
