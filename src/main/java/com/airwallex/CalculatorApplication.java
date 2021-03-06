package com.airwallex;

import com.airwallex.exception.CalculatorException;

import java.util.Scanner;

public class CalculatorApplication {

    private static final String EXIT_CODE = ":q";

    public static void main(String[] args) {
        final CalculatorApplication calculatorApplication = new CalculatorApplication();
        calculatorApplication.run();
    }

    private void run() {
        instruction();
        Scanner scan = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while(scan.hasNextLine()) {
            String input = scan.nextLine();
            exit(input);
            System.out.println("-----------------------------------");
            System.out.printf("Input:\t%s\t\n", input);
            try {
                calculator.process(input);
            } catch (CalculatorException e) {
                System.out.println(e.getMessage());
            }
            System.out.printf("Stack:\t%s\t\n", calculator.printNumberStack());

        }

    }

    private void exit(String input) {
        if (EXIT_CODE.equals(input)) {
            System.out.println("Exit!");
            System.exit(0);
        }
    }

    private void instruction() {
        System.out.println("*******************************************************");
        System.out.println("Welcome to RPN Calculator!");
        System.out.println("Enter ':q' to exit the program");
        System.out.println("Inputs should be real number or operators");
        System.out.println("Available operators are:  +, -, *, /, sqrt, undo, clear");
        System.out.println("*******************************************************");

    }

}
