package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Base;

public class Homepage extends Base {
  static final Logger logger = LoggerFactory.getLogger(Logger.class.getName());
  private By userName= By.xpath("//input[@name='username']");
  private By password=By.xpath("//input[@name='password']");
  private By submit=By.xpath("//input[@class='button']");

  public Homepage(WebDriver driver){
    Base.driver = driver;
  }

  private void enterUsername(){
    myUtils.waitUntilElementVisibility(userName);
     driver.findElement(userName).sendKeys(readingProperties.readProperty("userName"));
  }

  private void enterPassword(){
    myUtils.waitUntilElementVisibility(password);
    driver.findElement(password).sendKeys(readingProperties.readProperty("passWord"));
  }
  private void clickSubmit(){
    myUtils.waitUntilElementClickable(submit);
    driver.findElement(submit).click();
  }
  public void login(){
    enterUsername();
    enterPassword();
    clickSubmit();
  }
}
