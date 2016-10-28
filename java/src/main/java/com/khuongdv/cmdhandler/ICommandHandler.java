package com.khuongdv.cmdhandler;

import com.khuongdv.exception.MyException;

import java.io.PrintStream;

/**
 * Common interface that all the handlers must implement
 * Created by KhuongDV on 10/28/2016.
 */
public interface ICommandHandler {
    public static final String COMMAND_HELP = "help";
    public static final String COMMAND_START = "start";
    public static final String COMMAND_STOP = "stop";
    public static final PrintStream OUT = System.out;

    public void preProcess() throws MyException;

    public void process();

    public void postProcess();

    default void template() throws MyException{
        preProcess();
        process();
        postProcess();
    }
}
