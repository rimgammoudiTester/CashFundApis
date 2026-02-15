package configManager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
public class ConfigurationReader {
    /**
     ** @Author Rim Gammoudi
     *** Role : QA test Engineer
     ***/
     static Properties prop;

        static {
            try {
                 String filePath="src/main/resources/enviroment.properties";
                FileInputStream file = new FileInputStream(filePath);
                prop = new Properties();
                prop.load(file);
                file.close();
            } catch (IOException e) {
                System.out.println("File Not Found would you verify please !!");
                throw new RuntimeException("faild to load File", e);
            }
        }

    //Method useful To read a property from the file environment.properties
     public static String getProperty(String propertyToReturn) throws FileNotFoundException {
            String value=prop.getProperty(propertyToReturn);

            if(value==null)
            {
                throw new  RuntimeException("The value of the cuurent given key " +propertyToReturn+" does not exist");
            }
        return value;
    }
}
