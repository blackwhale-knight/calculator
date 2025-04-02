package com.amway.command;

import com.amway.BasicCalculator;

public class AddCommand implements Command {
    private BasicCalculator basicCalculator;
    private double value;

    public AddCommand(BasicCalculator basicCalculator, double value) {
        this.basicCalculator = basicCalculator;
        this.value = value;
    }

    @Override
    public void execute() {
        basicCalculator.add(value);
    }

    @Override
    public void undo() {
        basicCalculator.subtract(value); // undo add operation ---> subtract the value
    }

    @Override
    public void redo() {
        basicCalculator.add(value); // redo add operation
    }
}
