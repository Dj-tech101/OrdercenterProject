package raynor;

import java.time.Duration;
import java.util.Set;

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

public class date_Functionality {

	@Test(dataProvider = "test")
	public void verify_the_date_functionality(String date, String data) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://test.dockproductsordercenter.com/pricing-portal#/model/14/20");

		driver.manage().window().maximize();
		Thread.sleep(3000);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		WebElement username = driver
				.findElement(By.xpath("//input[@name='username' and  @placeholder='Email Address']"));

		// username.sendKeys("mahesh@sstsoftwareservices.com",Keys.DOWN.TAB);
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.sendKeys(username, "mahesh@sstsoftwareservices.com");
		act.keyDown(Keys.TAB).sendKeys("Admin@123").build().perform();

		driver.findElement(By.xpath("//span[contains(text(),'Submit')]")).click();
		Thread.sleep(2000);

		driver.navigate().to("https://test.dockproductsordercenter.com/order-center#/cart/649187a1d4148045bcbfdf8c");
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//button[@type='button'])[9]")).click();
		Thread.sleep(2000);

		WebElement dateformate = driver.findElement(By.xpath("//input[@placeholder='MM-DD-YYYY']"));

		dateformate.sendKeys(Keys.CONTROL + "a", Keys.DELETE);

		// act.sendKeys(dateformate, Keys.DOWN.BACK_SPACE).build().perform();

//		dateformate.sendKeys(Keys.CONTROL+"a");
//		dateformate.sendKeys(Keys.DELETE);
		Thread.sleep(2000);

		dateformate.sendKeys(date);

		Thread.sleep(2000);

		driver.findElement(By.xpath("(//span[contains(text(),'Submit')])[2]")).click();
Thread.sleep(2000);

		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//		String check="valid";
//		String check2="invalid";

		System.out.println(data);

		if (data.equalsIgnoreCase("valid")) {

			WebElement successMessage = wait.until(ExpectedConditions.visibilityOf(
					driver.findElement(By.xpath("//div[contains(text(),'Product updated successfully')]"))));

			String actualresult = successMessage.getText();

			String expectedResult = "Product updated successfully";

			Assert.assertEquals(actualresult, expectedResult, "message is not display");

		}

		else if (data.equalsIgnoreCase("invalid")) {

			// Thread.sleep(1000);
			String actualSubmissionError = driver
					.findElement(By.xpath("//div[contains(text(),'Please fill all required fields')]")).getText();

			String ExpectedResult = "Please fill all required fields";

			Assert.assertEquals(actualSubmissionError, ExpectedResult, "message for actual submission is not display");

			String Actualerrormessage = driver
					.findElement(By.xpath("//p[contains(text(),'Please enter a valid value.')]")).getText();

			String ExpectedErrorMessage = "Please enter a valid value.";

			// Assert.assertEquals(Actualerrormessage, ExpectedErrorMessage, "error message
			// is display");

		}

		driver.close();

	}

	@DataProvider(name = "test")
	public Object[][] testDatta() {
		return new Object[][] {

				{ "11-12-2024", "valid" },
				// { "00-00-2022","invalid"}

		};

	}
}
