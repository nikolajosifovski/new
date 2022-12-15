package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;  // main one

import org.openqa.selenium.JavascriptExecutor;

import base.Base;
import pageObjects.Common;
import pageObjects.HomePageObjects;
import testData.TestD;

public class HomePageTestCases extends Base {
	
	 HomePageObjects hp;
	 TestD testdata;
	 Common com;

	
	
	@BeforeMethod
	public void setup() {
		openApplication();
		hp = new HomePageObjects();
		testdata = new TestD();
		com = new Common();

	}
	
	@AfterMethod 
	public void teardown() throws InterruptedException{
		//Thread.sleep(3000);
		driver.quit();
		
	}
	
//******* Test Cases *************
	
	@Test
	public void verifySubscriptionInHomePage() {
		
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);",hp.subscriptionField);
		
		hp.subscriptionField.sendKeys("test1@mail.com");
		hp.arrowBtn.click();
		
		//Verify that email subscription message is dispalyed on Home page
		assertThat(hp.successSubsriptionMsg.isDisplayed());
		assertThat(hp.subscriptionField.getText().equals(testdata.expectedSubscriptionMsg));
	}
	@Test
	public void testSleep() {
		com.sleep(40);
		com.print("testing sleep method");
		
	}
	
	@Test
	public void testIf() {
		int qty = 11;
		
		if(qty < 4) {
			com.print("case 1");
		}
		else if (qty < 8) {
			com.print("case 2");
		}
		else {
			com.print("case 3");
		}
	}
	
	@Test
	public void testScrolling() {
		com.scrollTo(hp.subscriptionField);
		com.sleep(5);
		com.scrollTo(hp.loginTopMenuLink);
	}
	
	//
	
	//
	

}
