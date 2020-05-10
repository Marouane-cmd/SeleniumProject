package workingwithelement;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestMultipleWindows {
	ChromeDriver driver ;

	@BeforeTest
	public void openURL()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+("\\resources\\chromedriver.exe"));
		driver= new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Config.html");
	}
	@Test
	public void testWindowUsingTitle() {
		// Store windowHandle of parent window
		String CurrentWindow = driver.getWindowHandle();
		driver.findElement(By.id("visitbutton")).click();
		for(String WindowID :driver.getWindowHandles()) {
			String Title = driver.switchTo().window(WindowID).getTitle();
			if(Title.equals("Vist Us")){
				assertEquals("Vist Us", driver.getTitle());		
				System.out.println(driver.getTitle());
				driver.close();
				break;
			}
		}
		driver.switchTo().window(CurrentWindow);

	}
	@Test
	public void testWindowUsingName() {
		// Store windowHandle of parent window
		String CurrentWindow = driver.getWindowHandle();
		driver.findElement(By.id("helpbutton")).click();
		driver.switchTo().window("HelpWindow");
		assertEquals("Help", driver.getTitle());
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(CurrentWindow);
	}
	@AfterTest
	public void closeDriver1 ()
	{

		driver.quit();
	}
}
