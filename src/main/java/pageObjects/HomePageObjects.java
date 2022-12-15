package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Base;

public class HomePageObjects extends Base {

	//Web elemenst locators Home page
	
	@FindBy(xpath = "//a[@href=\"/login\"]")
	@CacheLookup
	public WebElement loginTopMenuLink;
	
	@FindBy(id = "susbscribe_email")
	public WebElement subscriptionField;
	
	@FindBy(id = "success-subscribe")
	public WebElement successSubsriptionMsg;
	
	@FindBy(id = "subscribe")
	public WebElement arrowBtn;
	
	@FindBy(xpath = "//a[@href='/products']")
	WebElement productsLink;
	
	@FindBy(xpath = "//li/a[@href='/view_cart']")
	WebElement cartLinkTopMenu;
	
	@FindBy(xpath = "//a[contains(text(),'Test Cases')]")
	WebElement testCasesLinkTopMenu;
	
	@FindBy(xpath = "//a[normalize-space()='API Testing']")
	WebElement apiTestingLinkTopMenu;
	
	@FindBy(xpath = "//p[@class='pull-left']")
	public WebElement copyright;
	
	
	//Init
	public HomePageObjects() {
		PageFactory.initElements(driver, this);
	}
	
	//Methods realted to home page
	
	
	public void navigateToLoginPage() {
		loginTopMenuLink.click();
	}
	
	public void navigateToProductsPage() {
		productsLink.click();
		Assert.assertEquals(driver.getTitle(), "Automation Exercise - All Products");
	}
	
	
	
	
}
