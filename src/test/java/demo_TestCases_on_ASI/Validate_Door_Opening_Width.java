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

public class Validate_Door_Opening_Width extends Baseclass {

	public loginPage login;
	public Dashboard dashboard;
	public orderCenter ordercenterPage;
	public orderCenterProducts orderCenterProductspage;
	public addProductDetails add;

	public test415 asi;

	@Test(dataProvider = "test")
	public void Validate_Door_openening_width(String date, String model, String doorqty, String width, String value) throws InterruptedException {

		asi = new test415(driver);

		asi.DateFormateSend(date);

		asi.clickonModel(model);

		asi.modelSelection(model);

		asi.doorQuantitySendkey(doorqty);

		asi.doorWidthSendkey(width);

		asi.clickOnSubmitButton();

		if (value.equalsIgnoreCase("valid")) {

			System.out.println("test case is pass");

			Assert.assertTrue(true);

		} else {
			
			double number=Double.parseDouble(width);
			
			if (width.contains(".")&&!(number>144)&&!(number<36)) {

				if (!width.contains(".25") && !width.contains(".75") && !width.contains(".50")
						&& !width.contains(".00")) {

					String actualDecimalError = asi.geterrorMessageForDecimalValue();

					String expecteddecimal = "Please enter valid decimal value (.00, .25, .50, .75)";

					System.out.println("decimal error message " + actualDecimalError);
					Assert.assertEquals(actualDecimalError, expecteddecimal);

				} else {
					System.out.println("test case is pass");

					Assert.assertTrue(true);

				}

			} else {
				String Actualerror = asi.geterrorMessageWidth();

				System.out.println("The actual message is  " + Actualerror);

				String expectederror = "Please enter a value between 36 and 144";
				Assert.assertEquals(Actualerror, expectederror, "message is not display ");

			}
		}
	}

	@DataProvider(name = "test")
	public String[][] data() throws EncryptedDocumentException, IOException {

		String path = "C:\\Users\\webca\\OneDrive\\Desktop\\AsiTestData\\Door opening width.xlsx";

		DataProviderName data = new DataProviderName(path);

		return data.getdataProvider(path);

	}
}
