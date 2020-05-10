package workingwithelement;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithConfirmAlert {
	ChromeDriver driver ;

	@BeforeTest
	public void openURL()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+("\\resources\\chromedriver.exe"));
		driver= new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Alerts.html");
	}
	@Test
	public void testConfirmAlert() throws InterruptedException {
		WebElement confirmBtn = driver.findElement(By.id("confirm"));
		confirmBtn.click();
		Alert alert =driver.switchTo().alert();
		Thread.sleep(3000);

		alert.accept();
		Thread.sleep(3000);
		WebElement message = driver.findElement(By.id("demo"));
		Assert.assertEquals("You Accepted Alert!",message.getText());

	}
	@Test
	public void testDismissAlert() throws InterruptedException {
		WebElement dismissBtn = driver.findElement(By.id("confirm"));
		dismissBtn.click();
		Alert alert =driver.switchTo().alert();
		Thread.sleep(3000);

		alert.dismiss();
		Thread.sleep(3000);
		WebElement message = driver.findElement(By.id("demo"));
		Assert.assertEquals("You Dismissed Alert!",message.getText());

	}
	@AfterTest
	public void closeDriver1 ()
	{

		driver.quit();
	}

}

