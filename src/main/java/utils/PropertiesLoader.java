package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesLoader.class);
    private static final String PATH = "src/main/resources/testdata.properties";

    public static String getProperty(String property) {
        try (InputStream input = new FileInputStream(PATH)) {
            Properties props = new Properties();
            props.load(input);
            return props.getProperty(property);
        } catch (IOException e) {
            LOGGER.error(String.valueOf(e));
        }
        return null;
    }
}
