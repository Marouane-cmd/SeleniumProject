package workingwithelements2;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestScrollToBottomOfPage {
	public WebDriver  driver;
	@BeforeClass
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+("\\resources\\chromedriver.exe"));
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.amazon.de");

	}
	@Test
	public void testScrollWithJs() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,4500)");
		Thread.sleep(3000);
		WebElement amazonLogo = driver.findElement(By.cssSelector("div.nav-logo-base.nav-sprite"));
		Assert.assertTrue(amazonLogo.isDisplayed());
	}
	@AfterClass
	public void TearDown () {

		driver.quit();
	}
}
