package workingwithelement;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithCheckBoxes {
	ChromeDriver driver ;

	@BeforeTest
	public void openURL()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+("\\resources\\chromedriver.exe"));
		driver= new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");
	}
	@Test(enabled = false)
	public void testCheckBox() throws InterruptedException{
		WebElement check1 =driver.findElementByXPath("//*[@id=\"checkboxes\"]/input[1]");
		check1.click();
		Thread.sleep(5000);
		WebElement check2 =driver.findElementByXPath("//*[@id=\"checkboxes\"]/input[2]");
		if (check2.isSelected()) {
			check2.click();
		}
	}
	@Test 
	public void testIsElementPresent(){
		if (isElementPresent(By.xpath("//*[@id=\"checkboxes\"]/input[1]"))) {
			WebElement check1= driver.findElementByXPath("//*[@id=\"checkboxes\"]/input[1]");
			if (!check1.isSelected());{
				check1.click();
			}  
		} else {Assert.fail("Checkbox1 doesen't exist");

		}

	}
	private boolean isElementPresent(By by){
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}

	}
	@AfterTest
	public void closeDriver1 ()
	{

		driver.quit();
	}
}