package workingwithelements2;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestJavaScript {
	public WebDriver  driver;
	@BeforeClass
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+("\\resources\\chromedriver.exe"));
		driver= new ChromeDriver();
		driver.navigate().to("https://www.google.com");
		driver.manage().window().maximize();

	}
	@Test
	public void testJavaSacript() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String title = (String) js.executeScript("return document.title");
		assertEquals("Google", title);
		System.out.println(title);
		long links = (Long) js.executeScript("var links=document.getElementsByTagName('A'); return links.length");
		System.out.println(links);
		assertEquals(20, links);
	}
	@AfterClass
	public void TearDown () {

		driver.quit();
	}

}
