package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Base;

public class Homepage extends Base {

  private By userName = By.xpath("//input[@name='username']");
  private By password = By.xpath("//input[@name='password']");
  private By submit = By.xpath("//input[@class='button']");
  private By homepageIcon = By.xpath("//a[contains(text(),'home')]");

  public Homepage(WebDriver driver) {
    Base.driver = driver;
  }

  private void enterUsername() {
    myUtils.waitUntilElementVisibility(userName);
    driver.findElement(userName).sendKeys(readingProperties.readProperty("userName"));
  }

  private void enterPassword() {
    myUtils.waitUntilElementVisibility(password);
    driver.findElement(password).sendKeys(readingProperties.readProperty("passWord"));
  }

  private void clickSubmit() {
    myUtils.waitUntilElementClickable(submit);
    driver.findElement(submit).click();
  }

  public void login() {
    enterUsername();
    enterPassword();
    clickSubmit();
  }

  public void clickHomePageIcon(){
    myUtils.waitUntilElementClickable(homepageIcon);
    driver.findElement(homepageIcon).click();
  }

  public By getHomepageIconLocator(){
    return By.xpath("//a[contains(text(),'home')]");
  }
}
