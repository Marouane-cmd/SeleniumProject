package workingwithelement;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestImplicitWait {
	ChromeDriver driver ;

	@BeforeTest
	public void openURL()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+("\\resources\\chromedriver.exe"));
		driver= new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/AjaxDemo.html");
		driver.manage().window().maximize();
	}
	@Test
	public void testImplicitlyWait() 
	{   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Page 4")).click();
		WebElement message = driver.findElement(By.id("page4"));
		assertTrue(message.getText().contains("Nunc nibh tortor"));
	}
	@AfterTest
	public void closeDriver1 ()
	{

		driver.quit();
	}
}
