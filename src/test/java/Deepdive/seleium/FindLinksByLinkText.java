package Deepdive.seleium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.page.model.NavigatedWithinDocument;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindLinksByLinkText {
	ChromeDriver driver ;

	@BeforeTest
	public void openURL()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+("\\resources\\chromedriver.exe"));
		driver= new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");}
	@Test
	public void FindByText() {

		WebElement seleniumLink= driver.findElementByLinkText("Elemental Selenium");
		System.out.println(seleniumLink.getAttribute("href"));
	}
	@AfterTest
	public void closeDriver()
	{ driver.quit();}

}
