package common;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;
//import org.apache.log4j.Logger;

public class PropertyValues {
//    private static Logger log = Logger.getLogger(PropertyValues.class);

    static String current_property = "";

    static InputStream inputStream;

    public static String getPropertiesData(String key) {
        try {
            String propFileName = "config.properties";
            //inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            Properties prop = new Properties();
            inputStream = (new FileInputStream("resources/config/config.properties"));
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            //Date time = new Date(System.currentTimeMillis());
            current_property = prop.getProperty(key);
        } catch (Exception e) {
            //e.printStackTrace();
            //System.out.println("Exception: " + e);
//            log.warn("Exception is: ", e);
        }
        return current_property;
    }
}
