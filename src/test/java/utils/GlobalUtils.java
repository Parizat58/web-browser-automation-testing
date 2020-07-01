package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class GlobalUtils extends Base {

  static final Logger logger = LoggerFactory.getLogger(Logger.class.getName());
  protected String currentTestName;

  private GlobalUtils(WebDriver driver){
    Base.driver = driver;
  }
  public static GlobalUtils valueOf(WebDriver driver){
    return new GlobalUtils(driver);
  }
  /**
   * To move file to another location It will delete file if it exists before moving it into
   *
   * @param file        the file to move
   * @param newLocation pathname to move the file to
   * @return successful or not
   */
  public static boolean moveFile(File file, String newLocation) {
    logger.info("moving file");
    File targetFile = new File(newLocation);
    if (targetFile.exists()) {
      targetFile.delete();
    }

    return file.renameTo(new File(newLocation));
  }

  public void setTestName(String testName) {
    currentTestName = testName;
  }

  public WebElement waitUntilElementClickable(By by) {
    WebElement dynamicElem = null;
    try {
      dynamicElem = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
    } catch (Exception e) {
      logger.error("Error: ", e);
      Assert.assertTrue(false);
    }
    return dynamicElem;
  }
  public WebElement waitUntilElementClickable(WebElement element) {
    WebElement dynamicElem = null;
    try {
      dynamicElem = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(element));
    } catch (Exception e) {
      logger.error("Error: ", e);
      Assert.assertTrue(false);
    }
    return dynamicElem;
  }

  public WebElement waitUntilElementPresence(By by) {
    WebElement dynamicElem = null;
    try {

      dynamicElem = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(by));
    } catch (Exception e) {
      logger.error("Error: ", e);
      Assert.assertTrue(false);
    }
    return dynamicElem;
  }

  public WebElement waitUntilElementVisibility(By by) {
    WebElement dynamicElem = null;
    try {
      dynamicElem = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(by));
    } catch (Exception e) {
      logger.error("Error: ", e);
      Assert.assertTrue(false);
    }
    return dynamicElem;
  }

  public WebDriver startChromeDriver(){
    try{
      System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
      DesiredCapabilities cap = DesiredCapabilities.chrome();
      cap.setBrowserName("chrome");
      cap.setPlatform(Platform.MAC);
      ChromeOptions options = new ChromeOptions();
      options.merge(cap);
      driver = new ChromeDriver(options);
      driver.manage().window().maximize();
      driver.manage().deleteAllCookies();
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }catch (Exception e){
      logger.error("Error: ", e);
    }
    return driver;
  }
  public void selectDropDown(WebElement element, int optionValueIndex) {
    try {
      Select dropdown = new Select(element);
      dropdown.selectByIndex(optionValueIndex);
    } catch (Exception e) {
      logger.error("Error", e);
      Assert.assertTrue(false);
    }
  }

  public void selectDropDown(By by, String optionValueText) {
    try {
      Select dropdown = new Select(driver.findElement(by));
      dropdown.selectByVisibleText(optionValueText);
    } catch (Exception e) {
      logger.error("Error: ", e);
      Assert.assertTrue(false);
    }
  }

  public void selectDropDown(WebElement element, String optionValueText) {
    try {
      Select dropdown = new Select(element);
      dropdown.selectByVisibleText(optionValueText);
    } catch (Exception e) {
      logger.error("Error: ", e);
      Assert.assertTrue(false);
    }
  }
  public void customWait(double inSeconds) {
    try {
      Thread.sleep((long) (inSeconds * 1000));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
