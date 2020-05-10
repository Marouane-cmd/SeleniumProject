package workingwithelements2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DownloadFileWithFireFoxOptions {
	public WebDriver  driver;
    public static String DownloadPath = System.getProperty("user+dir")+"/Downloads";
	@BeforeClass
	public void SetUp() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+("\\resources\\geckodriver.exe"));
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://the-internet.herokuapp.com/download");
}
	@Test
	public void TestDownloadFile() 
	{
		
	}
	@AfterClass
	public void TearDown () {

		driver.quit();
	}
}