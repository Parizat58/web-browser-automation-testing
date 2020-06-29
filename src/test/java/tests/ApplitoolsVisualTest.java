package tests;

import org.testng.annotations.Test;
import pages.Homepage;
import utils.Base;

public class ApplitoolsVisualTest extends Base {

  private Homepage page = new Homepage(driver);

  @Test
  public void testLogin(){
     page.login();
     eyesTestManager.validateWindow();
  }

  @Test
  public void searches(){
     page.clickHomePageIcon();
     eyesTestManager.validateElement(page.getHomepageIconLocator());
  }
}
