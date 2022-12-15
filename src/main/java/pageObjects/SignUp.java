package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.Base;

public class SignUp extends Base{
	
	@FindBy(xpath = "//h2[@class=\"title text-center\"]/b")
	public WebElement headerSignUp;
	
	@FindBy(id = "id_gender1")
	WebElement mrRadioBtn;
	
	@FindBy(id = "id_gender2")
	WebElement mrsRadioBtn;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@id='first_name']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@id='last_name']")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@id='address1']")
	WebElement address;
	
	@FindBy(id = "country")
	WebElement country;
	
	@FindBy(xpath = "//input[@id='state']")
	WebElement state;
	
	@FindBy(xpath = "//input[@id='city']")
	WebElement city;
	
	@FindBy(xpath = "//input[@id='zipcode']")
	WebElement zipcode;
	
	@FindBy(xpath = "//input[@id='mobile_number']")
	WebElement mobilePhone;
	
	@FindBy(xpath = "//input[@value=\"create_account\"]/following-sibling::button")
	WebElement createAccountBtn;
	
	@FindBy(xpath = "//h2[@data-qa=\"account-created\"]/b")
	WebElement accountCreatedMsg;
	
	@FindBy(xpath = "//a[@data-qa=\"continue-button\"]")
	WebElement continueBtn;
	
	@FindBy(xpath = "//i[@class=\"fa fa-user\"]/following-sibling::b")
	public WebElement actualLoggedUser;
	
	@FindBy(xpath = "//a[@href=\"/delete_account\"]")
	public WebElement deleteAcoountBtn;
	
	@FindBy(xpath = "//h2[@data-qa=\"account-deleted\"]/b")
	WebElement delAccountMsg;
	
	
	
	
	//initialization
	public SignUp() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	//methods
	public String getHeaderText()  {
		String headerText = headerSignUp.getText();
		return headerText;
	}
	
	public void selectGender(String gender) {
		if(gender.equals("mr")) {
			mrRadioBtn.click();
		}
		else if(gender.equals("mrs")) {
			mrsRadioBtn.click();
		}
		else {
			Assert.assertTrue(false);
		}
	}
	
	public void populatePassword(String p) {
		password.sendKeys(p);
	}
	public void populateFirstandLastName(String fn, String ln) {
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
	}
	public void inputAdress(String adr) {
		address.sendKeys(adr);
	}
	public void selectCountry(String country1) {
		Select s = new Select(country);
		s.selectByVisibleText(country1);
		
	}
	public void populateStateCityZipMobile(String s, String c, String z, String m) {
		state.sendKeys(s);
		city.sendKeys(c);
		zipcode.sendKeys(z);
		mobilePhone.sendKeys(m);
	}
	public void clickOnCreateAccountBtn() {
		createAccountBtn.click();
		
	}
	public void scrollToCreateAccBtn() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", createAccountBtn);
	}
	
	public void verifyThatAccountIsCreated() {
		accountCreatedMsg.isDisplayed();
	}
	
	public void clickContinueBtn() {
		continueBtn.click();
	}
	
	public void deleteAccount() {
		deleteAcoountBtn.click();
		delAccountMsg.isDisplayed();
	}
	
	

}
