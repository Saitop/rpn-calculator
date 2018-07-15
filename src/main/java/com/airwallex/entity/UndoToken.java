package com.airwallex.entity;

import com.airwallex.Step;

import java.util.Stack;

public class UndoToken extends Token {

    public UndoToken(String value) {
        super("UndoToken", value);
    }

    @Override
    public void execute(Stack<Token> tokens, Stack<Step> cachedNumbers, int currentIndex) {
        tokens.pop();
        final Step step = cachedNumbers.pop();
        tokens.addAll(step.getNumbers());
    }
}
