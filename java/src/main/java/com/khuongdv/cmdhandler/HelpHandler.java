package com.khuongdv.cmdhandler;

import com.khuongdv.utils.ConfigurationUtils;
import org.apache.log4j.Logger;

/**
 * Created by KhuongDV on 10/28/2016.
 */
public class HelpHandler implements ICommandHandler {
    public static Logger log = Logger.getLogger(HelpHandler.class);

    public HelpHandler() {

    }

    private String name = "Help Handler";

    public String getName() {
        return name;
    }

    @Override
    public void preProcess() {
        // Nothing to do
    }

    @Override
    public void process() {
        log.info("Printing help information");
        OUT.println("\tELK Stack CLI, powered by (c) KhuongDV");
        OUT.println("\tVersion: " + ConfigurationUtils.get("app.version"));
        OUT.println("\tRun with command 'start' to start the stack.");
    }

    @Override
    public void postProcess() {

    }

    @Override
    public void template() {
        preProcess();
        process();
        postProcess();
    }
}
