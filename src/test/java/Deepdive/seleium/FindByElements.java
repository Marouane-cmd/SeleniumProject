package Deepdive.seleium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindByElements {
	ChromeDriver driver ;

	@BeforeTest
	public void openURL()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+("\\resources\\chromedriver.exe"));
		driver= new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/");
	}

	@Test
	public void testFindElements()
	{
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
        Assert.assertEquals(46, links.size());
        for (WebElement link: links ) {
        	System.out.println(link.getAttribute("href"));
			
		}
	}
	@AfterTest
	public void closeDriver ()
	{

		driver.quit();
	}
}



