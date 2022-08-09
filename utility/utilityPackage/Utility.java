package utilityPackage;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility 
{
public static String readingExcelSheet(int indexOfRow,int indexOfCell) throws EncryptedDocumentException, IOException
{
	FileInputStream myFile=new FileInputStream("D:\\SELENIUM folder of SW\\excelTest.xlsx");
	Sheet sheet = WorkbookFactory.create(myFile).getSheet("Sheet14");
	String value = sheet.getRow(indexOfRow).getCell(indexOfCell).getStringCellValue();
	return value;
}
}
