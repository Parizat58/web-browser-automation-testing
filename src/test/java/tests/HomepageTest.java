package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Homepage;
import utils.Base;

public class HomepageTest extends Base {

  private Homepage page = new Homepage(driver);

  @Test
  public void testLogin(){
     page.login();
     eyesUtils.validateWindow();
  }
}
