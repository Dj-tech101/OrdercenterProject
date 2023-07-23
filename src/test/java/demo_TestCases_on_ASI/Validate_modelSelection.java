package demo_TestCases_on_ASI;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AsiPages.test415;
import BaseClass.Baseclass;
import XlutilityPackage.xlutility;
import pages.Dashboard;
import pages.addProductDetails;
import pages.loginPage;
import pages.orderCenter;
import pages.orderCenterProducts;

public class Validate_modelSelection extends Baseclass {

	public loginPage login;
	public Dashboard dashboard;
	public orderCenter ordercenterPage;
	public orderCenterProducts orderCenterProductspage;
	public addProductDetails add;

	public test415 asi1;

	@Test(dataProvider = "test",groups = {"Functional"})
	public void validateTheModelSelection(String date, String model, String value) throws InterruptedException {

		asi1 = new test415(driver);

		asi1.DateFormateSend(date);

		asi1.clickonModel(model);
		asi1.modelSelection(model);

		asi1.clickOnSubmitButton();

		
	if (value.equalsIgnoreCase("valid")) {

			System.out.println("test case is pass");
			assertTrue(true);

		} else {
		
		String message = asi1.getModelValidationMessage();
           System.out.println(message);
			String ExpectedMessage = "Please select MODEL";
			
			Assert.assertEquals(message, ExpectedMessage);
			//System.out.println("Error message is not display");
		}
		
		
	}

	@DataProvider(name = "test")
	public String[][] testdata() throws EncryptedDocumentException, IOException {
		String path = "C:\\Users\\webca\\OneDrive\\Desktop\\AsiTestData\\validate model selection.xlsx";

		xlutility xl;

		xl = new xlutility(path);

		int row = xl.getrow();
		int coloum = xl.getcoloumn();

		System.out.println("the count of row is  " + row);
		String[][] data = new String[row][coloum];

		for (int i = 1; i <= row; i++) {

			for (int j = 0; j < coloum; j++) {

				data[i - 1][j] = xl.getcellValue(i, j);

			}
		}

		return data;

		// String data[][]= new String[][];

	}

}
