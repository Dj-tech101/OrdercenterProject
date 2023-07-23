package demo_TestCases_on_ASI;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AsiPages.test415;
import BaseClass.Baseclass;
import XlutilityPackage.DataProviderName;

public class Validate_curtain_fabric_colore extends Baseclass {

	public test415 asi;

	@Test(dataProvider = "test")
	public void Validate_curtain_fabric_colorelist(String date, String model, String doorqty, String width,
			String height, String motorLocation, String firstPhotocellHeight, String FabricColore, String value)
			throws InterruptedException {

		asi = new test415(driver);

		asi.DateFormateSend(date);

		asi.clickonModel(model);

		asi.modelSelection(model);

		asi.doorQuantitySendkey(doorqty);

		asi.doorWidthSendkey(width);

		asi.doorHeightsendkeys(height);

		asi.motorLocation(motorLocation);
		asi.motorLocationselection(motorLocation);

		asi.firstPhtocellHeght();

		asi.firstPhtocellHeghtselection(firstPhotocellHeight);

		asi.CurtainFabricColore(FabricColore);

		List<String> coloreCollection;

		if (value.equalsIgnoreCase("valid")) {

			coloreCollection = asi.getCurtainFabricColorelist();

			boolean checkOption = coloreCollection.contains(FabricColore);

			Assert.assertTrue(checkOption);

		} else {
			System.out.println("option is not present in list");
		}

	}

	@Test(dataProvider = "test")
	public void ValidatetheErrorMessageforInvalidOptions(String date, String model, String doorqty, String width,
			String height, String motorLocation, String firstPhotocellHeight, String FabricColore, String value)
			throws InterruptedException {
		asi = new test415(driver);

		asi.DateFormateSend(date);

		asi.clickonModel(model);

		asi.clickOnSubmitButton();

		if (value.equalsIgnoreCase("invalid")) {

			String actualRe = asi.getErrorMessagecurtainFabricColore();

			String expectedRe = "992592";

			Assert.assertEquals(actualRe, expectedRe);
		}

	}

	public void ValidateSelectedoption(String date, String model, String doorqty, String width, String height,
			String motorLocation, String firstPhotocellHeight, String FabricColore, String value)
			throws InterruptedException {
		asi = new test415(driver);

		asi.DateFormateSend(date);

		asi.clickonModel(model);

		asi.modelSelection(model);

		asi.doorQuantitySendkey(doorqty);

		asi.doorWidthSendkey(width);

		asi.doorHeightsendkeys(height);

		asi.motorLocation(motorLocation);
		asi.motorLocationselection(motorLocation);

		asi.firstPhtocellHeght();

		asi.firstPhtocellHeghtselection(firstPhotocellHeight);

		asi.CurtainFabricColore(FabricColore);

		asi.CurtainFabricColoreselection(FabricColore);

		if (value.equalsIgnoreCase("valid")) {

			String text = asi.getdefoultdefoultValueCUTAINFABRICCOLORE();

			String expected = FabricColore;

			Assert.assertEquals(text, expected);

		}
	}

	@DataProvider(name = "test")
	public String[][] data() throws EncryptedDocumentException, IOException {

		String path = "C:\\Users\\webca\\OneDrive\\Desktop\\AsiTestData\\first photocell height.xlsx";

		DataProviderName data = new DataProviderName(path);

		return data.getdataProvider(path);

	}
}
