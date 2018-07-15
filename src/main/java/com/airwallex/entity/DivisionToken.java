package com.airwallex.entity;

import com.airwallex.Step;
import com.airwallex.exception.CalculatorException;

import java.util.Arrays;
import java.util.Stack;

public class DivisionToken extends Token {
    public DivisionToken(String value) {
        super("DivisionToken", value);
    }

    @Override
    public void execute(Stack<Token> tokens, Stack<Step> cachedNumbers, int currentIndex) throws CalculatorException {
        if (tokens.size() < 2) {
            throw new CalculatorException(
                    String.format("operator %s (position: %d): insufficient parameters", this.getValue(), currentIndex));
        }
        final Token secondNumber = tokens.pop();
        final Token firstNumber = tokens.pop();
        if ("0".equals(secondNumber.getValue())) {
            throw new CalculatorException("Cannot divide by 0.");
        }
        final Double result = Double.valueOf(firstNumber.getValue()) / Double.valueOf(secondNumber.getValue());
        tokens.push(new NumberToken(result.toString()));
        final Step step = new Step(Arrays.asList(firstNumber, secondNumber), this);
        cachedNumbers.push(step);
    }
}
