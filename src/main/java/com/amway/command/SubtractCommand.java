package com.amway.command;

import com.amway.BasicCalculator;

public class SubtractCommand implements Command {
    private BasicCalculator basicCalculator;
    private double value;

    public SubtractCommand(BasicCalculator basicCalculator, double value) {
        this.basicCalculator = basicCalculator;
        this.value = value;
    }

    @Override
    public void execute() {
        basicCalculator.subtract(value);
    }

    @Override
    public void undo() {
        basicCalculator.add(value); // undo subtract operation ---> add the value
    }

    @Override
    public void redo() {
        basicCalculator.subtract(value); // redo subtract operation
    }
}
