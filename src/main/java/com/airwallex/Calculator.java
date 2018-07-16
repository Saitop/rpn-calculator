package com.airwallex;

import com.airwallex.entity.Token;
import com.airwallex.exception.CalculatorException;
import com.airwallex.exception.InsufficientParamsException;
import com.airwallex.exception.InvalidInputException;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Stack;
import java.util.stream.Collectors;

public class Calculator {
    private final Processor processor;
    private Stack<Token> numberStack = new Stack<>();
    private Stack<Operation> cachedOperations = new Stack<>();

    public Calculator() {
        this.processor = new Processor();
    }

    public void process(String input) throws CalculatorException {
        String[] inputStrings = input.split("\\s+");
        int currentIndex = 0;
        for (String inputString : inputStrings) {
            currentIndex += inputString.length();
            Token token = null;
            try {
                token = processor.createToken(inputString.trim());
                if(token != null) {
                    if(token.getType().equals("Number")) {
                        numberStack.push(token);
                    }
                    token.execute(numberStack, cachedOperations);
                }
            } catch (InvalidInputException e) {
                throw new CalculatorException(String.format("Invalid input: %s", inputString));
            } catch (InsufficientParamsException e) {
                if(token.getValue().equals("sqrt")) {
                    currentIndex -= 3;
                }
                throw new CalculatorException(String.format("operator %s (position: %d): insufficient parameters",
                        token.getValue(), currentIndex));
            }
            currentIndex += 1;
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
