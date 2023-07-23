package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClass.Baseclass;
import XlutilityPackage.xlutility;
import pages.Dashboard;
import pages.addProductDetails;
import pages.loginPage;
import pages.orderCenter;
import pages.orderCenterProducts;

public class testCase1 extends Baseclass {

	public loginPage login;
	public Dashboard dashboard;
	public orderCenter ordercenterPage;
	public orderCenterProducts orderCenterProductspage;
    public addProductDetails add;
    
	@Test
	public void test001() {

		login = new loginPage(driver);

		login.usernameSendKeys("mahesh@sstsoftwareservices.com");

		login.clickonTabKey("Admin@123");
		login.clickonSubmitButton();
	}

	@Test(dependsOnMethods = "test001")
	public void clcikOnordercenter() {

		dashboard = new Dashboard(driver);

		dashboard.clcikOnOrdercenterButton();

	}

	@Test(dependsOnMethods = "clcikOnordercenter")
	public void clickoneditButton() throws InterruptedException {

		ordercenterPage = new orderCenter(driver);

		ordercenterPage.ClickonEditBurton();
	}

	@Test(dependsOnMethods = "clickoneditButton")
	public void clickonRaynorButton() {
		orderCenterProductspage = new orderCenterProducts(driver);
		orderCenterProductspage.clcikOnRaynorbutton();

	}
	
	@Test(dataProvider = "test",dependsOnMethods = "clickonRaynorButton")
	public void validateTheRc100(String date,String model,String doorQuantity
			,String spf,String doorWidth,String doorHeight
			,String motarlocation,String firstPhotocell,String curtaincolore
			,String bottomCurtainColore,String sideGuideCover,String sideGuideCovercolore,String motorCover
			,String motorCovercolore,String drumFascia,String drumFasciacolore,String steelinnerOuterGuide
			,String steeldrumBearing,String heavyImpactZone,String manualChainHoist
			,String foreFrame,String visionAndScreen,String WindowQuantity
			,String logoAndPrintLocation,String logoAndPrintSize,String mechanicalHeightValue
			,String mechanicalWidth,String mechanicalfloor,String nonmechanicalheight
			,String nonmechanicalWidth,String nonmechanicalFloor,String controlPanel
			,String incomingPower,String additionalCable,String lineLoadReactor
			,String crating,String Doornumber) {
		
		
		
		add= new addProductDetails(driver);
	
		add.DateFormateSend(date);
	
		add.clickonModel();
		
		add.modelSelection(model);
	
		add.doorQuanntitysendkeys(doorQuantity);
		
		add.spfclick();
		
		
		add.spfSelection(spf);
		add.doorWidthSendKeys(doorWidth);
		
		add.doorHeightSendKeys(doorHeight);
		
		add.motorLocationClick();
		add.motarLocationSelection(motarlocation);
		
		add.firstPhotocellHeightClick();
		
		add.firstPhotocellHeightSelection(firstPhotocell);
		
		add.CurtainColoreclick();
		add.CurtainColoreselection(curtaincolore);
		
		add.bottomCurtainColoreclick();
		add.bottomCurtainColoreselection(bottomCurtainColore);
		
		add.sideGuideCoverclick();
		add.sideGuideCoverselection(sideGuideCover);
		
		add.sideGuideCovercoloreclick();
		add.sideGuideCovercoloreselection(sideGuideCovercolore);
		
		add.motorCoverclick();
		
		add.motarLocationSelection(motorCover);
		
		add.motorCovercoloreclick();
		add.motorCovercoloreselection(motorCovercolore);
		
		add.drumFasciaclick();
		add.drumFasciaSelection(drumFascia);
		
		add.drumFasciacoloreclick();
		
		add.drumFasciacoloreselection(drumFasciacolore);
		
		add.steelinnerOuterGuideclick();
		add.steelinnerOuterGuideselection(steelinnerOuterGuide);
		
		
		add.steeldrumBearingclick();
		add.steeldrumBearingselection(steeldrumBearing);
		
		
		add.heavyImpactZoneclick();
		add.heavyImpactZoneselection(heavyImpactZone);
		
		add.manualChainHoistclick();
		add.manualChainHoistselection(manualChainHoist);
		
		
		add.foreFrameclick();
		
		add.foreFrameselection(foreFrame);
		
		add.visionAndScreenclick();
		add.visionAndScreenselection(visionAndScreen);
		
		
		add.WindowQuantitysendkeys(WindowQuantity);
		
		add.logoAndPrintLocationclick();
		add.logoAndPrintLocationselection(logoAndPrintLocation);
		
		add.logoAndPrintSizeClick();
		add.logoAndPrintSizeselection(logoAndPrintSize);
		
		
		add.mechanicalHeightsendkeys(mechanicalHeightValue);
		
		
		add.mechanicalWidthsendkeys(mechanicalWidth);
		
		
		add.mechanicalfloorsendkeys(mechanicalfloor);
		
		add.nonmechanicalheightsendkeys(nonmechanicalheight);
		
		add.nonmechanicalWidthsendkeys(nonmechanicalWidth);
		
		
		add.nonmechanicalFloorsendkeys(nonmechanicalFloor);
		
		
		add.controlPanelclick();
		add.controlPanelselection(controlPanel);
		
		
		add.incomingPowerclick();
		add.incomingPowerSelection(incomingPower);
		
		add.additionalCablesendkeys(additionalCable);
		
		
		add.lineLoadReactorclick();
		add.lineLoadReactorselection(lineLoadReactor);
		
		add.cratingclick();
		add.cratingselection(crating);
		
		add.Doornumbersendkeys(Doornumber);
		
	}
	
	
	@DataProvider(name = "test")
	public String[][] testdata() throws EncryptedDocumentException, IOException {
		String path = "C:\\Users\\webca\\OneDrive\\Desktop\\rc.xlsx";

		xlutility xl;

		xl = new xlutility(path);

		int row = xl.getrow();
		int coloum = xl.getcoloumn();

		
		System.out.println("the count of row is  "+row);
		String[][] data = new String[row][coloum];

		for (int i = 1; i <=row; i++) {

			
			for (int j = 0; j < coloum; j++) {

				data[i - 1][j] = xl.getcellValue(i, j);

			}
		}

		return data;

		// String data[][]= new String[][];

	}
		
	
}
