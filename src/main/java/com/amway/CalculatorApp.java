package com.amway;

import com.amway.command.*;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        BasicCalculator basicCalculator = new BasicCalculator();
        Calculator calculator = new Calculator(basicCalculator);

        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Calculator");
        System.out.println("Support functions: ");
        System.out.println("Add: + <number>");
        System.out.println("Subtract: - <number>");
        System.out.println("Multiply: * <number>");
        System.out.println("Divide: / <number>");
        System.out.println("Undo: undo");
        System.out.println("Redo: redo");
        System.out.println("Exit: exit");
        System.out.println("-----------------------");

        while (true) {
            System.out.print("Enter command: ");
            command = scanner.nextLine().trim();

            if (command.startsWith("+")) {
                double value = Double.parseDouble(command.split(" ")[1]);
                Command add = new AddCommand(basicCalculator, value);
                calculator.executeOperation(add);
                System.out.println("Result: " + calculator.getCurrentValue());
            } else if (command.startsWith("-")) {
                double value = Double.parseDouble(command.split(" ")[1]);
                Command subtract = new SubtractCommand(basicCalculator, value);
                calculator.executeOperation(subtract);
                System.out.println("Result: " + calculator.getCurrentValue());
            } else if (command.startsWith("*")) {
                double value = Double.parseDouble(command.split(" ")[1]);
                Command multiply = new MultiplyCommand(basicCalculator, value);
                calculator.executeOperation(multiply);
                System.out.println("Result: " + calculator.getCurrentValue());
            } else if (command.startsWith("/")) {
                double value = Double.parseDouble(command.split(" ")[1]);
                Command divide = new DivideCommand(basicCalculator, value);
                calculator.executeOperation(divide);
                System.out.println("Result: " + calculator.getCurrentValue());
            } else if (command.equals("undo")) {
                calculator.undo();
                System.out.println("Result: " + calculator.getCurrentValue());
            } else if (command.equals("redo")) {
                calculator.redo();
                System.out.println("Result: " + calculator.getCurrentValue());
            } else if (command.equals("exit")) {
                System.out.println("Exit calculator...");
                break;
            } else {
                System.out.println("Invalid command: " + command + ", please try again.");
            }
        }

        scanner.close();
    }
}
