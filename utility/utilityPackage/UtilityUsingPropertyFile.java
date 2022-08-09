package utilityPackage;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class UtilityUsingPropertyFile
{
public static String readDataFromPropertyfile(String key) throws IOException
{
 Properties p=new Properties();
 FileInputStream myFile=new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\Banking\\properties");
 p.load(myFile);
  String value = p.getProperty(key);
return value;
		 
}
}