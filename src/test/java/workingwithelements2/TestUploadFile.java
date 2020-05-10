package workingwithelements2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestUploadFile {
	public WebDriver  driver;

	@BeforeClass
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+("\\resources\\chromedriver.exe"));
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://the-internet.herokuapp.com/upload");
	}  
	@Test
	public void TestUploadFile() {
		String ImagName = "Marwan.jpg";
		String ImagePath = System.getProperty("user.dir")+"/Uploads/"+ImagName;	
		WebElement filUploader = driver.findElement(By.id("file-upload"));
		filUploader.sendKeys(ImagePath);
		WebElement fileSubmit = driver.findElement(By.id("file-submit"));
		fileSubmit.click();
		WebElement uploadedFiles = driver.findElement(By.id("uploaded-files"));
		System.out.println(uploadedFiles.getText());
		Assert.assertEquals(ImagName,uploadedFiles.getText());
	}


	@AfterClass
	public void TearDown () {

		driver.quit();
	}
}
