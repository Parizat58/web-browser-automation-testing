package tests;

import webElements.HomePageElements;
import org.testng.annotations.Test;
import pages.VisualTestingPage;
import utils.Base;

public class VisualTestingPageTest extends Base {

  private VisualTestingPage page;
  HomePageElements elements = new HomePageElements();

  @Test(enabled = false)
  public void testLogin(){
    page = new VisualTestingPage();
     page.login();
     eyesTestManager.validateWindow();
  }

  @Test(enabled = true)
  public void searches(){
    page = new VisualTestingPage();
     page.clickHomePageIcon();
     eyesTestManager.validateElement(page.getHomepageIconLocator());
  }
}
