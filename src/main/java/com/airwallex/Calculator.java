package com.airwallex;

import com.airwallex.entity.Token;
import com.airwallex.exception.CalculatorException;

import java.math.RoundingMode;
import java.text.DecimalFormat;
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
        currentIndex = 0;
        for (String inputString : inputStrings) {
            currentIndex += inputString.length();
            String trimmedString = inputString.trim();
            Token token = processor.createToken(trimmedString);
            if (token != null) {
                if(token.getType().equals("Number")) {
                    numberStack.push(token);
                } else if(token.getType().equals("Operation")) {
                    operatorStack.push(token);
                }
                try {
                    token.execute(numberStack, cachedSteps);
                } catch (CalculatorException e) {
                    throw new CalculatorException(String.format("operator %s (position: %d): insufficient parameters",
                            token.getValue(), currentIndex));
                }
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
