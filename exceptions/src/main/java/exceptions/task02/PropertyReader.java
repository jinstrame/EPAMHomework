package exceptions.task02;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;


@SuppressWarnings("WeakerAccess")
public class PropertyReader {

    private static Map<String, PropertyReader> alreadyReaded = new ConcurrentHashMap<>();

    private static void addNew(String file, PropertyReader prop){
        if (prop == null)
            return;
        alreadyReaded.put(file, prop);
    }

    private static PropertyReader get(String file){
        return alreadyReaded.get(file);
    }

    private Properties properties;

    private PropertyReader(String file) throws IOException{
        try(FileInputStream fis = new FileInputStream(file)) {
            properties = new Properties();
            properties.load(fis);
        }
    }

    public static Optional<PropertyReader> getReader(String file){

        PropertyReader reader;
        if (alreadyReaded.containsKey(file))
            reader = alreadyReaded.get(file);

        else{
            synchronized(PropertyReader.class){

                if (alreadyReaded.containsKey(file))
                    reader = alreadyReaded.get(file);

                else{
                    try {
                        reader = new PropertyReader(file);
                        alreadyReaded.put(file, reader);
                    }
                    catch (IOException e) {
                        reader = null;
                    }
                }
            }
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
