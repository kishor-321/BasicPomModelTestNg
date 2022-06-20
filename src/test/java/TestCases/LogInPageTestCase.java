package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClassPackages.TestBase;
import PageObjects.CreateAcoount;
import PageObjects.HomePage;
import PageObjects.LogInPage;
import Utility.Util;

public class LogInPageTestCase extends TestBase {
	LogInPage loginpageobj;
	HomePage homepageobj;
	CreateAcoount CreateAcoountObj;
	Util util;

	public LogInPageTestCase() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpageobj = new LogInPage();
	}

	@Test(priority = 1)
	public void ValidationOnTitleTest() {
		
		String TitleVerifyLogIn = loginpageobj.ValidateLogInPageTitle();
		Assert.assertEquals(TitleVerifyLogIn, "Facebook – log in or sign up");
	}

	@Test(priority = 2)
	public void ValidationOnLogoTest() {
		boolean FacebookLogoValidation = loginpageobj.ValidateFbLogoButton();
		Assert.assertEquals(FacebookLogoValidation, true);
	}

	@Test(priority = 3)
	public void CreateAccountButtonValidation() {
		boolean createButton = loginpageobj.ValidateCreateAccountButton();
		Assert.assertEquals(createButton, true);
	}

	@Test(priority = 4)
	public void ValidationButtonForTheForgetPassword() {
		String LinkForForgetPassWord = loginpageobj.ValidationForgetPasswordButton();
		Assert.assertEquals(LinkForForgetPassWord, "Forgotten Password | Can't Log In | Facebook");
	}

	@Test(priority = 5)
	public void GoToCreteAcPage() {
		CreateAcoountObj = loginpageobj.ClickOnCreateNewAccount();
		System.out.println(Driver.getTitle());
	}

	@Test(priority = 6)
	public void ValidationloginPageTest() {
		homepageobj = loginpageobj.ValidayeLogInButton(prop.getProperty("username"), (prop.getProperty("password")));
		Driver.getTitle();
	}

	@AfterMethod
	public void tearDown() {
		Driver.quit();
	}
}
