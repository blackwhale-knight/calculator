package com.amway;

public class BasicCalculator {
    private double currentValue;

    public BasicCalculator() {
        this.currentValue = 0.0;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public void add(double value) {
        currentValue += value;
    }

    public void subtract(double value) {
        currentValue -= value;
    }

    public void multiply(double value) {
        currentValue *= value;
    }

    public void divide(double value) {
        if (value != 0) {
            currentValue /= value;
        } else {
            System.out.println("Error: Division by zero");
        }
    }
}
