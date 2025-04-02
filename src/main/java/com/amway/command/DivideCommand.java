package com.amway.command;

import com.amway.BasicCalculator;

public class DivideCommand implements Command {
    private BasicCalculator basicCalculator;
    private double value;

    public DivideCommand(BasicCalculator basicCalculator, double value) {
        this.basicCalculator = basicCalculator;
        this.value = value;
    }

    @Override
    public void execute() {
        if (value != 0) {
            basicCalculator.divide(value);
        } else {
            System.out.println("Error: Division by zero."); // cannot divide by 0
        }
    }

    @Override
    public void undo() {
        if (value != 0) {
            basicCalculator.multiply(value); //  undo divide operation ---> multiply the value
        } else {
            System.out.println("Error: Cannot undo division by zero."); // cannot divide by 0
        }
    }

    @Override
    public void redo() {
        if (value != 0) {
            basicCalculator.divide(value); // redo divide operation
        } else {
            System.out.println("Error: Cannot redo division by zero."); // cannot divide by 0
        }
    }
}
