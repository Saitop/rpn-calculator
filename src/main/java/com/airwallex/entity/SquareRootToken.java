package com.airwallex.entity;

import com.airwallex.Step;

import java.util.Arrays;
import java.util.Stack;

import static java.lang.Math.sqrt;

public class SquareRootToken extends Token {
    public SquareRootToken(String value) {
        super("SquareRootToken", value);
    }

    @Override
    public void execute(Stack<Token> tokens, Stack<Step> cachedNumbers) {
        final Token firstNumber = tokens.pop();
        final Double result = sqrt(Double.valueOf(firstNumber.getValue()));
        tokens.push(new NumberToken(result.toString()));
        final Step step = new Step(Arrays.asList(firstNumber), this);
        cachedNumbers.push(step);
    }
}
