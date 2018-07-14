package com.airwallex;

import com.airwallex.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Processor {

    public boolean isNumber(String inputString) {
        String numberRegex = "\\d+(\\.\\d+)?";
        return Pattern.matches(numberRegex, inputString);
    }

    public List<Token> processInputString(String input) {
        List<Token> result = new ArrayList<>();
        String[] inputStrings = input.split("\\s+");
        for (String inputString : inputStrings) {
            String trimmedString = inputString.trim();
            if (isNumber(trimmedString)) {
                result.add(new NumberToken(trimmedString));
            } else if (trimmedString.equals("+")) {
                result.add(new AdditionToken(trimmedString));
            } else if (trimmedString.equals("-")) {
                result.add(new SubtractionToken(trimmedString));
            } else if (trimmedString.equals("sqrt")) {
                result.add(new SquareRootToken(trimmedString));
            } else if (trimmedString.equals("/")) {
                result.add(new DivisionToken(trimmedString));
            } else if (trimmedString.equals("*")) {
                result.add(new MultiplicationToken(trimmedString));
            } else if (trimmedString.equals("undo")) {
                result.add(new UndoToken(trimmedString));
            } else if (trimmedString.equals("clear")) {
                result.add(new ClearToken(trimmedString));
            }
        }
        return result;
    }
}
