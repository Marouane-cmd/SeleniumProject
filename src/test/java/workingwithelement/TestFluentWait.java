package workingwithelement;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestFluentWait {
	ChromeDriver driver ;

	@BeforeTest
	public void openURL()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+("\\resources\\chromedriver.exe"));
		driver= new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/AjaxDemo.html");
		driver.manage().window().maximize();
	}
	@Test
	public void testFluentyWait() 
	{   driver.findElement(By.linkText("Page 4")).click();
	
     	Wait<WebDriver> Fwait =new FluentWait<WebDriver>(driver)
     	
     	.withTimeout(Duration.ofSeconds(20))
     	.pollingEvery(Duration.ofSeconds(2))
     	.ignoring(NoSuchElementException.class);
     	WebElement message = Fwait.until(new Function<WebDriver, WebElement>() {
     		
     		public WebElement apply(WebDriver d) {
     			return d.findElement(By.id("page4"));
     		}
		});
     	assertTrue(message.getText().contains("Nunc nibh tortor"));
     	
     	
     	
     	
     	
     	     	
     	
     	
     	
	}
	@AfterTest
	public void closeDriver1 ()
	{

		driver.quit();
	}

}
