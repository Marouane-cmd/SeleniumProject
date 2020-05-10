package workingwithelement;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestExplicitWait {
	ChromeDriver driver ;

	@BeforeTest
	public void openURL()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+("\\resources\\chromedriver.exe"));
		driver= new ChromeDriver();
		driver.navigate().to("http://www.google.com");
		driver.manage().window().maximize();
	}
	@Test
	public void testExplicitlyWait() 
	{  WebElement queryTxt =  driver.findElement(By.name("q"));
	             queryTxt.sendKeys("Selenium WebDriver");
	             queryTxt.submit();
	             WebDriverWait wait = new WebDriverWait(driver, 20);
	             wait.until(ExpectedConditions.titleContains("Selenium"));
	             assertTrue(driver.getTitle().toLowerCase().startsWith("selenium"));
	}
	@AfterTest
	public void closeDriver1 ()
	{

		driver.quit();
	}
}
