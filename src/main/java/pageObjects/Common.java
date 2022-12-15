package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class Common extends Base {
	
	//HomePageObjects hp;
	
	
	public Common() {
		PageFactory.initElements(driver, this);
	}
	
	public void sleep(int num) {
		int miliseconds = num *1000;
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	public void print(String txt) {
		System.out.println(txt);
	}
	
	public void scrollTo(WebElement el) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);",el);
		
	}
	
	

}
