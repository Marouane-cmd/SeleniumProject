package workingwithelements2;
import java.io.IOException;
import java.util.List;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.http.HttpResponse;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class CheckAllBrokenImages {
	public WebDriver  driver;
	private int InvalidImageCount;
	@BeforeClass
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+("\\resources\\chromedriver.exe"));
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://the-internet.herokuapp.com/broken_images");
	}  
	@Test
	public void CheckBrokenImages ()
	{
		InvalidImageCount=0;
		List<WebElement>imgList=driver.findElements(By.tagName("img"));
		for(WebElement imgElement: imgList) {
			if( imgElement!=null) {
				
				verifyImageActive(imgElement);
			}
		}
		System.out.println("Total of no. of invalid images:"+ InvalidImageCount);
	}
	public void verifyImageActive(WebElement imgElement)
	{
		org.apache.http.client.HttpClient client = org.apache.http.impl.client.HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(imgElement.getAttribute("src"));
		try {
			org.apache.http.HttpResponse response = client.execute(request);
			if (response.getStatusLine().getStatusCode() !=200) {
				InvalidImageCount++;
			}
		} catch (ClientProtocolException e) {

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
