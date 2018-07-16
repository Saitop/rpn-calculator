package com.airwallex;

import com.airwallex.entity.Token;

import java.util.List;

public class Operation {
    private List<Token> numbers;
    private Token operator;

    public Operation(List<Token> numbers, Token operator) {
        this.numbers = numbers;
        this.operator = operator;
    }

    public List<Token> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Token> numbers) {
        this.numbers = numbers;
    }

    public Token getOperator() {
        return operator;
    }

    public void setOperator(Token operator) {
        this.operator = operator;
    }
}
