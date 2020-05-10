package workingwithelement;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCookies {
	ChromeDriver driver ;

	@BeforeTest
	public void openURL()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+("\\resources\\chromedriver.exe"));
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://magento-demo.lexiconn.com/");
	}
	@Test
	public void testCookies()  {
		WebElement selectLanguage = driver.findElement(By.id("select-language"));
		Select select = new Select(selectLanguage);
		Assert.assertEquals("English", select.getFirstSelectedOption().getText());
		Cookie storeCookies = driver.manage().getCookieNamed("store");
		Assert.assertEquals(null,storeCookies );
		// Select German Language
		select.selectByVisibleText("German");;
		// Store Cookie should be populated with selected country
		storeCookies=driver.manage().getCookieNamed("store");
		Assert.assertEquals("german", storeCookies.getValue());
		System.out.println(storeCookies.getValue());
		// Get all cookies
		Set<Cookie> Cookies= driver.manage().getCookies();
		System.out.println("Number of cookies: "+ Cookies.size());
		Iterator<Cookie> itr = Cookies.iterator();
		while(itr.hasNext()) {

			Cookie cookie = itr.next();
			System.out.println(cookie.getDomain());
			System.out.println(cookie.getName());
			System.out.println(cookie.getPath());
			System.out.println(cookie.getValue());
			System.out.println(cookie.getExpiry());

		}
	}
	@AfterTest
	public void closeDriver1 ()
	{

		driver.quit();
	}
}