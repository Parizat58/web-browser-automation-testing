package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import utils.Base;

public class HomePageTest extends Base {

  HomePage homePage;

  @Test
  public void loginTest() {
    homePage = new HomePage();
    homePage.login();
    System.out.println("successfully login");
  }
}
