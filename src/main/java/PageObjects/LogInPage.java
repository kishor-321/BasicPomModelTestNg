package PageObjects;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClassPackages.TestBase;


public class LogInPage extends TestBase {

//	page Factory or Object repository
	@FindBy(css = "input#email")
//	@CacheLookup Improves the performance of script but when u get refresh the page it will give stale element exception due to store value is currupted
	WebElement username;

	@FindBy(css = "div>input#pass")
	WebElement password;

	@FindBy(css = "button[name='login']")
	WebElement LoginButton;

	@FindBy(css = "a[class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")
	WebElement createaccount;

	@FindBy(css = "img[class='fb_logo _8ilh img']")
	WebElement FbLogoValidaion;

	@FindBy(xpath = "//a[text()='Forgotten password?']")
	WebElement ForgotpasswordLink;

//	initializing page Objects repository
	public LogInPage() {
		PageFactory.initElements(Driver, this);
//	or 	PageFactory.initElements(Driver, LogInPage.class);
	}

//	Your Actions
	public String ValidateLogInPageTitle() {
		return Driver.getTitle();
	}

	public boolean ValidateFbLogoButton() {
		return FbLogoValidaion.isDisplayed();
	}

	public boolean ValidateCreateAccountButton() {
		return createaccount.isDisplayed();
	}

	public CreateAcoount ClickOnCreateNewAccount() {
		createaccount.click();
		return new CreateAcoount();
	}

	public HomePage ValidayeLogInButton(String use, String Pass) {
		username.sendKeys(use);
		password.sendKeys(Pass);
		LoginButton.click();
		return new HomePage();
	}

	public String ValidationForgetPasswordButton() {
		ForgotpasswordLink.click();
		TakesScreenshot sceenShot=(TakesScreenshot)Driver;
		File saveFile=sceenShot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(saveFile, new File("F:\\acceleration\\workspace\\PageObjectModel\\src\\main\\resources\\Screenshot\\forgetpassword.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Driver.getTitle();
	}
}
