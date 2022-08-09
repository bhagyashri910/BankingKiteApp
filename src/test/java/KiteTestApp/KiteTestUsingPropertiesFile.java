package KiteTestApp;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import basePackage.Base;
import kiteAppPOM.KiteAppLogin;
import kiteAppPOM.KiteHomePage;
import kiteAppPOM.KitePinPage;

import utilityPackage.UtilityUsingPropertyFile;

public class KiteTestUsingPropertiesFile extends Base{
	 KiteAppLogin login;  
	KitePinPage pin;
	KiteHomePage home;
  @BeforeClass
  public void openingBrowser() throws IOException
  {
	  launchBrowser();
	  
	   login=new KiteAppLogin(driver);
	   pin=new KitePinPage(driver);
	   home=new KiteHomePage(driver);
	  
  }
  @BeforeMethod
  public void openeningApp() throws EncryptedDocumentException, IOException
  {
	  login.enterUserID(UtilityUsingPropertyFile.readDataFromPropertyfile("UID"));
	  login.enterPassword(UtilityUsingPropertyFile.readDataFromPropertyfile("PWD"));
	  login.clickOnLoginButton();
	  
	  pin.enterPin(UtilityUsingPropertyFile.readDataFromPropertyfile("PIN"));
	  pin.clickOnContiniueButton();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000));
  }
  @Test
  public void validatingUserID() throws IOException
  {
	  String actualUserId = home.validateUserID();
	  String expectedUserId = UtilityUsingPropertyFile.readDataFromPropertyfile("UID");
	  SoftAssert s=new SoftAssert();
	  s.assertEquals(actualUserId, expectedUserId);
	  s.assertAll();
  }
  @AfterMethod
  public void logOutApp() throws InterruptedException
  {
	  home.loggingOut();
  }
  @AfterClass
  public void closeBrowser()
  {
	  clossingBrowser();
  }
}
