package com.demoqa.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties = new Properties();
            if (input == null) {
                throw new RuntimeException("Error: config.properties file could not be found in src/main/resources/");
            }
            properties.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Critical Failure: Failed to parse configuration keys from property file properties!", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}