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
    public void execute(Stack<Token> tokens, Stack<Step> cachedSteps) throws CalculatorException {
        if (tokens.size() < 2) {
            throw new InsufficientParamsException();
        }
        if ("0".equals(tokens.lastElement().getValue())) {
            throw new CalculatorException("Cannot divide by 0.");
        } else {
            final Token divisor = tokens.pop();
            final Token dividend = tokens.pop();
            final Double result = Double.valueOf(dividend.getValue()) / Double.valueOf(divisor.getValue());
            tokens.push(new NumberToken(result.toString()));
            final Step step = new Step(Arrays.asList(dividend, divisor), this);
            cachedSteps.push(step);
        }
    }
}
