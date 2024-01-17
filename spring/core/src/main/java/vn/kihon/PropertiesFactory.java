package vn.kihon;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

public final class PropertiesFactory {
    private PropertiesFactory() {
    }

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

    public static Map<String, Object> fromProperties(String resourceRelativePath) {
        Properties properties = fromResources(resourceRelativePath);
        if (properties == null) {
            return null;
        }

        return properties.entrySet()
                .stream()
                .collect(Collectors.toMap(e -> (String)e.getKey(), Map.Entry::getValue));
    }
}
