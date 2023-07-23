package demo_TestCases_on_ASI;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AsiPages.test415;
import BaseClass.Baseclass;
import XlutilityPackage.DataProviderName;
import pages.Dashboard;
import pages.addProductDetails;
import pages.loginPage;
import pages.orderCenter;
import pages.orderCenterProducts;

public class Validate_motorLocation extends Baseclass {

	public loginPage login;
	public Dashboard dashboard;
	public orderCenter ordercenterPage;
	public orderCenterProducts orderCenterProductspage;
	public addProductDetails add;

	public test415 asi;

	@Test(dataProvider = "test")
	public void Validate_Door_openening_width(String date, String model, String doorqty, String width,String height,String motorLocation,String value) throws InterruptedException {

		asi = new test415(driver);

		asi.DateFormateSend(date);

		asi.clickonModel(model);

		asi.modelSelection(model);

		asi.doorQuantitySendkey(doorqty);

		asi.doorWidthSendkey(width);
		
		asi.doorHeightsendkeys(height);
		
		asi.motorLocation(motorLocation);
		asi.motorLocationselection(motorLocation);

		asi.clickOnSubmitButton();
		
		if (value.equalsIgnoreCase("valid")) {
			
			System.out.println("Valid option selected");
			Assert.assertTrue(true);
		}
		else {
			
			System.out.println("invalid option selected as NULL");
			
			String actualR=asi.getErrorMessageForMotorLocation();
			String actualRe="Please select MOTOR LOCATION";
			
			Assert.assertEquals(actualRe, actualR, "null value");
		}

	}

	@DataProvider(name = "test")
	public String[][] data() throws EncryptedDocumentException, IOException {

		String path = "C:\\Users\\webca\\OneDrive\\Desktop\\AsiTestData\\motorLocation.xlsx";

		DataProviderName data = new DataProviderName(path);

		return data.getdataProvider(path);

	}
}
