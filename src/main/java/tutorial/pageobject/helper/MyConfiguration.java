package tutorial.pageobject.helper;

import java.util.Properties;

public class MyConfiguration {

    private static Properties properties;
    public static  Long TIME_OUT = 10L;

    private MyConfiguration() {

    }

    public static void load() throws Exception {
        properties = new Properties();
        properties.load(MyConfiguration.class.getClassLoader().getResourceAsStream("object.properties"));
        TIME_OUT = Long.parseLong(properties.get("timeout").toString());

    }

    public static String get(String option) throws Exception {
        if (properties == null) {
            load();
        }
        String value = properties.getProperty(option);
        return value;
    }
}
