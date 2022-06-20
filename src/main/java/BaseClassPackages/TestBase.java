package BaseClassPackages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import Utility.Util;
import Utility.WebDriverLogsUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static Properties prop;
	public static WebDriver Driver;
	public static EventFiringWebDriver E_driver;
	public static WebDriverLogsUtility EventListener;
	

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"F:\\acceleration\\workspace\\PageObjectModel\\src\\main\\java\\Configuration\\logintowish.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
	String BrowserName = prop.getProperty("browser");
		
		if (BrowserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			Driver = new ChromeDriver();
		} else if (BrowserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			Driver = new EdgeDriver();
		}else if (BrowserName.equalsIgnoreCase("FF")) {
			WebDriverManager.firefoxdriver().setup();
			Driver = new FirefoxDriver();
		}
		
//		E_driver =new EventFiringWebDriver(Driver);
//		EventListener=new WebDriverLogsUtility();
//		E_driver.register(EventListener);
//		Driver=E_driver;
		
		
		
		Driver.manage().deleteAllCookies();
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(Util.Implicit_Wait, TimeUnit.SECONDS);
		Driver.manage().timeouts().implicitlyWait(Util.Page_Load_Time_Out, TimeUnit.SECONDS);
		Driver.get(prop.getProperty("url"));

	}
}
