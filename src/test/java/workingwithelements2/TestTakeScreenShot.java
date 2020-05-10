package workingwithelements2;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.xml.XmlSuite.FailurePolicy;

import io.netty.handler.codec.http.multipart.FileUpload;
import kotlin.Result.Failure;

public class TestTakeScreenShot {
	public WebDriver  driver;
	@BeforeClass
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+("\\resources\\chromedriver.exe"));
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.amazon.de");

	}
	@Test
	public void testScreenShotOnFailure() 
	{
		WebElement search = driver.findElement(By.id("twotabsearchtextboxxx"));
		search.sendKeys("Selenium Webdriver Book");
		search.submit();
		assertTrue(driver.getTitle().contains("Selenium"));
	}
	@AfterMethod
	public void TakeScreenShot(ITestResult result) throws IOException {
		if (ITestResult.FAILURE==result.getStatus()) {
			//f  Create reference of TakeScreenShot
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./Screenshot/"+result.getName()+".png"));
		}	
	}
	@AfterClass
	public void TearDown () {

		driver.quit();
	}
}
