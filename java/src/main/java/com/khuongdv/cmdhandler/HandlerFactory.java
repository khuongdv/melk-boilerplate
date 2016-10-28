package com.khuongdv.cmdhandler;

/**
 * Created by KhuongDV on 10/28/2016.
 */
public class HandlerFactory {
    public static ICommandHandler getHandler(String command) {
        if (ICommandHandler.COMMAND_HELP.equals(command)) {
            return new HelpHandler();
        }
        if (ICommandHandler.COMMAND_START.equals(command)) {
            return new StartHandler();
        }
        return null;
    }
}
