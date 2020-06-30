package webElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Base;

public class HomePageElements extends Base {

  public HomePageElements(){
    PageFactory.initElements(driver, this);
  }
  @FindBy(xpath = "//input[@name='username']")
  public WebElement userName;
  @FindBy(xpath = "//input[@name='password']")
   public WebElement passWord;
  @FindBy(xpath = "//input[@class='button']")
   public WebElement submit;
  @FindBy(xpath = "//a[contains(text(),'home')]")
  public WebElement homepageIcon;
}
