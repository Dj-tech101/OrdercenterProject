package finalRaynor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Verified_RaynorForm {
	@Test(dataProvider = "test")
	public void TestCase1(String date, String model, String Quantity, String width, String height, String option)
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

		driver.findElement(By.xpath("//span[contains(text(),'Submit')]")).click();
		Thread.sleep(2000);

		driver.navigate()
				.to("https://test.dockproductsordercenter.com/order-center#/products/649fd4021521dd41747f3403");
		
		driver.findElement(By.xpath("//p[contains(text(),'Raynor')]")).click();

//Date		

		driver.findElement(By.xpath("//input[@placeholder='MM-DD-YYYY']")).sendKeys(date);

		Thread.sleep(2000);

//select model		
		WebElement selectModel = driver.findElement(By.xpath("(//label[contains(text(),'Select')])[1]"));

		Actions as = new Actions(driver);

		as.click(selectModel).perform();

		// 
		WebElement SelectOptionModel = driver.findElement(By.xpath("//li[contains(text(),'" + model + "')]"));

		as.click(SelectOptionModel).perform();

		Thread.sleep(1000);

		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(Quantity);

		// Thread.sleep(2000);

//spf options		
		WebElement spf = driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[2]"));

		as.click(spf).perform();

		WebElement spfOptions = driver.findElement(By.xpath("//li[contains(text(),'No')]"));

		as.click(spfOptions).perform();

//width		
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(width);

//HEIGHT
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys(height);

//DOOR LOCATION

		WebElement DoorLocation = driver.findElement(By.xpath("(//label[contains(text(),'Select')])[3]"));

		as.click(DoorLocation).perform();

		WebElement Dooroptions = driver.findElement(By.xpath("//li[contains(text(),'Interior')]"));

		as.click(Dooroptions).perform();

//OPERATOR LOCATION

		Thread.sleep(1000);

		WebElement OPERATOR_LOCATION = driver.findElement(By.xpath("(//label[contains(text(),'Select')])[4]"));

		as.click(OPERATOR_LOCATION).perform();

		WebElement leftOption = driver.findElement(By.xpath("//li[contains(text(),'Left')]"));

		as.click(leftOption).perform();

//FIRST PHOTOCELL HEIGHT

//		WebElement PHOTOCELL_HEIGHT = driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[5]"));
//
//		as.click(OPERATOR_LOCATION).perform();
//
//		WebElement PHOTOCELLHEIGHTOPTIONS = driver.findElement(By.xpath("//li[contains(text(),'12\"')]"));
//
//		as.click(PHOTOCELLHEIGHTOPTIONS).perform();

//CURTAIN FABRIC COLOR

		
		Thread.sleep(2000);
		
		WebElement CURTAIN_FABRIC_COLOR = driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[6]"));

		as.click(CURTAIN_FABRIC_COLOR).perform();

		//js.executeScript("arguments[0].click();", CURTAIN_FABRIC_COLOR);
		
		WebElement CURTAIN_FABRIC_COLOR_OPTIONS = driver
				.findElement(By.xpath("//li[contains(text(),'Orange (RAL 2004)')]"));

		as.click(CURTAIN_FABRIC_COLOR_OPTIONS).perform();

//BOTTOM BAG CURTAIN COLOR


		WebElement BOTTOM_BAG_CURTAIN_COLOR = driver.findElement(By.xpath("(//label[contains(text(),'Select')])[3]"));
		
		js.executeScript("arguments[0].click();", BOTTOM_BAG_CURTAIN_COLOR);
		

	//	as.click(BOTTOM_BAG_CURTAIN_COLOR).perform();

		WebElement BOTTOM_BAG_CURTAIN_COLOR_OPTIONS = driver
				.findElement(By.xpath("//li[contains(text(),'Orange (RAL 2004)')]"));

		as.click(CURTAIN_FABRIC_COLOR_OPTIONS).perform();

//SIDE GUIDE COVER

		WebElement SIDE_GUIDE_COVER = driver.findElement(By.xpath("(//label[contains(text(),'Select')])[3]"));

		as.click(SIDE_GUIDE_COVER).perform();

		WebElement SIDE_GUIDE_COVER_OPTIONS = driver.findElement(By.xpath("//li[contains(text(),'" + option + "')]"));

		as.click(CURTAIN_FABRIC_COLOR_OPTIONS).perform();

	}

	@DataProvider(name = "test")
	public Object[][] testDatta() {
		return new Object[][] {

				{ "07-20-2023", "RC100", "10", "50", "50", "Powder Coated Steel" }

		};

	}
}
