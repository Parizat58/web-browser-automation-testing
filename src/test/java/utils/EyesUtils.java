package utils;

import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.WebDriver;

public class EyesUtils extends Base {

  private Eyes eyes;
  private WebDriver driver;
  private String appName;

  public EyesUtils(WebDriver driver, String appName) {
    this.driver = driver;
    this.appName = appName;
    eyes = new Eyes();
    eyes.setApiKey(readingProperties.readProperty("applitools.api.key"));
  }

  public void validateWindow() {
    //calling open method to start a test
    eyes.open(driver, appName, Thread.currentThread().getStackTrace()[2].getMethodName());
    eyes.checkWindow();
    eyes.close();
  }

  public void abort() {
    eyes.abortIfNotClosed();
  }
}
