package utils.resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropirtiesReader implements IResource {

    @Override
    public Map<String, String> read() {
        String rootFolder = System.getProperty("user.dir");

        Map<String, String> props = new HashMap<>();

        try (InputStream input = new FileInputStream(String.format("%s/src/resources/%s", rootFolder, "db.properties"))) {
            Properties prop = new Properties();
            prop.load(input);

            for(Object key: prop.keySet()) {
                props.put((String)key, prop.getProperty((String)key));
            }

            return props;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
