package raynor;

import java.text.DecimalFormat;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class validate_vision_screen {

	@Test(dataProvider = "test")
	public void Vision_price(String date, String quantity, String width, String height, String winndowQuntity,
			String logoHeight, String additionalcable, String doorNumber, String windowquantity)
			throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://test.dockproductsordercenter.com/pricing-portal#/model/14/20");

		driver.manage().window().maximize();
		Thread.sleep(3000);

		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		WebElement username = driver
				.findElement(By.xpath("//input[@name='username' and  @placeholder='Email Address']"));

		// username.sendKeys("mahesh@sstsoftwareservices.com",Keys.DOWN.TAB);
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.sendKeys(username, "mahesh@sstsoftwareservices.com");
		act.keyDown(Keys.TAB).sendKeys("Admin@123").build().perform();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// js.executeScript("arguments[0].value='mahesh@sstsoftwareservices.com';",
		// username);

		//
//				Thread.sleep(3000);
//				WebElement pass=driver.findElement(By.xpath("//input[@placeholder='Password']"));
//				js.executeScript("arguments[0].value='Admin@123';", pass);
		//
//				Thread.sleep(2000);

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

		// model dropdown
		Thread.sleep(1000);

		Actions clciking = new Actions(driver);

		clciking.click(driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])"))).build().perform();

		Thread.sleep(1000);

		wait.until(
				ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//li[contains(text(),'RC100')]"))))
				.click();

		// Thread.sleep(500);

		// quantity field

		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(quantity);

		// SPF dripdown
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[2]")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[contains(text(),'No')]")).click();

		Thread.sleep(1000);

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

		 Thread.sleep(500);

		// OPERATOR LOCATION

		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[4]")).click();

		 Thread.sleep(1000);

		driver.findElement(By.xpath("//li[contains(text(),'Left')]")).click(); // Right

		// Thread.sleep(2000);

//		// FIRST PHOTOCELL HEIGHT dropdown
//
//		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[5]")).click();
//
//		// Thread.sleep(1000);
//
//		driver.findElement(By.xpath("//li[contains(text(),'6\"')]")).click(); // Right
//
//		// Thread.sleep(2000);
//
//		// CURTAIN FABRIC COLOR dropdown
//
//		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[6]")).click();
//
//		Thread.sleep(1000);
//
//		driver.findElement(By.xpath("//li[contains(text(),'Yellow (RAL 1003)')]")).click(); // Right
//
//		Thread.sleep(1000);
//
//		// BOTTOM BAG CURTAIN COLOR
//
//		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[7]")).click();
//
//		Thread.sleep(1000);
//
//		driver.findElement(By.xpath("//li[contains(text(),'Yellow (RAL 1003)')]")).click();
//
//		// Right
//
//		Thread.sleep(2000);
//
//		// SIDE GUIDE COVER
//
//		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[8]")).click();
//
//		// Thread.sleep(1000);
//
//		driver.findElement(By.xpath("//li[contains(text(),'Powder Coated Steel')]")).click(); // Right
//
//		Thread.sleep(1000);
//
//		// SIDE GUIDE COVER COLOR
//
//		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[9]")).click();
//
//		Thread.sleep(1000);
//
//		driver.findElement(By.xpath("//li[contains(text(),'Yellow (RAL 1003)')]")).click(); // Right
//
//		Thread.sleep(1000);
//
//		// MOTOR COVER
//
//		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[10]")).click();
//
//		Thread.sleep(1000);
//
//		driver.findElement(By.xpath("//li[contains(text(),'Powder Coated Steel')]")).click(); // Right
//
//		Thread.sleep(1000);
//
//		// MOTOR COVER COLOR
//
//		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[11]")).click();
//
//		// Thread.sleep(1000);
//
//		driver.findElement(By.xpath("//li[contains(text(),'Orange (RAL 2004)')]")).click(); // Right
//
//		Thread.sleep(1000);
//
//		// DRUM HOOD/DRUM FASCIA dropdown
//
//		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[12]")).click();
//
//		Thread.sleep(500);
//
//		driver.findElement(By.xpath("//li[contains(text(),'Powder Coated Steel Drum Hood')]")).click(); // Right
//
//		Thread.sleep(1000);
//
//		// DRUM HOOD/DRUM FASCIA COLOR
//
//		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[13]")).click();
//
//		Thread.sleep(1000);
//
//		driver.findElement(By.xpath("//li[contains(text(),'Yellow (RAL 1003)')]")).click(); // Right
//
//		// Thread.sleep(1000);
//
//		// STAINLESS STEEL INNER & OUTER SIDE GUIDES dropdown
//
//		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[14]")).click();
//
////			Thread.sleep(1000);
//
//		driver.findElement(By.xpath("//li[contains(text(),'Yes')]")).click(); // Right
//
//		// Thread.sleep(2000);
//
//		// STAINLESS STEEL SHAFT DRUMS & BEARINGS dropdown
//
//		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[15]")).click();
//
//		// Thread.sleep(1000);
//
//		driver.findElement(By.xpath("//li[contains(text(),'Yes')]")).click(); // Right
//
////			Thread.sleep(1000);
//
//		// SLT STAINLESS HEAD COMPONENTS dropdown
//
//		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[17]")).click();
//
//		 Thread.sleep(2000);
//
//		driver.findElement(By.xpath("//li[contains(text(),'Yes')]")).click(); // Right
//
//		 Thread.sleep(1000);
//
//		// DOOR STYLE dropdown
//
//		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[18]")).click();
//
//		Thread.sleep(1000);
//
//		driver.findElement(By.xpath("//li[contains(text(),'Slim Line Techno')]")).click(); // Right
//
//		Thread.sleep(2000);
//
//		// HEAVY IMPACT ZONE dropdown
//
//		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[23]")).click();
//
//		Thread.sleep(1000);
//
//		driver.findElement(By.xpath("//li[contains(text(),'Yes')]")).click(); // Right
//
//		// Thread.sleep(1000);
//
//		// MANUAL CHAIN HOIST dropdown
//
//		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[24]")).click();
//
//		Thread.sleep(1000);
//
//		driver.findElement(By.xpath("//li[contains(text(),'Yes')]")).click(); // Right
//
//		// Thread.sleep(1000);
//
//		// WDD BOTTOM SEAL HOUSING dropdown
//
//		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[25]")).click();
//
//		Thread.sleep(1000);
//
//		driver.findElement(By.xpath("//li[contains(text(),'Yes')]")).click(); // Right
//
//		 Thread.sleep(500);
//
//		// FORE FRAME dropdown
//
//		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[26]")).click();
//
//		Thread.sleep(1000);
//
//		driver.findElement(By.xpath("//li[contains(text(),'Painted Black')]")).click(); // Right
//
		Thread.sleep(1000);
//
//		// window quantity

		driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys(winndowQuntity);

		// VISION AND SCREENdropdown
		
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[32]")).click();

		Thread.sleep(2000);

		String option1 = "Bug Screen Banner 60\" X Door Width";
		String option2 = "Bug Screen Window 24\" X 24\" Mesh";
		String option3 = "Vision Banner 15\" X Door Width PVC";
		String option4 = "Vision Banner 31\" X 8` Segment";
		String option5 = "Vision Banner 15\" X Door Width Amber";
		String option6 = "Vision Banner Vertical from Ground";
		String option7 = "Vision Panel 24\" X 24\" PVC";
		String option8 = "Vision Panel 24\" X 24\" Amber UV";
		String option9 = "None";

		int val = (3 * ((Integer.parseInt(windowquantity) - 1)));
		int qtyval = Integer.parseInt(quantity) * 24;

		System.out.println("for val   " + val);
		System.out.println("for qtyval   " + qtyval);

		double value = (Double.parseDouble(width) - (36 - (qtyval - val)));

		DecimalFormat defact = new DecimalFormat("0.00");

		String finalValue = defact.format(value);

		System.out.println(defact.format(value));

		if (Double.parseDouble(finalValue) >= 0) {

			driver.findElement(By.xpath("//li[contains(text(),'" + option2 + "')]")).click(); // Right

			// Thread.sleep(1000);
		}
	}

	@DataProvider(name = "test")
	public Object[][] testDatta() {
		return new Object[][] {

				// String date, String quantity, String width, String height, String
				// winndowQuntity,
				// String logoHeight, String additionalcable, String doorNumber
				{ "06-23-2024", "4", "1", "144", "2", "40", "2", "12", "5" } };

	}
}
