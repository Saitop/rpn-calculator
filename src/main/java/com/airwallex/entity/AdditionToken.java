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
    public void execute(Stack<Token> tokens, Stack<Step> cachedNumbers) throws InsufficientParamsException {
        if (tokens.size() < 2) {
            throw new InsufficientParamsException();
        }
        final Token secondNumber = tokens.pop();
        final Token firstNumber = tokens.pop();
        final Double result = Double.valueOf(firstNumber.getValue()) + Double.valueOf(secondNumber.getValue());
        tokens.push(new NumberToken(result.toString()));
        final Step step = new Step(Arrays.asList(firstNumber, secondNumber), this);
        cachedNumbers.push(step);
    }
}
