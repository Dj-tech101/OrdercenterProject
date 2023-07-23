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

public class Validate_Door_Opening_Height extends Baseclass {

	public loginPage login;
	public Dashboard dashboard;
	public orderCenter ordercenterPage;
	public orderCenterProducts orderCenterProductspage;
	public addProductDetails add;

	public test415 asi;

	@Test(dataProvider = "test")
	public void Validate_Door_openening_width(String date, String model, String doorqty, String width,String height, String value) throws InterruptedException {

		asi = new test415(driver);

		asi.DateFormateSend(date);

		asi.clickonModel(model);

		asi.modelSelection(model);

		asi.doorQuantitySendkey(doorqty);

		asi.doorWidthSendkey(width);
		
		asi.doorHeightsendkeys(height);

		asi.clickOnSubmitButton();

		if (value.equalsIgnoreCase("valid")) {

			System.out.println("test case is pass");

			Assert.assertTrue(true);

		} else {
			
			double number=Double.parseDouble(height);
			
			if (height.contains(".")&&!(number>168)&&!(number<48)) {

				if (!width.contains(".25") && !height.contains(".75") && !height.contains(".50")
						&& !height.contains(".00")) {

					String actualDecimalError = asi.geterrorMessageForDecimalValueHeight();

					String expecteddecimal = "Please enter valid decimal value (.00, .25, .50, .75)";

					System.out.println("decimal error message " + actualDecimalError);
					Assert.assertEquals(actualDecimalError, expecteddecimal);

				} else {
					System.out.println("test case is pass");

					Assert.assertTrue(true);

				}

			}
			else if (height.contains("(*&^%$#@!--")) {
				String Actualerror = asi.geterrorMessageSpecialCharacterHeight();

				System.out.println("The actual message is  " + Actualerror);

				String expectederror = "Please enter a valid DOOR OPENING HEIGHT";
				Assert.assertEquals(Actualerror, expectederror, "message is not display ");

			}
			
			else {
				String Actualerror = asi.geterrorMessageHight();

				System.out.println("The actual message is for invalid height:- "+height +"  "+ Actualerror);

				
				String expectederror = "Please enter a value between 48 and 168";
				Assert.assertEquals(Actualerror, expectederror, "message is not display ");

			}
		}
	}

	@DataProvider(name = "test")
	public String[][] data() throws EncryptedDocumentException, IOException {

		String path = "C:\\Users\\webca\\OneDrive\\Desktop\\AsiTestData\\Door opening Height.xlsx";

		DataProviderName data = new DataProviderName(path);

		return data.getdataProvider(path);

	}
}
