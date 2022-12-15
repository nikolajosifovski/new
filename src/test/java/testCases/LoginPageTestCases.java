package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import testData.TestD;

public class LoginPageTestCases extends Base {
	
	
		HomePageObjects hp;
		LoginPageObjects lp;
		TestD td;

		@BeforeMethod
		public void start() {
			openApplication();
			hp = new HomePageObjects();
			lp = new LoginPageObjects();
			td = new TestD();
		}
		
		
		
		@AfterMethod
		public void end() throws InterruptedException {
			Thread.sleep(3000);
			driver.quit();
		}
		
		
		@Test
		public void loginWithValidCredentials() {
			hp.navigateToLoginPage();
			lp.loginUser(td.validUserName, td.validPassword);
			lp.verifyThatUserLogin();
		}
		@Test
		public void loginWithWrongEmail() {
			hp.navigateToLoginPage();
			lp.loginUser(td.inValidUserName, td.validPassword);
			Assert.assertEquals(driver.getTitle(), td.loginPageTitle);
		}
		
		@Test
		public void loginWithWrongPasswrod() {
			hp.navigateToLoginPage();
			lp.loginUser(td.validUserName, td.inValidPassword);
			lp.verifyUnsuccessfulLogin();
		}
	
	
	
}
