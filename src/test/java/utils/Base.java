package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Base {

  static final Logger logger = LoggerFactory.getLogger(Logger.class.getName());
  protected static WebDriver driver;

  @BeforeClass
  public static void setup() {
   Properties p = new Properties();
   try{
     p.load(new FileInputStream(new File("src/test/resources/config.properties")));

   }catch (Exception e){
     e.printStackTrace();
   }
     driver = new ChromeDriver();


  }

  @AfterClass
  public static void tearDown(){
    logger.info("After all test completed");
    if (driver != null){
      driver.quit();
    }
  }
}
