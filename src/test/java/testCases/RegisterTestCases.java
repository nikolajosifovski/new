package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.SignUp;
import testData.TestD;

public class RegisterTestCases extends Base {
		
	HomePageObjects home;
	LoginPageObjects login;
	SignUp signUp;
	TestD testdata;
	
	@BeforeMethod
	public void setup() {
		openApplication();
		home = new HomePageObjects();
		login = new LoginPageObjects();
		signUp = new SignUp();
		testdata = new TestD();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	
	@Test
	public void registerUser() {
		
		home.navigateToLoginPage();   		//Click on 'Signup / Login' button
		login.signUpLabel.isDisplayed(); 		//Verify 'New User Signup!' is visible
		String userN = "testuser5639481";
		String emailA = "mail3948323@test.com";
		login.signUpUser(userN,emailA ); // Enter name and email address and Click 'Signup' button
		signUp.headerSignUp.isDisplayed(); // Verify that 'ENTER ACCOUNT INFORMATION' is visible
		String actualHeaderTxt = signUp.getHeaderText();
		Assert.assertEquals(actualHeaderTxt, "ENTER ACCOUNT INFORMATION");
		signUp.selectGender("mr");
		signUp.populatePassword("qwerty");
		signUp.populateFirstandLastName("Goce", "Jovanov");
		signUp.inputAdress("Partizanska 45");
		signUp.selectCountry("Canada");
		signUp.populateStateCityZipMobile("Alberta", "Calgary", "43214", "075223305");
		signUp.scrollToCreateAccBtn();
		signUp.clickOnCreateAccountBtn();
		signUp.verifyThatAccountIsCreated();
		signUp.clickContinueBtn();
		
		String actualUser = signUp.actualLoggedUser.getText();
		Assert.assertEquals(actualUser, userN);
		
		signUp.deleteAcoountBtn.isDisplayed();
		//signUp.deleteAccount();
		
	}

}
