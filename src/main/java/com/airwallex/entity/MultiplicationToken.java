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
        Token secondNumber = tokens.pop();
        Token firstNumber = tokens.pop();

        final Double result = Double.valueOf(firstNumber.getValue()) * Double.valueOf(secondNumber.getValue());
        tokens.push(new NumberToken(result.toString()));
        final Step step = new Step(Arrays.asList(firstNumber, secondNumber), this);
        cachedSteps.push(step);
    }
}
