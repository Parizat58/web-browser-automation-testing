package pages;

import WebElementsFactory.HomePageElements;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Base;

public class EyesDemoPage extends Base {

  static final Logger logger = LoggerFactory.getLogger(Logger.class.getName());
  HomePageElements elements = new HomePageElements();

  private void enterUsername() {
    elements.userName.sendKeys(readingProperties.readProperty("userName"));
  }

  private void enterPassword() {
    elements.passWord.sendKeys(readingProperties.readProperty("passWord"));
  }

  private void clickSubmit() {
    myUtils.waitUntilElementClickable(elements.submit).click();
  }

  public void login() {
    enterUsername();
    enterPassword();
    clickSubmit();
  }

  public void clickHomePageIcon() {
    myUtils.waitUntilElementClickable(elements.homepageIcon).click();
  }

  public By getHomepageIconLocator(){
    return By.xpath("//a[contains(text(),'home')]");
  }
}
