package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {
	
	WebDriver driver;
	
	@AfterMethod
	public void end() {
		driver.quit();
	}
	
	@BeforeMethod
	public void s() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");
		
	

	}
	@Test
	public void testAlert() {
		driver.findElement(By.id("my-alert")).click();
		String textAlert = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		
		Assert.assertEquals(textAlert, "Hello world!");
	}
	@Test
	public void testConfirmAlert() {
		driver.findElement(By.id("my-confirm")).click();
		driver.switchTo().alert().accept();
		
		
		String txt = driver.findElement(By.id("confirm-text")).getText();
		Assert.assertEquals(txt, "You chose: true");
		
		driver.findElement(By.id("my-confirm")).click();
		driver.switchTo().alert().dismiss();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		}
		@Test
		public void testPrompt() throws InterruptedException{
			driver.findElement(By.id("my-prompt")).click();
			driver.switchTo().alert().sendKeys("test1");
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
		
	}

}
