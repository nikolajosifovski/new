package lesson5;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Waits {
	
	WebDriver driver;
	
	@BeforeMethod
	public void s() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/dynamic-properties");

	}
	
	@Test
	public void testImplictWait() {
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String buttonText =  driver.findElement(By.id("visibleAfter")).getText();
		Assert.assertEquals(buttonText, "Visible After 5 Seconds");
		driver.quit();
	}
	
	@Test
	public void testExplicitWait() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
		
		String buttonText =  driver.findElement(By.id("visibleAfter")).getText();
		Assert.assertEquals(buttonText, "Visible After 5 Seconds");
		
		driver.close();
		
		
		
	}

}
