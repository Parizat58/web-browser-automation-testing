package webElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Base;

public class AccountPageElements extends Base {
  public AccountPageElements(){
    PageFactory.initElements(driver, this);
  }
  @FindBy(xpath = "//a[contains(text(),'Log Out')]")
  public WebElement logOut;
  @FindBy(xpath = "//a[contains(text(),'Request Loan')]")
  public WebElement requestLoan;
  @FindBy(xpath = "//a[contains(text(),'Update Contact Info')]")
  public WebElement updateContactInfo;
  @FindBy(xpath = "//a[contains(text(),'Find Transactions')]")
  public WebElement findTransaction;
  @FindBy(xpath = "//a[contains(text(),'Bill Pay')]")
  public WebElement billPay;
  @FindBy(xpath = "//a[contains(text(),'Transfer Funds')]")
  public WebElement transferFunds;
  @FindBy(xpath = "//a[contains(text(),'Accounts Overview')]")
  public WebElement accountsOverview;
  @FindBy(xpath = "//a[contains(text(),'Open New Account')]")
  public WebElement openNewAccount;
  @FindBy(id = "type")
  public WebElement typeOfAccountSelection;
  @FindBy(id = "fromAccountId")
  public WebElement selectAccount;
  @FindBy(xpath = "//input[@class='button']")
  public WebElement openNewAccountbtn;
  @FindBy(xpath = "//p[contains(text(),'Congratulations, your account is now open.')]")
  public WebElement accountOpenedMessage;
}
