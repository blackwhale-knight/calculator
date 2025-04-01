package com.amway;

import com.amway.command.Command;

import java.util.Stack;

public class Calculator {
    private Stack<Command> undoStack;
    private Stack<Command> redoStack;
    private BasicCalculator basicCalculator;

    public Calculator(BasicCalculator basicCalculator) {
        this.basicCalculator = basicCalculator;
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    public void executeOperation(Command command) {
        command.execute();
        undoStack.push(command);
        redoStack.clear(); // clear redo stack after new command
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            Command command = undoStack.pop();
            command.undo();
            redoStack.push(command);
        } else {
            System.out.println("No command to undo.");
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            command.redo();
            undoStack.push(command);
        } else {
            System.out.println("No command to redo.");
        }
    }

    public double getCurrentValue() {
        return basicCalculator.getCurrentValue();
    }
}
