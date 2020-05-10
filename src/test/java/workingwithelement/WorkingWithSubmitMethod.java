package workingwithelement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithSubmitMethod {
	ChromeDriver driver ;

	@BeforeTest
	public void openURL()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+("\\resources\\chromedriver.exe"));
		driver= new ChromeDriver();
		driver.navigate().to("https://www.google.com");
	}
	@Test
	public void testSubmit () {
		
		WebElement txtSearch =driver.findElementByName("q");
		txtSearch.clear();
		txtSearch.sendKeys("selenium webdriver");
		txtSearch.submit();
		
		
		
	}
	@AfterTest
	public void closeDriver1 ()
	{

		driver.quit();
	}

}
