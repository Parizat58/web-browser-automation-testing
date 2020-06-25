package utils;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {

  static final Logger logger = LoggerFactory.getLogger(Logger.class.getName());
  protected static WebDriver driver;
  protected static EyesUtils eyesUtils;
  protected static GlobalUtils myUtils;
  protected static PropertiesManager readingProperties;

  @BeforeClass
  public static void setup() {
    logger.info("Before all test completed");
    readingProperties = new PropertiesManager("src/test/resources/config.properties");
    myUtils = GlobalUtils.valueOf(driver);
    driver = myUtils.startChromeDriver();
    driver.get(readingProperties.readProperty("site.url"));
    eyesUtils = new EyesUtils(driver, readingProperties.readProperty("appName"));
  }

  @AfterClass
  public static void tearDown() {
    logger.info("After all test completed");
    if (driver != null) {
      driver.quit();
      eyesUtils.abort();
    }
  }
}
