package kiteAppPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteHomePage 
{
	@FindBy(xpath = "//span[@class='user-id']")private WebElement UserID;
	@FindBy(xpath = "//a[@target='_self']")private WebElement logOut;
	
	public KiteHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
   public String validateUserID()
   {
	  String actualUserID = UserID.getText();
	  return actualUserID;
   }
   public void loggingOut() throws InterruptedException
   {
	   UserID.click();
	   Thread.sleep(1000);
	   logOut.click();
   }
}
