package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;
import utils.Base;

public class AccountPageTest extends Base {

  HomePage homePage;
  AccountPage accountPage;

  @Test
  public void openNewAccountTest() {
    homePage = new HomePage();
    homePage.login().openNewAccount();
    accountPage = new AccountPage();
    String actualMessage = accountPage.getSuccessOpenAccountMessage();
    myUtils.customWait(1);
    Assert.assertEquals(actualMessage, "Congratulations, your account is now open.");
  }
}
