package workingwithelements2;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestUpoladFileUsingRobot {
	public WebDriver  driver;

	@BeforeClass
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+("\\resources\\chromedriver.exe"));
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://the-internet.herokuapp.com/upload");
	}  
	@Test
	public void FileUploadWithRobot() throws AWTException, InterruptedException
	{
		String ImageName = "Marwan.jpg";
		String ImagePath = System.getProperty("user.dir")+"\\Uploads\\"+ImageName;	
		WebElement filUploader = driver.findElement(By.id("file-upload"));
		filUploader.click();
		
		//code using robot class for file upload
		Robot robot = new Robot();
		// CONTROL +C copy image path
		StringSelection selection= new StringSelection(ImagePath);
		Clipboard clipboard =Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection, null);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(2000);
		//click on control+v
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);

		
		WebElement fileSubmit = driver.findElement(By.id("file-submit"));
		fileSubmit.click();
		WebElement uploadedFiles = driver.findElement(By.id("uploaded-files"));
		System.out.println(uploadedFiles.getText());
		Assert.assertEquals(ImageName,uploadedFiles.getText()); 
	}
	@AfterClass
	public void TearDown () {

		driver.quit();
	}
}
