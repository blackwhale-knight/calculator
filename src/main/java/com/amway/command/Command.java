package com.amway.command;

public interface Command {
    void execute();
    void undo();
    void redo();
}
