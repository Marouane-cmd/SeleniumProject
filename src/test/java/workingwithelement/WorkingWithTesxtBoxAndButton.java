package workingwithelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithTesxtBoxAndButton {
	ChromeDriver driver ;

	@BeforeTest
	public void openURL()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+("\\resources\\chromedriver.exe"));
		driver= new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");
	}


	@Test
	public void LoginScreen ()
	{
		WebElement txtusername= driver.findElementById("username");
		WebElement txtpassword= driver.findElementById("password");
		WebElement btnlogin = driver.findElementByClassName("radius");

		txtusername.clear();
		txtusername.sendKeys("tomsmith");

		txtpassword.clear();
		txtpassword.sendKeys("SuperSecretPassword!");

		btnlogin.click();

		WebElement sucsessNotfication= driver.findElement(By.id("flash"));
		System.out.println(sucsessNotfication.getText());
		Assert.assertTrue(sucsessNotfication.getText().contains("You logged into a secure area!"));
	} 

	@AfterTest
	public void closeDriver1 ()
	{

		driver.quit();
	}

}
