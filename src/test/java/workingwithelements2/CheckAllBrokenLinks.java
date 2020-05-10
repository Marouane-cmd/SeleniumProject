package workingwithelements2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckAllBrokenLinks {
	public WebDriver  driver;
	@BeforeClass
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+("\\resources\\chromedriver.exe"));
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://the-internet.herokuapp.com/");

	}
	@Test
	public void testBrokenLinks()
	{
     List<WebElement> links= driver.findElements(By.tagName("a"));
     System.out.println("Total links are :"+ links.size());
     for(int i= 0 ; i<links.size(); i++) 
     {
    	 WebElement element = links.get(i);
    	 String url = element.getAttribute("href");
    	 verifyLink(url);
     }
	}
	public static void verifyLink(String urllink) 
	{
		try {
			URL link = new URL(urllink);
			// Create a connection using URL object
			HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
			httpConn.setConnectTimeout(2000);
			httpConn.connect();
			// use getResponseCode to get the response code
			if (httpConn.getResponseCode()==200) 
			{
			System.out.println(urllink+" - "+httpConn.getResponseMessage());	
			}
			if(httpConn.getResponseCode()==400) 
			{
				System.out.println(urllink+" - "+httpConn.getResponseMessage());
			}
		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	@AfterClass
	public void TearDown () {

		driver.quit();
	}
}
