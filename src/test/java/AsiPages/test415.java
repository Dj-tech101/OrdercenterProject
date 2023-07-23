package AsiPages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.xml.sax.Locator;

public class test415 {

	public WebDriver driver;

	public JavascriptExecutor js;
	public Actions act;

	public WebDriverWait wait;

	public test415(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

//	locato
//	
//	public void waituntillallelement(Locator l1) {
//		
//		WebDriverWait w1= new WebDriverWait(driver, Duration.ofSeconds(50));
//		
//		w1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(null))
//	}

	// Submit button

	@FindBy(xpath = "//span[contains(text(),'Submit')]")
	WebElement SubmitButton;

	public void clickOnSubmitButton() {

		js = (JavascriptExecutor) driver;

//		WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));
//		;

		js.executeScript("arguments[0].scrollIntoView(true);", SubmitButton);

		WebDriverWait waitbutton = new WebDriverWait(driver, Duration.ofSeconds(400));

		waitbutton.until(ExpectedConditions.elementToBeClickable(SubmitButton)).click();

		;

	}

//DateFormate

	@FindBy(xpath = "//input[@placeholder='MM-DD-YYYY']")
	WebElement dateFormate;

	public void DateFormateSend(String date) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(500));

		wait.until(ExpectedConditions.visibilityOf(dateFormate)).sendKeys(date);
	}

	// MODEL

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[1]")
	WebElement model;

	public void clickonModel(String value) throws InterruptedException {

		if (!value.equals("null")) {

			Actions act4 = new Actions(driver);

			Thread.sleep(2000);
			act4.moveToElement(model).click(model).build().perform();
			// wait.until(ExpectedConditions.elementToBeClickable(model)).click();
		}

		else {
			System.out.println("Please pass the model");
		}
	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> Modellist;

	// VALIDATION MESSAGE FOR MODEL
	@FindBy(xpath = "//p[contains(text(),'Please select MODEL')]")
	WebElement ModelErrorMessage;

	public String getModelValidationMessage() {
		js = (JavascriptExecutor) driver;

//		WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));
//		;

		js.executeScript("arguments[0].scrollIntoView(true);", ModelErrorMessage);

		return ModelErrorMessage.getText();

	}

	public void modelSelection(String model) {

		WebDriverWait selection = new WebDriverWait(driver, Duration.ofSeconds(25));

		for (int i = 0; i < Modellist.size(); i++) {

			String modelText = Modellist.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement e1 = Modellist.get(i);

				selection.until(ExpectedConditions.elementToBeClickable(e1)).click();

			}
		}

	}

	// DOOR QUANTITY

	@FindBy(xpath = "//p[contains(text(),'greater than or equal to 1')]")
	WebElement ErrorDoorQuantity;

	@FindBy(xpath = "//p[contains(text(),'Please enter numbers only (without decimal)')]")
	WebElement errorMessageForDecimal;

	public String geterrorMessageForDecimal() {
		js = (JavascriptExecutor) driver;

//		WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));
//			;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return errorMessageForDecimal.getText();

	}

	public String getErrorMessageDoorQuantity() {
		js = (JavascriptExecutor) driver;

//	WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));
//		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorDoorQuantity.getText();

	}

	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement doorQuantity;

	public void doorQuantitySendkey(String doorquantity) {

		wait.until(ExpectedConditions.visibilityOf(doorQuantity)).sendKeys(doorquantity);
		;

	}

	// SPF

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[2]")
	WebElement spf;

	public void spf() {

		wait.until(ExpectedConditions.elementToBeClickable(spf)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> spflist;

	public void spfselection(String model) {

		for (int i = 0; i < spflist.size(); i++) {

			String modelText = spflist.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				spflist.get(i).click();

			}
		}

	}

	// DOOR OPENING WIDTH

	@FindBy(xpath = "(//input[@type='text'])[3]")
	WebElement doorWidth;

	public void doorWidthSendkey(String date) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(500));

		wait.until(ExpectedConditions.visibilityOf(doorWidth)).sendKeys(date);
	}

	// VALIDATION MESSAGE FOR INVALID VALUE

	@FindBy(xpath = "//p[contains(text(),'Please enter a value between 36 and 144')]")
	WebElement errorMessageWidth;

	public String geterrorMessageWidth() {
		js = (JavascriptExecutor) driver;

//		WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));
//			;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return errorMessageWidth.getText();

	}

	//// VALIDATION MESSAGE FOR INVALID DECIMAL VALUE

	@FindBy(xpath = "//p[contains(text(),'Please enter valid decimal value (.00, .25, .50, .75)')]")
	WebElement errorMessageForDecimalValue;

	public String geterrorMessageForDecimalValue() {
		js = (JavascriptExecutor) driver;

//		WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return errorMessageForDecimalValue.getText();

	}

	// DOOR OPENING height

	@FindBy(xpath = "(//input[@type='text'])[4]")
	WebElement doorHeight;

	public void doorHeightsendkeys(String date) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(500));

		wait.until(ExpectedConditions.visibilityOf(doorHeight)).sendKeys(date);
	}
	// VALIDATION MESSAGE FOR INVALID VALUE

	@FindBy(xpath = "//p[contains(text(),'Please enter a value between 48 and 144')]")
	WebElement errorMessageHight;

	public String geterrorMessageHight() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));
//				;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return errorMessageHight.getText();

	}

	//// VALIDATION MESSAGE FOR INVALID DECIMAL VALUE

	@FindBy(xpath = "//p[contains(text(),'Please enter valid decimal value (.00, .25, .50, .75)')]")
	WebElement errorMessageForDecimalValueHeight;

	public String geterrorMessageForDecimalValueHeight() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return errorMessageForDecimalValueHeight.getText();

	}

	//// VALIDATION MESSAGE FOR SPECIAL CHARACTER

	@FindBy(xpath = "//p[contains(text(),'Please enter a valid DOOR OPENING HEIGHT')]")
	WebElement errorMessageSpecialCharacterHeight;

	public String geterrorMessageSpecialCharacterHeight() {
		js = (JavascriptExecutor) driver;

//				WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return errorMessageSpecialCharacterHeight.getText();

	}

	// MOTOR LOCATION

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[4]")
	WebElement motorLocation;

	public void motorLocation(String value) throws InterruptedException {
		if (!value.equals("null")) {

			Actions act5 = new Actions(driver);
			act5.moveToElement(motorLocation).click(motorLocation).build().perform();
		} else {
			System.out.println("null motor location");
		}
	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> motorLocationlist;

	public void motorLocationselection(String model) {

		for (int i = 0; i < motorLocationlist.size(); i++) {

			String modelText = motorLocationlist.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				act = new Actions(driver);
				act.moveToElement(motorLocationlist.get(i)).click(motorLocationlist.get(i)).build().perform();

			}
		}

	}
////VALIDATION MESSAGE FOR INVALID OPTION

	@FindBy(xpath = "//p[contains(text(),'Please select MOTOR LOCATION')]")
	WebElement ErrorMessageForMotorLocation;

	public String getErrorMessageForMotorLocation() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorMessageForMotorLocation.getText();

	}

	// FIRST PHOTOCELL HEIGHT

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[5]")
	WebElement firstPhtocellHeght;

	public void firstPhtocellHeght() {

		wait.until(ExpectedConditions.elementToBeClickable(firstPhtocellHeght)).click();

	}

	// DEFOULT VALUE

	public String getdefoultvalueFIRSTPHOTOCELL() {

		WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(40));

		String text = wait6.until(ExpectedConditions.visibilityOf(firstPhtocellHeght)).getText();

		// firstPhtocellHeght.getText();

		return text;

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> firstPhtocellHeghtlist;

	public void firstPhtocellHeghtselection(String model) {

		for (int i = 0; i < firstPhtocellHeghtlist.size(); i++) {

			String modelText = firstPhtocellHeghtlist.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele1 = firstPhtocellHeghtlist.get(i);

				act.moveToElement(ele1).click(ele1).build().perform();

			}
		}

	}

	// CURTAIN FABRIC COLOR

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[6]")
	WebElement CurtainFabricColore;

	public void CurtainFabricColore(String value) {

		if (!value.equals("null")) {
			wait.until(ExpectedConditions.elementToBeClickable(CurtainFabricColore)).click();

		}
		else {
			System.out.println("please pass the fabric colore");
		}

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> CurtainFabricColorelist;

	public List<String> getCurtainFabricColorelist() {
		List<String> l1 = new ArrayList<String>();

		for (int i = 0; i < CurtainFabricColorelist.size(); i++) {

			String text = CurtainFabricColorelist.get(i).getText();

			l1.add(text);

		}
		return l1;

	}

	public void CurtainFabricColoreselection(String model) {

		for (int i = 0; i < CurtainFabricColorelist.size(); i++) {

			String modelText = CurtainFabricColorelist.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele2 = CurtainFabricColorelist.get(i);

				act.moveToElement(ele2).click(ele2).build().perform();

			}
		}
	}
	
	public String getdefoultdefoultValueCUTAINFABRICCOLORE() {
		WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(40));

		String text = wait6.until(ExpectedConditions.visibilityOf(CurtainFabricColore)).getText();

		// firstPhtocellHeght.getText();

		return text;
	}
	
	
	@FindBy(xpath = "//table/tbody/tr[11]/td[3]")
	WebElement priceforCurtainFabricColore;
	
	public String getpriceforCurtainFabricColore() {
		
		
		String text=wait.until(ExpectedConditions.visibilityOf(priceforCurtainFabricColore)).getText();
		return text;
		
	}
////VALIDATION MESSAGE FOR INVALID OPTION

	@FindBy(xpath = "//p[contains(text(),'Please select MOTOR LOCATION')]")
	WebElement ErrorMessagecurtainFabricColore;

	public String getErrorMessagecurtainFabricColore() {
		js = (JavascriptExecutor) driver;

//			WebElement element = wait.until(ExpectedConditions.visibilityOf(ModelErrorMessage));		;

		js.executeScript("window.scrollBy(0,-3000)", "");

		return ErrorMessagecurtainFabricColore.getText();

	}
	// BOTTOM BAG CURTAIN COLOR

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[7]")
	WebElement bottomcurtainColore;

	public void bottomcurtainColore() {

		wait.until(ExpectedConditions.elementToBeClickable(bottomcurtainColore)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> bottomcurtainColorelist;

	public void bottomcurtainColoreselection(String model) {

		for (int i = 0; i < bottomcurtainColorelist.size(); i++) {

			String modelText = bottomcurtainColorelist.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = bottomcurtainColorelist.get(i);

				act.moveToElement(ele).click(ele).build().perform();

			}
		}

	}

	// Price BOTTOM BAG CURTAIN COLOR

	@FindBy(xpath = "//table/tbody/tr[12]/td[3]")
	WebElement priceBottombagCurtainColore;

	public String getPriceBottombagColore() {

		String priceValue = priceBottombagCurtainColore.getText();

		return priceValue;

	}

	// STAINLESS STEEL SHAFT DRUMS & BEARINGS

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[8]")
	WebElement stainlessSteelDrumBearing;

	public void stainlessSteelDrumBearing() {

		wait.until(ExpectedConditions.elementToBeClickable(stainlessSteelDrumBearing)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> stainlessSteelDrumBearinglist;

	public void stainlessSteelDrumBearingSelection(String model) {

		for (int i = 0; i < stainlessSteelDrumBearinglist.size(); i++) {

			String modelText = stainlessSteelDrumBearinglist.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = stainlessSteelDrumBearinglist.get(i);

				act.moveToElement(ele).click(ele).build().perform();

			}
		}

	}

	// PRICE STAINLESS STEEL SHAFT DRUMS & BEARINGS

	@FindBy(xpath = "//table/tbody/tr[13]/td[3]")
	WebElement pricestainlessSteelDrumBearing;

	public String getstainlessSteelDrumBearing() {

		String priceValue = pricestainlessSteelDrumBearing.getText();

		return priceValue;

	}

	// MANUAL CHAIN HOIST

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[10]")
	WebElement manualChainHoist;

	public void manualChainHoist() {

		wait.until(ExpectedConditions.elementToBeClickable(manualChainHoist)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> manualChainHoistList;

	public void manualChainHoistSelection(String model) {

		for (int i = 0; i < manualChainHoistList.size(); i++) {

			String modelText = manualChainHoistList.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = manualChainHoistList.get(i);

				act.moveToElement(ele).click(ele).build().perform();

			}
		}

	}

	// PRICE MANUAL CHAIN HOIST

	@FindBy(xpath = "//table/tbody/tr[15]/td[3]")
	WebElement pricemanualChainHoist;

	public String getpricemanualChainHoist() {

		String priceValue = pricemanualChainHoist.getText();

		return priceValue;

	}

	// ESCAPE SIDE GUIDES

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[11]")
	WebElement escapeGuide;

	public void escapeGuide() {

		wait.until(ExpectedConditions.elementToBeClickable(escapeGuide)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> escapeGuidelist;

	public void escapeGuideselection(String model) {

		for (int i = 0; i < escapeGuidelist.size(); i++) {

			String modelText = escapeGuidelist.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = escapeGuidelist.get(i);

				act.moveToElement(ele).click(ele).build().perform();

			}
		}

	}

	// PRICE ESCAPE SIDE GUIDES

	@FindBy(xpath = "//table/tbody/tr[16]/td[3]")
	WebElement priceescapeGuide;

	public String getpriceescapeGuide() {

		String priceValue = priceescapeGuide.getText();

		return priceValue;

	}

	// ADVANCED DOUBLE LIPPED

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[12]")
	WebElement advanceDoubleLipped;

	public void advanceDoubleLipped() {

		wait.until(ExpectedConditions.elementToBeClickable(advanceDoubleLipped)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> advanceDoubleLippedlist;

	public void advanceDoubleLippedselection(String model) {

		for (int i = 0; i < advanceDoubleLippedlist.size(); i++) {

			String modelText = advanceDoubleLippedlist.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = advanceDoubleLippedlist.get(i);

				act.moveToElement(ele).click(ele).build().perform();

			}
		}

	}

	// PRICE ADVANCED DOUBLE LIPPED

	@FindBy(xpath = "//table/tbody/tr[17]/td[3]")
	WebElement priceadvanceDoubleLipped;

	public String getpriceadvanceDoubleLipped() {

		String priceValue = priceadvanceDoubleLipped.getText();

		return priceValue;

	}

	// SLIMLINE SIDE PLATES

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[13]")
	WebElement slimlineSidePlates;

	public void slimlineSidePlates() {

		wait.until(ExpectedConditions.elementToBeClickable(slimlineSidePlates)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> slimlineSidePlateslist;

	public void slimlineSidePlatesselection(String model) {

		for (int i = 0; i < slimlineSidePlateslist.size(); i++) {

			String modelText = slimlineSidePlateslist.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = slimlineSidePlateslist.get(i);

				act.moveToElement(ele).click(ele).build().perform();

			}
		}

	}

	// PRICE SLIMLINE SIDE PLATES

	@FindBy(xpath = "//table/tbody/tr[18]/td[3]")
	WebElement priceslimlineSidePlates;

	public String getpriceslimlineSidePlates() {

		String priceValue = priceslimlineSidePlates.getText();

		return priceValue;

	}

	// VISION AND SCREEN

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[14]")
	WebElement visionandScreen;

	public void visionandScreen() {

		wait.until(ExpectedConditions.elementToBeClickable(visionandScreen)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> visionandScreenList;

	public void visionandScreenSelection(String model) {

		for (int i = 0; i < visionandScreenList.size(); i++) {

			String modelText = visionandScreenList.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = visionandScreenList.get(i);

				act.moveToElement(ele).click(ele).build().perform();

			}
		}

	}

	// PRICE VISION AND SCREEN

	@FindBy(xpath = "//table/tbody/tr[19]/td[3]")
	WebElement PricevisionandScreen;

	public String getPricevisionandScreen() {

		String priceValue = PricevisionandScreen.getText();

		return priceValue;

	}

	// WINDOW QUANTITY

	@FindBy(xpath = "(//input[@type='text'])[5]")
	WebElement windowQuantity;

	public void windowQuantitysendkey(String date) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(500));

		wait.until(ExpectedConditions.visibilityOf(windowQuantity)).sendKeys(date);
	}

	// LOGO AND PRINT LOCATION

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[15]")
	WebElement LogoAndPrintLocation;

	public void LogoAndPrintLocation() {

		wait.until(ExpectedConditions.elementToBeClickable(LogoAndPrintLocation)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> LogoAndPrintLocationList;

	public void LogoAndPrintLocationSelection(String model) {

		for (int i = 0; i < LogoAndPrintLocationList.size(); i++) {

			String modelText = LogoAndPrintLocationList.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = LogoAndPrintLocationList.get(i);

				act.moveToElement(ele).click(ele).build().perform();

			}
		}

	}

	// LOGOS AND PRINTS SIZE

	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[16]")
	WebElement logoAndPrintSize;

	public void logoAndPrintSizeLocation() {

		wait.until(ExpectedConditions.elementToBeClickable(logoAndPrintSize)).click();

	}

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> logoAndPrintSizeList;

	public void logoAndPrintSizeSelection(String model) {

		for (int i = 0; i < logoAndPrintSizeList.size(); i++) {

			String modelText = logoAndPrintSizeList.get(i).getText();

			if (modelText.equalsIgnoreCase(model)) {

				WebElement ele = logoAndPrintSizeList.get(i);

				act.moveToElement(ele).click(ele).build().perform();

			}
		}

	}

	// PRICE LOGOS AND PRINTS SIZE

	@FindBy(xpath = "//table/tbody/tr[22]/td[3]")
	WebElement pricelogoAndPrintSize;

	public String getpricelogoAndPrintSize() {

		String priceValue = pricelogoAndPrintSize.getText();

		return priceValue;

	}

	// MECHANICAL HEIGHT

	@FindBy(xpath = "(//input[@type='text'])[6]")
	WebElement mechanicalHeight;

	public void mechanicalHeightsendkey(String value) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(500));

		wait.until(ExpectedConditions.visibilityOf(mechanicalHeight)).sendKeys(value);
	}

	// MECHANICAL width

	@FindBy(xpath = "(//input[@type='text'])[7]")
	WebElement mechanicalWidth;

	public void mechanicalWidthsendkey(String value) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(500));

		wait.until(ExpectedConditions.visibilityOf(mechanicalWidth)).sendKeys(value);
	}

	// MECHANICAL FLOOR

	@FindBy(xpath = "(//input[@type='text'])[8]")
	WebElement mechanicalFloor;

	public void mechanicalFloorsendkey(String value) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(500));

		wait.until(ExpectedConditions.visibilityOf(mechanicalFloor)).sendKeys(value);
	}

	// NON-MECHANICAL Height

	@FindBy(xpath = "(//input[@type='text'])[9]")
	WebElement non_mechanicalheight;

	public void non_mechanicalHeightsendkey(String value) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(500));

		wait.until(ExpectedConditions.visibilityOf(non_mechanicalheight)).sendKeys(value);
	}

	// NON-MECHANICAL width

	@FindBy(xpath = "(//input[@type='text'])[10]")
	WebElement non_mechanicalHeight;

	public void non_mechanicalFloorsendkey(String value) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(500));

		wait.until(ExpectedConditions.visibilityOf(non_mechanicalHeight)).sendKeys(value);
	}

// NON-MECHANICAL FLOOR

	@FindBy(xpath = "(//input[@type='text'])[11]")
	WebElement non_mechanicalFloor;

	public void non_mechanicalFloorSendkey(String value) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(500));

		wait.until(ExpectedConditions.visibilityOf(non_mechanicalFloor)).sendKeys(value);
	}

	// CONTROL PANEL

}
