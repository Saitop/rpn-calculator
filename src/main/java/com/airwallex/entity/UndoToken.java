package com.airwallex.entity;

import com.airwallex.Operation;
import com.airwallex.exception.CalculatorException;

import java.util.Stack;

public class UndoToken extends Token {

    public UndoToken() {
        super("Operator", "undo");
    }

    @Override
    public void execute(Stack<Token> tokens, Stack<Operation> cachedOperations) throws CalculatorException {
        if (tokens.size() < 1) {
            throw new CalculatorException("Stack is empty, please do not perform 'undo'");
        }
        tokens.pop();
        if(!cachedOperations.isEmpty()){
            final Operation operation = cachedOperations.pop();
            tokens.addAll(operation.getNumbers());
        }
    }
}
