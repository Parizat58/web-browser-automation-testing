package tests;

import org.testng.annotations.Test;
import pages.EyesDemoPage;
import utils.Base;

public class EyesDemoPageTest extends Base {

  private EyesDemoPage page = new EyesDemoPage(driver);

  @Test(enabled = false)
  public void testLogin(){
     page.login();
     eyesTestManager.validateWindow();
  }

  @Test(enabled = false)
  public void searches(){
     page.clickHomePageIcon();
     eyesTestManager.validateElement(page.getHomepageIconLocator());
  }
}
