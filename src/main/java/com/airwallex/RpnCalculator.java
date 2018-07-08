package com.airwallex;

import java.util.Scanner;

public class RpnCalculator {

    public static void main(String[] args) {
        final RpnCalculator rpnCalculator = new RpnCalculator();
        rpnCalculator.run();
    }

    private void run() {
        construction();
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()) {
            String input = scan.nextLine();
            System.out.println("Result as below:");
            System.out.println("----------------------------------");
            System.out.printf("%s \n", input);
            System.out.println("----------------------------------");

            if (":q".equals(input)) {
                System.out.println("Exit!");
                System.exit(0);
            }

        }

    }

    private void construction() {
        System.out.println("*******************************************************");
        System.out.println("Welcome to RPN Calculator!");
        System.out.println("Enter ':q' to exit the program");
        System.out.println("Available operators are +, -, *, /, sqrt, undo, clear");
        System.out.println("*******************************************************");

    }

}
