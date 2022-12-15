package lesson8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class NewTabWindow {
	

	WebDriver driver;
	
	@AfterMethod
	public void end() {
		//driver.quit();
	}
	
	@BeforeMethod
	public void s() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/");
		
	

	}
	
	
	@Test
	public void window() {
		String win1 = driver.getWindowHandle();
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.google.com/");
		Assert.assertEquals(driver.getTitle(), "Google");
		//
		driver.switchTo().window(win1);
		Assert.assertEquals(driver.getTitle(), "YouTube");
		driver.close();
	}

	
	

}
