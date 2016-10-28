package com.khuongdv;

import com.khuongdv.cmdhandler.HandlerFactory;
import com.khuongdv.cmdhandler.ICommandHandler;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    static PrintStream OUT = System.out;

    /**
     * Args must contain ONE String in this array ["start", "stop"]
     *
     * @param args
     */
    public static void main(String[] args) {
        args = new String[]{"help"};
        if (args == null || args.length != 1) {
            showInvalidParam();
            return;
        }
        String command = args[0];
        if (!isAValidCommand(command)) {
            return;
        }
        process(command);
    }

    /**
     *
     * @param command
     */
    private static void process(String command) {
        ICommandHandler handler = HandlerFactory.getHandler(command);
        handler.template();
    }

    /**
     * Check if the command is in the allowed list
     *
     * @param command
     * @return
     */
    private static boolean isAValidCommand(String command) {
        command = command.toLowerCase();
        List<String> listCommands = Arrays.asList("help", "start", "stop");
        if (listCommands.contains(command)) {
            return true;
        }
        showInvalidParam();
        return false;
    }

    /**
     * In case main method got invalid parameter, show message to user
     */
    private static void showInvalidParam() {
        OUT.println();
        OUT.println("\tInvalid param. Retry with parameter \"help\" for more information.");
        OUT.println();
    }
}
