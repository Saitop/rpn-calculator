package com.airwallex;

import com.airwallex.entity.*;
import com.airwallex.exception.InvalidInputException;

import java.util.regex.Pattern;

public class Processor {

    public boolean isNumber(String inputString) {
        String numberRegex = "\\d+(\\.\\d+)?";
        return Pattern.matches(numberRegex, inputString);
    }

    public Token createToken(String inputString) throws InvalidInputException {
        Token token;
        if (isNumber(inputString)) {
            token = new NumberToken(inputString);
        } else if (inputString.equals("+")) {
            token = new AdditionToken();
        } else if (inputString.equals("-")) {
            token = new SubtractionToken();
        } else if (inputString.equals("sqrt")) {
            token = new SquareRootToken();
        } else if (inputString.equals("/")) {
            token = new DivisionToken();
        } else if (inputString.equals("*")) {
            token = new MultiplicationToken();
        } else if (inputString.equals("undo")) {
            token = new UndoToken();
        } else if (inputString.equals("clear")) {
            token = new ClearToken();
        } else {
            throw new InvalidInputException();
        }
        return token;
    }
}
