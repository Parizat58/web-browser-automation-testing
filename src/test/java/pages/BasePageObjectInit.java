package pages;

import org.openqa.selenium.support.PageFactory;
import utils.Base;

public class BasePageObjectInit extends Base {

  public BasePageObjectInit(){
    PageFactory.initElements(driver, this);
  }
}
