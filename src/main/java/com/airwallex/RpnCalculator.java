package com.airwallex;

import java.util.Scanner;
import java.util.Stack;

public class RpnCalculator {

    private static final String EXIT_CODE = ":q";

    public static void main(String[] args) {
        final RpnCalculator rpnCalculator = new RpnCalculator();
        rpnCalculator.run();
    }

    private void run() {
        instruction();
        Scanner scan = new Scanner(System.in);

        while(scan.hasNextLine()) {
            String input = scan.nextLine();
            exit(input);
            System.out.println("===================================");
            System.out.println("Result as below:");
            System.out.println("-----------------------------------");
            //todo: make it real
            System.out.printf("Input:\t%s\t\n", input);

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
        System.out.println("Available operators are +, -, *, /, sqrt, undo, clear");
        System.out.println("*******************************************************");

    }

}
