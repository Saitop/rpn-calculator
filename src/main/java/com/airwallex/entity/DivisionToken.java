package com.airwallex.entity;

import com.airwallex.Operation;
import com.airwallex.exception.CalculatorException;
import com.airwallex.exception.InsufficientParamsException;

import java.util.Arrays;
import java.util.Stack;

public class DivisionToken extends Token {
    public DivisionToken() {
        super("Operator", "/");
    }

    @Override
    public void execute(Stack<Token> tokens, Stack<Operation> cachedOperations) throws CalculatorException {
        if (tokens.size() < 2) {
            throw new InsufficientParamsException();
        }
        if ("0".equals(tokens.lastElement().getValue())) {
            throw new CalculatorException("Cannot divide by 0.");
        } else {

            final Token divisor = tokens.pop();
            final Token dividend = tokens.pop();
            final Double quotient = Double.valueOf(dividend.getValue()) / Double.valueOf(divisor.getValue());

            tokens.push(new NumberToken(quotient.toString()));
            final Operation operation = new Operation(Arrays.asList(dividend, divisor), this);
            cachedOperations.push(operation);
        }
    }
}
