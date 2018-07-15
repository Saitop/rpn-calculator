package com.airwallex.entity;

import com.airwallex.Step;
import com.airwallex.exception.InsufficientParamsException;

import java.util.Arrays;
import java.util.Stack;

public class AdditionToken extends Token {

    public AdditionToken() {
        super("Operation", "+");
    }

    @Override
    public void execute(Stack<Token> tokens, Stack<Step> cachedSteps) throws InsufficientParamsException {
        if (tokens.size() < 2) {
            throw new InsufficientParamsException();
        }

        final Token addend = tokens.pop();
        final Token augend = tokens.pop();
        final Double sum = Double.valueOf(augend.getValue()) + Double.valueOf(addend.getValue());

        tokens.push(new NumberToken(sum.toString()));
        final Step step = new Step(Arrays.asList(augend, addend), this);
        cachedSteps.push(step);
    }
}
