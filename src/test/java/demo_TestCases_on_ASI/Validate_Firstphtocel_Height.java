package demo_TestCases_on_ASI;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AsiPages.test415;
import BaseClass.Baseclass;
import XlutilityPackage.DataProviderName;

public class Validate_Firstphtocel_Height extends Baseclass {

	public test415 asi;

	@Test(dataProvider = "test")
	public void Validate_Door_openening_width(String date, String model, String doorqty, String width, String height,
			String motorLocation, String firstPhotocellHeight, String value) throws InterruptedException {

		asi = new test415(driver);

		asi.DateFormateSend(date);

		asi.clickonModel(model);

		asi.modelSelection(model);

		asi.doorQuantitySendkey(doorqty);

		asi.doorWidthSendkey(width);

		asi.doorHeightsendkeys(height);

		asi.motorLocation(motorLocation);
		asi.motorLocationselection(motorLocation);

//		
//		asi.firstPhtocellHeght();
//		
//		asi.firstPhtocellHeghtselection(firstPhotocellHeight);
//		asi.clickOnSubmitButton();
//		

	}

	@Test(dependsOnMethods = "Validate_Door_openening_width")
	public void Validate_defoult_Value() {

		String Actualdefoultvalue = asi.getdefoultvalueFIRSTPHOTOCELL();
		String Expecteddefoultvalue = "12\"";

		Assert.assertEquals(Actualdefoultvalue, Expecteddefoultvalue);
	}

	@Test(dataProvider = "test", dependsOnMethods = "Validate_Door_openening_width")
	public void validate_The_selction(String date, String model, String doorqty, String width, String height,
			String motorLocation, String firstPhotocellHeight, String value) {

		asi.firstPhtocellHeght();
		asi.firstPhtocellHeghtselection(firstPhotocellHeight);
		String Actualdefoultvalue = asi.getdefoultvalueFIRSTPHOTOCELL();

		System.out.println("the selected value is  " + Actualdefoultvalue);
		String Expecteddefoultvalue = firstPhotocellHeight;

		Assert.assertEquals(Actualdefoultvalue, Expecteddefoultvalue);
	}

	@DataProvider(name = "test")
	public String[][] data() throws EncryptedDocumentException, IOException {

		String path = "C:\\Users\\webca\\OneDrive\\Desktop\\AsiTestData\\first photocell height.xlsx";

		DataProviderName data = new DataProviderName(path);

		return data.getdataProvider(path);

	}
}
