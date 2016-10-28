package com.khuongdv.utils;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by KhuongDV on 10/28/2016.
 */
public class ConfigurationUtils {
    private static final String APP_PROP_FILE = "/config.properties";
    public static Logger log = Logger.getLogger(ConfigurationUtils.class);
    Properties properties;

    private ConfigurationUtils() {
        properties = new Properties();
        InputStream input = null;
        try {
            log.debug("Reading content of config.properties");
            input = ConfigurationUtils.class.getResourceAsStream(APP_PROP_FILE);
            properties.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static ConfigurationUtils instance = null;

    public static String get(String key) {
        instantiate();
        if (instance.properties == null) {
            return "";
        }
        return instance.properties.getProperty(key);
    }

    private static void instantiate() {
        if (instance == null) {
            instance = new ConfigurationUtils();
        }
    }
}
