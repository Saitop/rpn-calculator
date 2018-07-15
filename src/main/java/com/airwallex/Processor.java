package com.airwallex;

import com.airwallex.entity.*;
import com.airwallex.exception.InvalidInputException;

import java.util.regex.Pattern;

public class Processor {

    public boolean isNumber(String inputString) {
        String numberRegex = "(\\+|-)?\\d+(\\.\\d+)?";
        return Pattern.matches(numberRegex, inputString);
    }

    private boolean isOperator(String inputString) {
        String numberRegex = "(undo|clear|sqrt|\\+|-|\\*|\\/|)";
        return Pattern.matches(numberRegex, inputString);
    }

    private boolean isSpaceOrEnter(String inputString) {
        String numberRegex = "(\\s.+|\n)";
        return Pattern.matches(numberRegex, inputString);
    }

    public Token createToken(String inputString) throws InvalidInputException {
        if (!isNumber(inputString) && !isOperator(inputString) && !isSpaceOrEnter(inputString)) {
            throw new InvalidInputException();
        }
        if (isNumber(inputString)) {
            return new NumberToken(inputString);
        } else if (inputString.equals("+")) {
            return new AdditionToken();
        } else if (inputString.equals("-")) {
            return new SubtractionToken();
        } else if (inputString.equals("sqrt")) {
            return new SquareRootToken();
        } else if (inputString.equals("/")) {
            return new DivisionToken();
        } else if (inputString.equals("*")) {
            return new MultiplicationToken();
        } else if (inputString.equals("undo")) {
            return new UndoToken();
        } else if (inputString.equals("clear")) {
            return new ClearToken();
        } else {
            return null;
        }
    }
}
