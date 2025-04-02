package com.amway.command;

import com.amway.BasicCalculator;

public class MultiplyCommand implements Command {
    private BasicCalculator basicCalculator;
    private double value;

    public MultiplyCommand(BasicCalculator basicCalculator, double value) {
        this.basicCalculator = basicCalculator;
        this.value = value;
    }

    @Override
    public void execute() {
        basicCalculator.multiply(value);
    }

    @Override
    public void undo() {
        if (value != 0) {
            basicCalculator.divide(value); // undo multiply operation ---> divide the value
        } else {
            System.out.println("Error: Cannot undo multiplication by zero."); // cannot divide by 0
        }
    }

    @Override
    public void redo() {
        basicCalculator.multiply(value); // redo multiply operation
    }
}
