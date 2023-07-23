package BaseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pages.Dashboard;
import pages.loginPage;
import pages.orderCenter;
import pages.orderCenterProducts;

public class Baseclass {

	
	public WebDriver driver;
	public WebDriverWait wait;
	public loginPage login;
	public Dashboard dashboard;
	public orderCenter ordercenterPage;
	public orderCenterProducts orderCenterProductspage;
	
	@BeforeMethod
	public void setup() throws InterruptedException {

		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();
		
		driver.get("https://test.dockproductsordercenter.com/#/");
		
		login = new loginPage(driver);

		login.usernameSendKeys("mahesh@sstsoftwareservices.com");

		login.clickonTabKey("Admin@123");
		login.clickonSubmitButton();
		
		dashboard = new Dashboard(driver);

		dashboard.clcikOnOrdercenterButton();
		
		ordercenterPage = new orderCenter(driver);

		ordercenterPage.ClickonEditBurton();
		orderCenterProductspage = new orderCenterProducts(driver);
		orderCenterProductspage.clickOnAsiButton();

		
	}

	@AfterMethod
	
	public void tearDown() {

		driver.close();
		
	}
}
