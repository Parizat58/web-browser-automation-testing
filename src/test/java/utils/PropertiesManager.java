package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesManager {

  static final Logger logger = LoggerFactory.getLogger(Logger.class.getName());
  private static String propertiesFile;
  private static Properties prop;
  private static OutputStream output;
  private static InputStream input;

  public PropertiesManager(String propertiesFilePath) {
    propertiesFile = propertiesFilePath;
    prop = new Properties();
  }
  public static void setProperty(String key, String value) {
    try {
      output = new FileOutputStream(propertiesFile);
      prop.setProperty(key, value);
      prop.store(output, null);
    } catch (Exception e) {
      logger.error("Error: ", e);
    } finally { // we need to clean the object that we created
      if (output != null) {
        try {
          output.close();
        } catch (IOException e) {

          logger.error("Error: ", e);
        }
      }
    }
  }

  public static String readProperty(String key) {
    String value = null;
    try {
      input = new FileInputStream(propertiesFile);
      prop.load(input);
      value = prop.getProperty(key);
    } catch (Exception e) {
      logger.error("Error: ", e);
    } finally {
      if (input != null) {
        try {
          input.close();
        } catch (Exception e) {
          logger.error("Error: ", e);
        }
      }
    }

    return value;
  }

}
