package lesson6;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {
	
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
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/frames.html");
		
	

	}
	@Test
	public void testFrames() {
		
		driver.switchTo().frame("frame-body");
		String text1 = driver.findElement(By.xpath("//p[@class=\"lead\"]/b")).getText();
		System.out.println(text1);
	
	
	}
	@Test
	public void testParentFrame() {
		
		String frameBody = "frame-body";
		String frameFooter = "frame-footer";
		
		//switching to body frame
		driver.switchTo().frame("frame-body");
		String text1 = driver.findElement(By.xpath("//p[@class=\"lead\"]/b")).getText();
		System.out.println(text1);
	}
}
	/*	
		//switching to parent frame
		driver.switchTo().parentFrame();
		
		//switching to footer frame
		driver.switchTo().frame("frame-footer");
		String text2 = driver.findElement(By.xpath("class=\"text-muted\"")).getText();
		System.out.println(text2);
	}
*/

