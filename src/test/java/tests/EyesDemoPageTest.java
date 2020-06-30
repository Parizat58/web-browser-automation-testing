package tests;

import webElements.HomePageElements;
import org.testng.annotations.Test;
import pages.EyesDemoPage;
import utils.Base;

public class EyesDemoPageTest extends Base {

  private EyesDemoPage page;
  HomePageElements elements = new HomePageElements();

  @Test(enabled = false)
  public void testLogin(){
    page = new EyesDemoPage();
     page.login();
     eyesTestManager.validateWindow();
  }

  @Test(enabled = true)
  public void searches(){
    page = new EyesDemoPage();
     page.clickHomePageIcon();
     eyesTestManager.validateElement(page.getHomepageIconLocator());
  }
}
