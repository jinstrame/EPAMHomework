package exceptions.task02;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;
import java.util.Properties;


@SuppressWarnings("WeakerAccess")
public class PropertyReader {

    private Properties properties;

    protected PropertyReader(String file) throws IOException{
        FileInputStream fis = new FileInputStream(file);

        properties = new Properties();
        properties.load(fis);
        fis.close();
    }

    public static Optional<PropertyReader> getReader(String file){
        PropertyReader reader;
        try {
            reader = new PropertyReader(file);
        } catch (IOException e) {
            reader = null;
        }

        return Optional.ofNullable(reader);

    }

    public Optional<String> getProperty (String key){
        String ret;
        if (key == null)
            ret = null;
        else
            ret = properties.getProperty(key);
        return Optional.ofNullable(ret);
    }

    public HashMap<String, String> getProperties(String[] keys){
        HashMap<String, String> ret = new HashMap<>();
        if (keys == null) return ret;

        for (String key : keys){
            getProperty(key).ifPresent(s -> ret.put(key, s));
        }
        return ret;
    }
}
