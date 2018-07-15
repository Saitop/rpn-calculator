package com.airwallex.entity;

import com.airwallex.Step;

import java.util.Stack;

public class UndoToken extends Token {

    public UndoToken() {
        super("Operation", "undo");
    }

    @Override
    public void execute(Stack<Token> tokens, Stack<Step> cachedSteps) {
        tokens.pop();
        final Step step = cachedSteps.pop();
        tokens.addAll(step.getNumbers());
    }
}
