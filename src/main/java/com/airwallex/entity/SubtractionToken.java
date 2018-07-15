package com.airwallex.entity;

import com.airwallex.Step;

import java.util.Arrays;
import java.util.Stack;

public class SubtractionToken extends Token {
    public SubtractionToken(String value) {
        super("SubtractionToken", value);
    }

    @Override
    public void execute(Stack<Token> tokens, Stack<Step> cachedNumbers, int currentIndex) {
        final Token secondNumber = tokens.pop();
        final Token firstNumber = tokens.pop();
        final Double result = Double.valueOf(firstNumber.getValue()) - Double.valueOf(secondNumber.getValue());
        tokens.push(new NumberToken(result.toString()));
        final Step step = new Step(Arrays.asList(firstNumber, secondNumber), this);
        cachedNumbers.push(step);
    }
}
