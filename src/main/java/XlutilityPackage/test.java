package XlutilityPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class test  extends check{

	@Test(dataProvider ="test1" )
	public void Str(String test,String v2,String v3,String v4) {
		
	   
			   
		System.out.println(test);
	}
	
	
	@DataProvider(name = "test1")
	public String[][] name() throws EncryptedDocumentException, IOException {
		
		
		String path="C:\\Users\\webca\\OneDrive\\Desktop\\AsiTestData\\door quantity - Copy.xlsx";
		
		
		DataProviderName d= new DataProviderName(path);
		
		
		return d.getdataProvider(path);
		
}
}