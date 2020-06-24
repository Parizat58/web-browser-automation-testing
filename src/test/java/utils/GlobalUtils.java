package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class GlobalUtils extends Base {

  static final Logger logger = LoggerFactory.getLogger(Logger.class.getName());
  protected String currentTestName;
  private final String eyesAPIKey = System.getProperty("eyesAPIKey", "<DEFALT_KEY_HERE");
  private final Boolean disableEyes = Boolean.getBoolean("disableEyes");

  /**
   * To move file to another location It will delete file if it exists before moving it into
   *
   * @param file        the file to move
   * @param newLocation pathname to move the file to
   * @return successful or not
   */
  public static boolean moveFile(File file, String newLocation) {
    logger.info("moving file");
    File targetFile = new File(newLocation);
    if (targetFile.exists()) {
      targetFile.delete();
    }

    return file.renameTo(new File(newLocation));
  }

  public void setTestName(String testName) {
    currentTestName = testName;
  }


 /* public Eyes openEyes() throws Exception{
    if(null == eyes){
      eyes = new Eyes();
      eyes.setApiKey(eyesAPIKey);
      eyes.setIsDisabled(disableEyes);
      eyes.open(getDriver(), "Google Example", currentTestName);
    }
    return eyes;
  } */
}
