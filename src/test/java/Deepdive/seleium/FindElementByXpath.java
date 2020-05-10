package Deepdive.seleium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByXpath {
	ChromeDriver driver ;

	@BeforeTest
	public void openURL()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+("\\resources\\chromedriver.exe"));
		driver= new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");}

	@Test

	public void findElementByRelativeXpath()
	{
		//WebElement usernametxt =driver.findElementByXPath("//input");
		WebElement passwordtxt =driver.findElementByXPath("//input[@id='password']");
	//	WebElement loginbtn = driver.findElementByXPath("//button");
			WebElement loginbtn = driver.findElementByXPath("//button[@class='radius']");

		//System.out.println(usernametxt.getTagName());
		System.out.println(passwordtxt.getTagName());
		System.out.println(loginbtn.getTagName());
	}
	@Test(enabled = false)

	public void findElementByAbsolutXpath()
	{
		WebElement usernametxt =driver.findElementByXPath("//*[@id=\"username\"]");
		WebElement passwordtxt =driver.findElementByXPath("//*[@id=\"password\"]");
		WebElement loginbtn = driver.findElementByXPath("//*[@id=\"login\"]/button/i");

		System.out.println(usernametxt.getTagName());
		System.out.println(passwordtxt.getTagName());
		System.out.println(loginbtn.getTagName());


	}

	@AfterTest
	public void closeDriver1 ()
	{

		driver.quit();
	}






}