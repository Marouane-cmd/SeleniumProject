package Deepdive.seleium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByClass {
	ChromeDriver driver ;

	@BeforeTest
	public void openURL()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+("\\resources\\chromedriver.exe"));
		driver= new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");}
	@Test

	public void findElementBy()
	{
			try {
				WebElement usernametext=	driver.findElement(By.name("username"));
				WebElement passwordtext=    driver.findElement(By.name("password"));
				WebElement loginbtn =       driver.findElementByClassName("radius");
				System.out.println(usernametext.getTagName());
				System.out.println(passwordtext.getTagName());
				System.out.println(loginbtn.getText());


			} catch (org.openqa.selenium.NoSuchElementException e) {
				System.out.println("The element is not found please try with another attribute");

			}
		
	}


	@AfterTest
	public void closeDriver ()
	{

		driver.quit();
	}




}
