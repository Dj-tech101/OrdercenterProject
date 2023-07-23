package raynor;

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

public class Validate_stainlessStell_fieldPrice {

	

	@Test(dataProvider = "test")
	public void Valiadate_the_Width(String date, String quantity, String width, String height, String winndowQuntity,
			String logoHeight, String additionalcable, String doorNumber) throws InterruptedException {

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

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// js.executeScript("arguments[0].value='mahesh@sstsoftwareservices.com';",
		// username);

		//
//			Thread.sleep(3000);
//			WebElement pass=driver.findElement(By.xpath("//input[@placeholder='Password']"));
//			js.executeScript("arguments[0].value='Admin@123';", pass);
		//
//			Thread.sleep(2000);

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

		 Thread.sleep(2000);

		// MOTOR COVER COLOR

		driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[11]")).click();

		// Thread.sleep(1000);

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

		 Thread.sleep(2000);

		 
		 int calculatedValue=Integer.parseInt(height);
		 int actualValue=calculatedValue/12;
		 double finalCal=actualValue*75.60;
		 
		 
		 
		 String value=String.valueOf(finalCal);
		 
		 System.out.println(value);
		 
		 WebElement elementDetail=driver.findElement(By.xpath("//td[contains(text(),'"+value+"')]"));
		
		 System.err.println(elementDetail.getText());
		
		
		
	}
	@DataProvider(name = "test")
	public Object[][] testDatta() {
		return new Object[][] {

			
			//String date, String quantity, String width, String height, String winndowQuntity,
			//String logoHeight, String additionalcable, String doorNumber
				{ "06-23-2024", "23", "58", "60", "2", "40", "2", "12" } };

	}
}
