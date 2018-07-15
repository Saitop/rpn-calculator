package com.airwallex.entity;

import com.airwallex.Step;
import com.airwallex.exception.InsufficientParamsException;

import java.util.Arrays;
import java.util.Stack;

import static java.lang.Math.sqrt;

public class SquareRootToken extends Token {
    public SquareRootToken() {
        super("Operation", "sqrt");
    }

    @Override
    public void execute(Stack<Token> tokens, Stack<Step> cachedNumbers) throws InsufficientParamsException {
        if (tokens.size() < 1) {
            throw new InsufficientParamsException();
        }
        final Token firstNumber = tokens.pop();
        final Double result = sqrt(Double.valueOf(firstNumber.getValue()));
        tokens.push(new NumberToken(result.toString()));
        final Step step = new Step(Arrays.asList(firstNumber), this);
        cachedNumbers.push(step);
    }
}
