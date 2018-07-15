package com.airwallex;

import com.airwallex.entity.*;
import com.airwallex.exception.CalculatorException;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Calculator {
    private final Processor processor;
    private Stack<Token> numberStack = new Stack<>();
    private Stack<Token> operatorStack = new Stack<>();
    private Stack<Step> cachedSteps = new Stack<>();
    private int currentIndex = 0;

    public Calculator() {
        this.processor = new Processor();
    }

    public void process(String input) throws CalculatorException {
        String[] inputStrings = input.split("\\s+");
        for (String inputString : inputStrings) {
            currentIndex += inputString.length();
            String trimmedString = inputString.trim();
            Token token = null;
            if (processor.isNumber(trimmedString)) {
                token = new NumberToken(trimmedString);
                numberStack.push(token);
            } else if (trimmedString.equals("+")) {
                token = new AdditionToken(trimmedString);
                operatorStack.push(token);
            } else if (trimmedString.equals("-")) {
                token = new SubtractionToken(trimmedString);
                operatorStack.push(token);
            } else if (trimmedString.equals("sqrt")) {
                token = new SquareRootToken(trimmedString);
                operatorStack.push(token);
            } else if (trimmedString.equals("/")) {
                token = new DivisionToken(trimmedString);
                operatorStack.push(token);
            } else if (trimmedString.equals("*")) {
                token = new MultiplicationToken(trimmedString);
                operatorStack.push(token);
            } else if (trimmedString.equals("undo")) {
                token = new UndoToken(trimmedString);
                operatorStack.push(token);
            } else if (trimmedString.equals("clear")) {
                token = new ClearToken(trimmedString);
                operatorStack.push(token);
            }

            if (token != null) {
                token.execute(numberStack, cachedSteps, currentIndex);
                currentIndex += 1;
            }
        }
    }

    public String printNumberStack() {
        DecimalFormat fmt = new DecimalFormat("#.##########");
        fmt.setRoundingMode(RoundingMode.DOWN);
        return numberStack.stream()
                .map(token -> Double.valueOf(token.getValue()))
                .map(fmt::format)
                .collect(Collectors.joining(" "));
    }
}
