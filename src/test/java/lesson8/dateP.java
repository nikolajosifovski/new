package lesson8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dateP {
	
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
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
		
	

	}
	
	
	@Test
	public void selectDate() throws InterruptedException {
		
		WebElement el = driver.findElement(By.xpath("//input[@name='my-date']"));
		String current = el.getText();
		System.out.println(current);
		String date = "10/3/2023";
		el.sendKeys(date);
		
		Thread.sleep(3000);
		el.clear();
		///
		

}
}