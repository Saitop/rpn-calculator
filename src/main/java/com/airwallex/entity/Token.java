package com.airwallex.entity;

import com.airwallex.Step;
import com.airwallex.exception.CalculatorException;

import java.util.Stack;

public abstract class Token {
        private String type;
    private String value;

    public abstract void execute(Stack<Token> tokens, Stack<Step> cachedNumbers, int currentIndex) throws CalculatorException;

    public Token(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
