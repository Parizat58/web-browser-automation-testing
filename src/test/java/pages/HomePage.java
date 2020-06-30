package pages;

import webElements.HomePageElements;
import utils.Base;

public class HomePage extends Base {

  HomePageElements elements = new HomePageElements();

  public AccountPage login() {
    enterUserName();
    enterPassword();
    submit();
    return new AccountPage();
  }

  private void enterUserName() {
    elements.userName.sendKeys(readingProperties.readProperty("userName"));
  }

  private void enterPassword() {
    elements.passWord.sendKeys(readingProperties.readProperty("passWord"));
  }

  private void submit() {
    elements.submit.click();
  }

  private void clickHomepageIcon() {
    myUtils.waitUntilElementClickable(elements.homepageIcon).click();
  }
}
