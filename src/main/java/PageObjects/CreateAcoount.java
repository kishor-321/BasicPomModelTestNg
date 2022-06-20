package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClassPackages.TestBase;
import Utility.Util;

public class CreateAcoount extends TestBase {
//pages factory
	@FindBy(css = "input[name='firstname']")
	WebElement FirstName;

	@FindBy(css = "input[name='lastname']")
	WebElement SirName;

	@FindBy(css = "input[name='reg_email__']")
	WebElement Email;

	@FindBy(css = "input[name='reg_email_confirmation__']")
	WebElement Email1;

	@FindBy(css = "#password_step_input")
	WebElement Passwords;

	@FindBy(css = "select[id='day']")
	WebElement Day;

	@FindBy(css = "select[id='day']>:nth-of-type(10)")
	WebElement DaySelect;

	@FindBy(css = "select[id='month']")
	WebElement Month;

	@FindBy(css = "select[id='month']>:nth-of-type(10)")
	WebElement Monthselection;

	@FindBy(css = "select[id='year']")
	WebElement Year;

	@FindBy(css = "select[id='year']>:nth-of-type(10)")
	WebElement YearSelect;

	@FindBy(css = "input#u_1u_3_kc")
	WebElement sex;

	@FindBy(css = "button#u_1u_s_Wj")
	WebElement SignUp;

//actions	
	public CreateAcoount() {
		PageFactory.initElements(Driver, this);
	}

	public String TitleNameValidation() {
		return Driver.getTitle();
	}

	public Boolean FirstNameValidation() {
		return FirstName.isEnabled();
	}

	public String FirstNameSelection() {
		return FirstName.getAttribute("aria-label");
	}

	public boolean sirnameSelection() {
		return SirName.isEnabled();
	}

	public boolean sirnameclickable() {
		return SirName.isDisplayed();
	}

	public SignIN allData(String a, String b, String c, String C1, String d) {
		FirstName.sendKeys(a);
		SirName.sendKeys(b);
		Email.sendKeys(c);
		Email1.sendKeys(C1);
		Passwords.sendKeys(d);
		Driver.findElement(By.cssSelector("select[name='birthday_day']")).click();
		Driver.findElement(By.cssSelector("select[name='birthday_day']>option[value='10']")).click();
		Driver.findElement(By.cssSelector("select[name='birthday_month']")).click();
		Driver.findElement(By.cssSelector("select[name='birthday_month']>option[value='8']")).click();
		Driver.findElement(By.cssSelector("select[name='birthday_year']")).click();

		WebElement yearDropDown = Driver.findElement(By.cssSelector("select[name='birthday_year']"));
		yearDropDown.sendKeys("1996");
		yearDropDown.click();
		Driver.findElement(By.cssSelector("span>input[value='2']")).click();
		Driver.findElement(By.cssSelector("button[name='websubmit']")).click();

//		TakesScreenshot sceenShot=(TakesScreenshot)Driver;
//		File saveFile=sceenShot.getScreenshotAs(OutputType.FILE);
//		try {
//			
//			FileUtils.copyFile(saveFile, new File("F:\\acceleration\\workspace\\PageObjectModel\\src\\main\\resources"
//					+ "\\Screenshot\\nknm.png"));
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Util.takeScreenshotAtEndOfTest();
		return new SignIN();
	}

	public void clickOnfirstName() {
		FirstName.click();
	}

}
