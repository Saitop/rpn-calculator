package com.airwallex.entity;

import com.airwallex.Step;

import java.util.Collections;
import java.util.Stack;

public class NumberToken extends Token {

    @Override
    public void execute(Stack<Token> input, Stack<Step> cachedNumbers, int currentIndex) {
        final Step step = new Step(Collections.emptyList(), null);
        cachedNumbers.push(step);
    }

    public NumberToken(String value) {
        super("NumberToken", value);
    }
}
