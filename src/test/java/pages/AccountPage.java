package pages;

import utils.Base;
import webElements.AccountPageElements;

public class AccountPage extends Base {

  AccountPageElements accountPageElements = new AccountPageElements();

  public AccountPage openNewAccount() {
    clickOpenNewAccount();
    selectCheckingTypeOfAccountLikeToOpen();
    myUtils.customWait(1);
    selectAnExistingAccountWhenOpeningANewAccount("12567");
    myUtils.customWait(1);
    clickOpenNewAccountbtn();
    return this;
  }

  public String getSuccessOpenAccountMessage() {
    return accountPageElements.accountOpenedMessage.getText();
  }

  private void clickOpenNewAccount() {
    myUtils.waitUntilElementClickable(accountPageElements.openNewAccount).click();
  }

  private void selectCheckingTypeOfAccountLikeToOpen() {
    myUtils.selectDropDown(accountPageElements.typeOfAccountSelection, "CHECKING");
  }

  private void selectSavingsTypeOfAccountLikeToOpen() {
    myUtils.selectDropDown(accountPageElements.typeOfAccountSelection, "SAVINGS");
  }

  private void selectAnExistingAccountWhenOpeningANewAccount(String value) {
    myUtils.selectDropDown(accountPageElements.selectAccount, value);
  }

  private void clickOpenNewAccountbtn() {
    accountPageElements.openNewAccountbtn.click();
  }
}
