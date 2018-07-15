package com.airwallex.entity;

import com.airwallex.Step;
import com.airwallex.exception.CalculatorException;
import com.airwallex.exception.InsufficientParamsException;

import java.util.Arrays;
import java.util.Stack;

public class DivisionToken extends Token {
    public DivisionToken() {
        super("Operation", "/");
    }

    @Override
    public void execute(Stack<Token> tokens, Stack<Step> cachedNumbers) throws CalculatorException {
        if (tokens.size() < 2) {
            throw new InsufficientParamsException();
        }
        if ("0".equals(tokens.lastElement().getValue())) {
            throw new CalculatorException("Cannot divide by 0.");
        } else {
            final Token secondNumber = tokens.pop();
            final Token firstNumber = tokens.pop();
            final Double result = Double.valueOf(firstNumber.getValue()) / Double.valueOf(secondNumber.getValue());
            tokens.push(new NumberToken(result.toString()));
            final Step step = new Step(Arrays.asList(firstNumber, secondNumber), this);
            cachedNumbers.push(step);
        }
    }
}
