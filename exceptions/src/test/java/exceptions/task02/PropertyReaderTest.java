package exceptions.task02;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class PropertyReaderTest {
    @Test
    public void getProperty() throws Exception {
        String propFile = "src/test/resources/test.properties";
        String[] keys = {"login", "password", "encryption"};

        final Map<String, String> map = new HashMap<>();

        PropertyReader.getReader(propFile).ifPresent( pr -> {
                    map.putAll(pr.getProperties(keys));
                    for (String k : map.keySet()){
                        System.out.println(k + " = " + map.get(k));
                    }
                }
        );

        assertThat(map.get("login"), equalTo("admin"));
        assertThat(map.get("password"), equalTo("password"));
        assertFalse(map.containsKey("encryption"));
    }
}