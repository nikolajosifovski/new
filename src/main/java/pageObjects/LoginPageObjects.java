package pageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.Base;
import testData.TestD;

public class LoginPageObjects extends Base {
	
	TestD td = new TestD();
	
	@FindBy(xpath = "//input[@data-qa='login-email']")
	WebElement emailInputField;
	
	@FindBy(xpath = "//input[@placeholder='Password']") 
	WebElement passwordInputField;
	
	@FindBy(xpath = "//button[@data-qa='login-button']") 
	WebElement loginBtn; 
	
	@FindBy(xpath = "//div[@class=\"signup-form\"]/h2")
	public WebElement signUpLabel;
	
	@FindBy(xpath = "//input[@placeholder='Name']")
	WebElement signUpName;
	
	@FindBy(xpath = "//input[@data-qa='signup-email']")
	WebElement signUpEmail;
	
	@FindBy(xpath = "//button[normalize-space()='Signup']")
	WebElement signUpBtn;
	
	@FindBy(xpath = "//a[@href=\"/logout\"]")
	WebElement logoutBtn;
	
	@FindBy(xpath = "//input[@data-qa=\"login-password\"]/following-sibling::p")
	WebElement loginErrorMsg;

	



	public LoginPageObjects() {
		PageFactory.initElements(driver, this);
	}
	
	public void loginUser(String username, String password ) {
		emailInputField.sendKeys(username);
		passwordInputField.sendKeys(password);
		loginBtn.click();
	
	}
	public void verifyThatUserLogin() {
		Assert.assertEquals(driver.getTitle(), td.homePageTitle);
		assertTrue(logoutBtn.isDisplayed(), "Logout button is not displayed");
	}
	
	public void verifyUnsuccessfulLogin() {
		Assert.assertEquals(driver.getTitle(), td.loginPageTitle);
	}
	public  void signUpUser(String user, String email) {
		signUpName.sendKeys(user);
		signUpEmail.sendKeys(email);
		signUpBtn.click();
	
	}

	public void verifyLoginErrorMsg() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Automation Exercise - Signup / Login");
		String errorMsg = loginErrorMsg.getText();
		Assert.assertEquals(errorMsg, "Your email or password is incorrect!");
	}
	
}
