package com.airwallex.entity;

import com.airwallex.Step;
import com.airwallex.exception.InsufficientParamsException;

import java.util.Collections;
import java.util.Stack;

import static java.lang.Math.sqrt;

public class SquareRootToken extends Token {
    public SquareRootToken() {
        super("Operation", "sqrt");
    }

    @Override
    public void execute(Stack<Token> tokens, Stack<Step> cachedSteps) throws InsufficientParamsException {
        if (tokens.size() < 1) {
            throw new InsufficientParamsException();
        }

        final Token square = tokens.pop();
        final Double root = sqrt(Double.valueOf(square.getValue()));

        tokens.push(new NumberToken(root.toString()));
        final Step step = new Step(Collections.singletonList(square), this);
        cachedSteps.push(step);
    }
}
