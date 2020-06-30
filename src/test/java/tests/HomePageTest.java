package tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.Base;

public class HomePageTest extends Base {



  HomePage homePage;

  @Test
  public void loginTest(){
     homePage = new HomePage();
    homePage.login();
    System.out.println("successfully login");
  }







}
