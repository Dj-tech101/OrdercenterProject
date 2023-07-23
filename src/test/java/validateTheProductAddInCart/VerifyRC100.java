package validateTheProductAddInCart;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import XlutilityPackage.xlutility;

public class VerifyRC100 {

	@Test(dataProvider = "test")
	public void Valiadate_the_Width(String date, String model, String quantity, String width, String height,
			String winndowQuntity, String additionalcable, String additionalcable2, String additionalcable3,
			String additionalcable4, String additionalcable5, String additionalcable6, String additionalcable7,
			String doorNumber) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://test.dockproductsordercenter.com/pricing-portal#/model/14/20");

		driver.manage().window().maximize();
		Thread.sleep(3000);

		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		WebElement username = driver
				.findElement(By.xpath("//input[@name='username' and  @placeholder='Email Address']"));

		// username.sendKeys("mahesh@sstsoftwareservices.com",Keys.DOWN.TAB);
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.sendKeys(username, "mahesh@sstsoftwareservices.com");
		act.keyDown(Keys.TAB).sendKeys("Admin@123").build().perform();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		driver.findElement(By.xpath("//span[contains(text(),'Submit')]")).click();
		Thread.sleep(2000);

		driver.navigate()
				.to("https://test.dockproductsordercenter.com/order-center#/products/649187a1d4148045bcbfdf8c");
		// Thread.sleep(2000);

		WebElement raynor = driver.findElement(By.xpath("//p[contains(text(),'Raynor')]"));

		js.executeScript("arguments[0].scrollIntoView(true);", raynor);

		raynor.click();

		Thread.sleep(1000);

		WebElement dateformate = driver.findElement(By.xpath("//input[@placeholder='MM-DD-YYYY']"));

		dateformate.sendKeys(date);
		// Thread.sleep(1000);

		System.out.println(date);
		// model dropdown
		Thread.sleep(1000);

		Actions clciking = new Actions(driver);

		clciking.click(driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])"))).build().perform();


		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//li[contains(text()," + "'" + model + "'" + ")]"))))

				.click();

		Thread.sleep(1000);

		// quantity field

		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(quantity);

		// SPF dripdown
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[2]")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[contains(text(),'No')]")).click();

		// DOOR OPENING WIDTH field
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(width);
		Thread.sleep(1000);

		// DOOR OPENING HEIGHT

		driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys(height);
		// Thread.sleep(1000);

		// DOOR LOCATION

		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[3]")).click();

		// Thread.sleep(1000);

		driver.findElement(By.xpath("//li[contains(text(),'Interior')]")).click();

		// Thread.sleep(500);

		// OPERATOR LOCATION

		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[4]")).click();

		// Thread.sleep(1000);

		driver.findElement(By.xpath("//li[contains(text(),'Left')]")).click(); // Right

		// Thread.sleep(2000);

		// FIRST PHOTOCELL HEIGHT dropdown

		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[5]")).click();

		// Thread.sleep(1000);

		driver.findElement(By.xpath("//li[contains(text(),'6\"')]")).click(); // Right

		// Thread.sleep(2000);

		// CURTAIN FABRIC COLOR dropdown

		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[6]")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//li[contains(text(),'Yellow (RAL 1003)')]")).click(); // Right

		Thread.sleep(1000);

		// BOTTOM BAG CURTAIN COLOR

		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[7]")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//li[contains(text(),'Yellow (RAL 1003)')]")).click();

		// Right

		Thread.sleep(2000);

		// SIDE GUIDE COVER

		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[8]")).click();

		// Thread.sleep(1000);

		driver.findElement(By.xpath("//li[contains(text(),'Powder Coated Steel')]")).click(); // Right

		Thread.sleep(1000);

		// SIDE GUIDE COVER COLOR

		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[9]")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//li[contains(text(),'Yellow (RAL 1003)')]")).click(); // Right

		Thread.sleep(1000);

		// MOTOR COVER

		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[10]")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//li[contains(text(),'Powder Coated Steel')]")).click(); // Right

		Thread.sleep(1000);

		// MOTOR COVER COLOR

		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[11]")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//li[contains(text(),'Orange (RAL 2004)')]")).click(); // Right

		Thread.sleep(1000);

		// DRUM HOOD/DRUM FASCIA dropdown

		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[12]")).click();

		Thread.sleep(500);

		driver.findElement(By.xpath("//li[contains(text(),'Powder Coated Steel Drum Hood')]")).click(); // Right

		Thread.sleep(1000);

//DRUM HOOD/DRUM FASCIA COLOR

		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[13]")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//li[contains(text(),'Yellow (RAL 1003)')]")).click(); // Right

		// Thread.sleep(1000);

//STAINLESS STEEL INNER & OUTER SIDE GUIDES dropdown

		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[14]")).click();

//		Thread.sleep(1000);

		driver.findElement(By.xpath("//li[contains(text(),'Yes')]")).click(); // Right

		// Thread.sleep(2000);

//STAINLESS STEEL SHAFT DRUMS & BEARINGS dropdown

		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[15]")).click();

		// Thread.sleep(1000);

		driver.findElement(By.xpath("//li[contains(text(),'Yes')]")).click(); // Right
		// HEAVY IMPACT ZONE dropdown

		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[16]")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//li[contains(text(),'Yes')]")).click(); // Right

		// Thread.sleep(1000);

		// MANUAL CHAIN HOIST dropdown

		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[17]")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//li[contains(text(),'Yes')]")).click(); // Right

		// Thread.sleep(1000);

		// FORE FRAME dropdown

		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[18]")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//li[contains(text(),'Painted Black')]")).click(); // Right

		// Thread.sleep(1000);

		// VISION AND SCREENdropdown

		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[19]")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//li[contains(text(),'Vision Banner 15\" X Door Width PVC')]")).click(); // Right

		// Thread.sleep(1000);

		// WINDOW QUANTITY field

		driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys(winndowQuntity);

		// LOGO AND PRINT LOCATION dropdown

		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[20]")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//li[contains(text(),'Mechanical Side')]")).click(); // Right

		// Thread.sleep(1000);

		// LOGO AND PRINT SIZE dropdown

		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[21]")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//li[contains(text(),'Logo up to 36 sq. ft (Max. 96\")')]")).click(); // Right

		Thread.sleep(500);
		// MECHANICAL SIDE LOGO HEIGHT (INCHES)

		driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys(additionalcable);

		// MECHANICAL SIDE LOGO WIDTH (INCHES)

		driver.findElement(By.xpath("(//input[@type='text'])[7]")).sendKeys(additionalcable2);

		// MECHANICAL SIDE LOGO FROM FLOOR (INCHES)

		driver.findElement(By.xpath("(//input[@type='text'])[8]")).sendKeys(additionalcable3);

		// NON-MECHANICAL SIDE LOGO HEIGHT (INCHES)

		driver.findElement(By.xpath("(//input[@type='text'])[9]")).sendKeys(additionalcable4);

		// NON-MECHANICAL SIDE LOGO WIDTH (INCHES)

		driver.findElement(By.xpath("(//input[@type='text'])[10]")).sendKeys(additionalcable5);

		// NON-MECHANICAL SIDE LOGO FROM FLOOR (INCHES)

		driver.findElement(By.xpath("(//input[@type='text'])[11]")).sendKeys(additionalcable6);

		// CONTROL PANEL dropdown

		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[22]")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//li[contains(text(),'NEMA 4X (Composite 14\" X 16\") w/o disconnect')]")).click(); // Right

		Thread.sleep(1000);

		// INCOMING POWER dropdown

		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[23]")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//li[contains(text(),'208V/1')]")).click(); // Right

		Thread.sleep(1000);

		// ADDITIONAL CABLES (FEET)

		driver.findElement(By.xpath("(//input[@type='text'])[12]")).sendKeys(additionalcable7);

		// LINE LOAD REACTOR dropdown

		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[24]")).click();

		Thread.sleep(1000);
		WebElement loadoptions = driver.findElement(By.xpath("//li[contains(text(),'None')]"));
		;
		Actions acty = new Actions(driver);
		acty.click(loadoptions).build().perform();

		// Thread.sleep(1000);

		// CRATING dropdown

		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[25]")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//li[contains(text(),'Wood Shipping Crate')]")).click(); // Right

		// Thread.sleep(1000);

		// DOOR NUMBER ###) field

		driver.findElement(By.xpath("(//input[@type='text'])[13]")).sendKeys(doorNumber);

		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[contains(text(),'Submit')]")).click();

		Thread.sleep(4000);

		js.executeScript("window.scrollBy(0,-250)", "");

		driver.findElement(By.xpath("//span[contains(text(),'Cart')]")).click();

		List<WebElement> modelName =driver.findElements(By.xpath("//table/tbody/tr/td"));
		
		for (int i = 0; i < modelName.size(); i++) {
			
			
			String actualName=modelName.get(i).getText();
			
			
			if (actualName.equalsIgnoreCase(model)) {
				
				Assert.assertTrue(true);
			}
			else {
				System.out.println(model+"  model is not created");
			}
		}
	
	}

	@DataProvider(name = "test")
	public String[][] testDatta() throws Exception {

		String path = "C:\\Users\\webca\\OneDrive\\Desktop\\new.xlsx";

		xlutility xl;

		xl = new xlutility(path);

		int row = xl.getrow();
		int coloum = xl.getcoloumn();

		String[][] data = new String[row][coloum];

		for (int i = 1; i <= row; i++) {

			
			Thread.sleep(1000);
			for (int j = 0; j < coloum; j++) {

				data[i - 1][j] = xl.getcellValue(i, j);

			}
		}

		return data;

		// String data[][]= new String[][];

	}
}