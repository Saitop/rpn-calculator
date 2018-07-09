package com.airwallex;

import java.text.DecimalFormat;
import java.util.Stack;
import java.util.stream.Collectors;

public class RpnStack {
    private Stack<Double> numberStack = new Stack<>();
    private int currentIndex;

    public void process(String input) {
        currentIndex = 0;
        String[] inputStrings = input.split("\\s+");
        for (String string : inputStrings) {
            currentIndex++;
            processNumber(string);
        }
    }

    private void processNumber(String input) {
        Double value = parseNumber(input);
        if(!Double.isNaN(value)) {
            numberStack.push(value);
        }

    }

    private Double parseNumber(String str) {
        try {
            return Double.parseDouble(str);
        } catch (Exception e) {
            return null;
        }
    }

    public String printNumberStack() {
        DecimalFormat fmt = new DecimalFormat("0.##########");
        return numberStack.stream()
                .map(fmt::format)
                .collect(Collectors.joining(" "));
    }
}
