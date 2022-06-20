package wish;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClassPackages.TestBase;

public class WishPAge extends TestBase{
	@FindBy(css= "input#email")
	private WebElement userEmailTextField;
	
	@FindBy(css= "input[type='password']")
	private WebElement userPasswordTextField;
	
	@FindBy(css= "input[value='Log in']")
	private WebElement loginButton;
	
	@FindBy(css = "a[href='/forgot']")
	private WebElement forgotYourPassword;
	
	@FindBy(css = "a[href='/signup?redirect=/']")
	private WebElement userSignUp;
	
	@FindBy(css = "a[href='/auth/google']")
	private WebElement signInWithGoogleLink;
	
	@FindBy(className = "ui tiny image")
	private WebElement wishupLogoLoginLink;
	
	@FindBy(linkText = "Login")
	private WebElement loginLink;
	
	@FindBy(linkText = "Signup")
	private WebElement signupLink;
	
	@FindBy(xpath = "//h1[text()='Login']")
	private WebElement loginText;
	
	@FindBy(xpath = "//label[text()='Email address']")
	private WebElement emailText;
	
	@FindBy(xpath = "//label[text()='Password']")
	private WebElement passwordText;
	
	@FindBy(xpath = "//h4[text()='New here? Signup instead..']")
	private WebElement newUserSignupText;
	
	//2. Constructor Initialization
	
	public WishPAge() {
//		PageFactory.initElements(driver, Wishup_Login_Page.class);
		PageFactory.initElements(Driver, this);
//		this.driver=driver;
	}
	
	//3. Page Action Method 
	public WishPAge logInClick(String userName, String userPassword) {
		userEmailTextField.sendKeys(userName);
		userPasswordTextField.sendKeys(userPassword);
		loginButton.click();
		return new WishPAge();
	}
		
	
//	public WishPAge enterUserName(String userName)
//	{
//		userEmailTextField.sendKeys(userName);
//		return null;
//	}
//	
//	public WishPAge enterPassword(String userPassword)
//	{
//		userPasswordTextField.sendKeys(userPassword);
//		return null;
//	}
//	
//	public WishPAge clickLoginButton()
//	{
//		loginButton.click();
//		return null;
//	}
	
	public void clickForgotPassword()
	{
		forgotYourPassword.click();
	}
	
	public void clickUserSignup()
	{
		userSignUp.click();
	}
	
	public boolean wishupLogoLinkIsDisplay()
	{
		return wishupLogoLoginLink.isDisplayed();
	}
	
	public boolean loginLinkIsDisplay()
	{
		return loginLink.isDisplayed();
	}
	
	public boolean signupLinkIsDisplay()
	{
		return signupLink.isDisplayed();
	}
	
	public boolean loginLableIsDisplay()
	{
		return loginText.isDisplayed();
	}
	
	public boolean emailLabelIsDisplay()
	{
		return emailText.isDisplayed();
	}
	
	public boolean passwordLabelIsDisplay()
	{
		return passwordText.isDisplayed();
	}
	
	public boolean newUserSignupTextIsDisplay()
	{
		return newUserSignupText.isDisplayed();
	}
	
	public boolean googleLinkIsDisplay()
	{
		return signInWithGoogleLink.isDisplayed();
	}
}
