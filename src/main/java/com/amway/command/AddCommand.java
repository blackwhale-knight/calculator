package com.amway.command;

import com.amway.BasicCalculator;

public class AddCommand implements Command {
    private BasicCalculator basicCalculator;
    private double value;
    private double previousValue;

    public AddCommand(BasicCalculator basicCalculator, double value) {
        this.basicCalculator = basicCalculator;
        this.value = value;
    }

    @Override
    public void execute() {
        previousValue = basicCalculator.getCurrentValue();
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
