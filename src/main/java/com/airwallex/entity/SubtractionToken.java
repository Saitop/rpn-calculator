package com.airwallex.entity;

import com.airwallex.Step;
import com.airwallex.exception.InsufficientParamsException;

import java.util.Arrays;
import java.util.Stack;

public class SubtractionToken extends Token {
    public SubtractionToken() {
        super("Operation", "-");
    }

    @Override
    public void execute(Stack<Token> tokens, Stack<Step> cachedSteps) throws InsufficientParamsException {
        if (tokens.size() < 2) {
            throw new InsufficientParamsException();
        }

        final Token subtrahend = tokens.pop();
        final Token minuend = tokens.pop();
        final Double difference = Double.valueOf(minuend.getValue()) - Double.valueOf(subtrahend.getValue());

        tokens.push(new NumberToken(difference.toString()));
        final Step step = new Step(Arrays.asList(minuend, subtrahend), this);
        cachedSteps.push(step);
    }
}
