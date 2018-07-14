package com.airwallex;

import com.airwallex.entity.Token;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Calculator {
    private final Processor processor;
    private Stack<Token> numberStack = new Stack<>();
    private Stack<Token> operatorStack = new Stack<>();

    public Calculator() {
        this.processor = new Processor();
    }

    public void process(String input) {
        List<Token> tokens = processor.processInputString(input);
        classifyToken(tokens);

        while (!operatorStack.empty()) {
            final Token operator = operatorStack.pop();
            try {
                operator.execute(numberStack);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void classifyToken(List<Token> tokens) {
        for (Token token: tokens) {
            if (token.getType().equals("NumberToken")) {
                numberStack.push(token);
            } else {
                operatorStack.push(token);
            }
        }
    }


    public String printNumberStack() {
        DecimalFormat fmt = new DecimalFormat("0.##########");
        return numberStack.stream()
                .map(token -> Double.valueOf(token.getValue()))
                .map(fmt::format)
                .collect(Collectors.joining(" "));
    }
}
