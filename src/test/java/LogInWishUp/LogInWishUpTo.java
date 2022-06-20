package LogInWishUp;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import BaseClassPackages.TestBase;
import wish.WishPAge;

public class LogInWishUpTo extends TestBase {

	ExtentReports extent=new ExtentReports();
	ExtentSparkReporter report=new ExtentSparkReporter("F:\\acceleration\\workspace\\PageObjectModel\\target\\file.html");
	
	static Logger logger=LogManager.getLogger(LogInWishUpTo.class);
	WishPAge LogIn;

	public LogInWishUpTo() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		LogIn = new WishPAge();
	}

	@Test(dataProvider="testData")
	public void loginPageTest1(String username, String password, String scanario) {
		logger.info("Logger Working");
		ExtentTest test=extent.createTest("Verification test1");
		test.info("Validation info extent 1");
		LogIn.logInClick(username, password);
	}
	
	@DataProvider
	public Object[][] testData() throws IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\main\\java\\Configuration\\logintowish.properties");
		Properties prop =new Properties();
		prop.load(fis);
		
		Object[][] data = new Object[4][3];
		data[0][0]=prop.getProperty("validUserId1");
		data[0][1]=prop.getProperty("validPassword1");	
		data[0][2]=prop.getProperty("scenario");
		
				
		data[1][0]=prop.getProperty("validUserId2");
		data[1][1]=prop.getProperty("validPassword2");	
		data[1][2]=prop.getProperty("scenario");
				
		data[2][0]=prop.getProperty("validUserId3");
		data[2][1]=prop.getProperty("validPassword3");	
		data[2][2]=prop.getProperty("scenario");
				
		data[3][0]=prop.getProperty("invalidUserId1");
		data[3][1]=prop.getProperty("invalidPassword1");	
		data[3][2]=prop.getProperty("scenario");	
		
		/*
		 * Object data[][] = { { "wishup_testuser1@gmail.com", "testpw1","correct" }, {
		 * "wishup_testuser2@gmail.com", "testpw2" ,"incorrect"}, {
		 * "wishup_testuser3@gmail.com", "testpw3","correct" }, {
		 * "wishup_testuser4@gmail.com", "testpw4","correct" } };
		 */
		
		return data;
	}

	@AfterMethod
	public void tearDown() {
		Driver.quit();
	}

}
