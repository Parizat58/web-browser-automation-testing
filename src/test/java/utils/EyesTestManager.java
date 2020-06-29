package utils;

import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EyesTestManager extends Base {

  private Eyes eyes;
  private WebDriver driver;
  private String appName;

  public EyesTestManager(WebDriver driver, String appName) {
    this.driver = driver;
    this.appName = appName;
    eyes = new Eyes();
    eyes.setApiKey(readingProperties.readProperty("applitools.api.key"));
  }

  //Runs a checkpoint of the entire application (e.g. browser) window.
  public void validateWindow() {
    //calling open method to start a test
    eyes.open(driver, appName, Thread.currentThread().getStackTrace()[2].getMethodName());
    eyes.checkWindow();
    eyes.close();
  }

  //run a checkpoint on the area of a particular element
  public void validateElement(By by) {
    eyes.open(driver, appName, Thread.currentThread().getStackTrace()[2].getMethodName());
    eyes.checkElement(by);
    eyes.close();
  }

  public void validateElement(WebElement element) {
    eyes.open(driver, appName, Thread.currentThread().getStackTrace()[2].getMethodName());
    eyes.checkElement(element);
    eyes.close();
  }

  public void abort() {
    eyes.abortIfNotClosed();
  }
}
