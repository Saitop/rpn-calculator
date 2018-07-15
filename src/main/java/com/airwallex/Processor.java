package com.airwallex;

import com.airwallex.entity.*;
import com.airwallex.exception.InvalidInputException;

import java.util.regex.Pattern;

public class Processor {

    boolean isNumber(String inputString) {
        String numberRegex = "(\\+|-)?\\d+(\\.\\d+)?";
        return Pattern.matches(numberRegex, inputString);
    }

    boolean isValidOperator(String inputString) {
        String numberRegex = "(undo|clear|sqrt|\\+|-|\\*|\\/|)";
        return Pattern.matches(numberRegex, inputString);
    }

    boolean isSpaceOrEnter(String inputString) {
        String numberRegex = "(\\s+)?|\n";
        return Pattern.matches(numberRegex, inputString);
    }

    public Token createToken(String inputString) throws InvalidInputException {
        if (!isNumber(inputString) && !isValidOperator(inputString) && !isSpaceOrEnter(inputString)) {
            throw new InvalidInputException();
        }
        if (isNumber(inputString)) {
            return new NumberToken(inputString);
        } else if ("+".equals(inputString)) {
            return new AdditionToken();
        } else if ("-".equals(inputString)) {
            return new SubtractionToken();
        } else if ("sqrt".equals(inputString)) {
            return new SquareRootToken();
        } else if ("/".equals(inputString)) {
            return new DivisionToken();
        } else if ("*".equals(inputString)) {
            return new MultiplicationToken();
        } else if ("undo".equals(inputString)) {
            return new UndoToken();
        } else if ("clear".equals(inputString)) {
            return new ClearToken();
        } else {
            return null;
        }
    }
}
