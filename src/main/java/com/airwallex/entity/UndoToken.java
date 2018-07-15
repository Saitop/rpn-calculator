package com.airwallex.entity;

import com.airwallex.Step;
import com.airwallex.exception.CalculatorException;

import java.util.Stack;

public class UndoToken extends Token {

    public UndoToken() {
        super("Operation", "undo");
    }

    @Override
    public void execute(Stack<Token> tokens, Stack<Step> cachedSteps) throws CalculatorException {
        if (tokens.size() < 1) {
            throw new CalculatorException("Stack is empty, please do not perform 'undo'");
        }
        tokens.pop();
        if(!cachedSteps.isEmpty()){
            final Step step = cachedSteps.pop();
            tokens.addAll(step.getNumbers());
        }
    }
}
