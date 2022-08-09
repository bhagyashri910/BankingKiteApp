package basePackage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilityPackage.UtilityUsingPropertyFile;


public class Base
{
   protected static WebDriver driver;
	public void launchBrowser() throws IOException {
WebDriverManager.chromedriver().setup();
 driver=new ChromeDriver();
driver.get("https://kite.zerodha.com/");
// driver.get(UtilityUsingPropertyFile.readDataFromPropertyfile("URL"));
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
Reporter.log("Launching browser successfully",true);
}
	public void clossingBrowser()
	{
		driver.close();
		Reporter.log("clossing the browser successfully",true);
	}
	public void takeScreenShot(String TCName) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("D:\\Myscreenshot\\TC"+TCName+".png");
		FileHandler.copy(src, dest);
	}
}