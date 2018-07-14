package com.airwallex.entity;

import java.util.Stack;

public class UndoToken extends Token {

    public UndoToken(String value) {
        super("UndoToken", value);
    }

    @Override
    public void execute(Stack<Token> tokens) {
        tokens.pop();
    }
}
