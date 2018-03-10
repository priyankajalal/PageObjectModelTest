package com.chartlab.helper;

import java.io.IOException;
import java.util.Properties;

public class Config {

    private static Properties properties;
    public static Long TIME_OUT = 10L;

    private Config(){
    }

    public static void load() throws IOException {
        properties = new Properties();
        properties.load(Config.class.getClassLoader().getResourceAsStream("object.properties"));
        TIME_OUT = Long.parseLong(properties.get("timeout").toString());
    }

    public static String get(String option) throws IOException {
        if (properties==null){
            load();
        }
        String value = properties.getProperty(option);
        return value;
    }

}
