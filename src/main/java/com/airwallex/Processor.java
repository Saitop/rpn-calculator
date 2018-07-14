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
            if (isNumber(inputString)) {
                result.add(new NumberToken(inputString));
            } else if(inputString.equals("+")){
                result.add(new AdditionToken(inputString));
            } else if(inputString.equals("-")){
                result.add(new SubtractionToken(inputString));
            } else if(inputString.equals("sqrt")){
                result.add(new SquareRootToken(inputString));
            } else if(inputString.equals("/")){
                result.add(new DivisionToken(inputString));
            } else if(inputString.equals("*")){
                result.add(new MultiplicationToken(inputString));
            } else if(inputString.equals("clear")){
                result.add(new ClearToken(inputString));
            }
        }
        return result;
    }
}
