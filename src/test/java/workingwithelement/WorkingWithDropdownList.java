package workingwithelement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class WorkingWithDropdownList {
	ChromeDriver driver ;

	@BeforeTest
	public void openURL()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+("\\resources\\chromedriver.exe"));
		driver= new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
	}
	@Test
	public void testDropdownList() throws InterruptedException{
		WebElement optionList = driver.findElementById("dropdown");	
		Select SelectOptions = new Select(optionList);
		Assert.assertFalse(SelectOptions.isMultiple());
		Assert.assertEquals(3, SelectOptions.getOptions().size());
		//SelectOptions.selectByVisibleText("Option 2");
		SelectOptions.selectByValue("2");
		Thread.sleep(2000);
	}
	@AfterTest
	public void closeDriver1 ()
	{

		driver.quit();
	}
}
