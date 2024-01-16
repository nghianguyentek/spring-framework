package vn.kihon;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesFactory {
    private PropertiesFactory() {}

    public static Properties fromResources(String resourceRelativePath) {
        try (InputStream inputStream = PropertiesFactory.class
                .getClassLoader()
                .getResourceAsStream(resourceRelativePath)) {
            Properties instance = new Properties();
            instance.load(inputStream);
            return instance;
        } catch (IOException ioException) {
            return null;
        }
    }
}
