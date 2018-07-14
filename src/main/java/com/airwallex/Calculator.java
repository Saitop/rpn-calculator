package com.airwallex;

import com.airwallex.entity.*;
import com.airwallex.exception.CalculatorException;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Stack;
import java.util.stream.Collectors;

public class Calculator {
    private final Processor processor;
    private Stack<Token> numberStack = new Stack<>();

    public Calculator() {
        this.processor = new Processor();
    }

    public void process(String input) {
        String[] inputStrings = input.split("\\s+");
        for (String inputString : inputStrings) {
            String trimmedString = inputString.trim();
            Token token = null;
            if (processor.isNumber(trimmedString)) {
                token = new NumberToken(trimmedString);
                numberStack.push(token);
            } else if (trimmedString.equals("+")) {
                token = new AdditionToken(trimmedString);
            } else if (trimmedString.equals("-")) {
                token = new SubtractionToken(trimmedString);
            } else if (trimmedString.equals("sqrt")) {
                token = new SquareRootToken(trimmedString);
            } else if (trimmedString.equals("/")) {
                token = new DivisionToken(trimmedString);
            } else if (trimmedString.equals("*")) {
                token = new MultiplicationToken(trimmedString);
            } else if (trimmedString.equals("undo")) {
                token = new UndoToken(trimmedString);
            } else if (trimmedString.equals("clear")) {
                token = new ClearToken(trimmedString);
            }
            try {
                assert token != null;
                token.execute(numberStack);
            } catch (CalculatorException e) {
                System.out.println(e.getMessage());
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
