package demo_TestCases_on_ASI;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hpsf.Decimal;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.google.common.math.Quantiles;

import AsiPages.test415;
import BaseClass.Baseclass;
import XlutilityPackage.DataProviderName;
import pages.Dashboard;
import pages.addProductDetails;
import pages.loginPage;
import pages.orderCenter;
import pages.orderCenterProducts;

public class Verify_Door_Quantity extends Baseclass {

	
	

	public loginPage login;
	public Dashboard dashboard;
	public orderCenter ordercenterPage;
	public orderCenterProducts orderCenterProductspage;
	public addProductDetails add;

	public test415 asi;
	
	@Test(dataProvider = "test")
	public void Verify_door_quantity_valid_value(String date,String model,String doorqty,String value) throws InterruptedException {
		asi= new test415(driver);
		
		asi.DateFormateSend(date);
		
		asi.clickonModel(model);
		
		asi.modelSelection(model);
		
		asi.doorQuantitySendkey(doorqty);
		
		asi.clickOnSubmitButton();
		
		
		
		
		
		
		
		if (value.equalsIgnoreCase("valid")) {
			
			System.out.println("test case is pass");
			
			Assert.assertTrue(true);
		}
		
		
		else if (doorqty.contains(".")) {
			
			String actualDecimalError=asi.geterrorMessageForDecimal();
			
			String expecteddecimal="Please enter numbers only (without decimal)";
			
			System.out.println( "decimal error message "+actualDecimalError);
			Assert.assertEquals(actualDecimalError, expecteddecimal);
			
			
			
		}
		
		else {
			
			String Actualerror=asi.getErrorMessageDoorQuantity();
			
			System.out.println("The actual message is  "+Actualerror);
			;
			String expectederror="Please enter value greater than or equal to 1";
			Assert.assertEquals(Actualerror, expectederror, "message is not display ");
		
			
		}
		
	}
	
	@DataProvider(name = "test")
	public String[][] data() throws EncryptedDocumentException, IOException {
		
		String path="C:\\Users\\webca\\OneDrive\\Desktop\\AsiTestData\\door quantity.xlsx";
		
		DataProviderName data= new DataProviderName(path);
		
		 return data.getdataProvider(path);
		
		
		  
		  
				  
	}
}
