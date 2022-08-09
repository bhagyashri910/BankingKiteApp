package KiteTestApp;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import basePackage.Base;
import kiteAppPOM.KiteAppLogin;
import kiteAppPOM.KiteHomePage;
import kiteAppPOM.KitePinPage;
import utilityPackage.Utility;

//@Listeners(listener.Listener.class)
public class KiteTestingClass extends Base{
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
  public void loginApp() throws EncryptedDocumentException, IOException
  {
	  login.enterUserID(Utility.readingExcelSheet(0, 0));
	  login.enterPassword(Utility.readingExcelSheet(0, 1));
	  login.clickOnLoginButton();
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
	  pin.enterPin(Utility.readingExcelSheet(0, 2));
	  pin.clickOnContiniueButton();
	  
  }
  @Test
  public void validatingUserID() throws EncryptedDocumentException, IOException
  {
	 String expectedUserID = Utility.readingExcelSheet(0, 0);
	 String actualUserID = home.validateUserID();
	 //Assert.assertEquals(actualUserID, expectedUserID,"actual and expected are not matching");
	 SoftAssert s=new SoftAssert();
	 s.assertEquals(actualUserID, expectedUserID);
	 s.assertAll();
	 
  }
  @AfterMethod
  public void logoutApp() throws InterruptedException
  {
	  home.loggingOut();
  }
  @AfterClass
  public void closedBrowser()
  {
	  clossingBrowser();
  }
}
