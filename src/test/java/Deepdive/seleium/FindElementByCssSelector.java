package Deepdive.seleium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByCssSelector {
	ChromeDriver driver ;

	@BeforeTest
	public void openURL()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+("\\resources\\chromedriver.exe"));
		driver= new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");}
	@Test

	public void findElementByCssSelector()
	{   WebElement headerlbl = driver.findElementByCssSelector("h2");
		WebElement usernametxt =driver.findElementByCssSelector("input#username");
		WebElement passwordtxt =driver.findElementByCssSelector("input#password");

		WebElement LoginBtn = driver.findElementByCssSelector("button.radius");
		System.out.println(LoginBtn.getText());
		System.out.println( usernametxt.getTagName());
		System.out.println(passwordtxt.getTagName());
		System.out.println(headerlbl.getText());


	}


	@AfterTest
	public void closeDriver ()
	{

		driver.quit();
	}
}
