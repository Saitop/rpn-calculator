package com.airwallex.entity;

import com.airwallex.Step;

import java.util.Stack;

public class UndoToken extends Token {

    public UndoToken() {
        super("Operation", "undo");
    }

    @Override
    public void execute(Stack<Token> tokens, Stack<Step> cachedNumbers) {
        tokens.pop();
        final Step step = cachedNumbers.pop();
        tokens.addAll(step.getNumbers());
    }
}
