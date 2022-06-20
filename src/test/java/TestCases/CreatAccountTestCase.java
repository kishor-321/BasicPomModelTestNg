package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClassPackages.TestBase;
import PageObjects.CreateAcoount;
import PageObjects.LogInPage;
import PageObjects.SignIN;
import Utility.Util;

public class CreatAccountTestCase extends TestBase {
	LogInPage loginpageobj;
	CreateAcoount CreateAcoountObj;
	SignIN signup;
	String name ="LogInMembersLists";

	public CreatAccountTestCase() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpageobj = new LogInPage();
		CreateAcoountObj = loginpageobj.ClickOnCreateNewAccount();
	}

	@Test(priority = 7)
	public void FirstnameClickIsSelectableValidationTest() {
		String selection = CreateAcoountObj.FirstNameSelection();
		Assert.assertEquals(selection, "First name");
	}

	@Test(priority = 8)
	public void FirstnameClickIsSelectableValidationTest1() {
		Boolean Value = CreateAcoountObj.FirstNameValidation();
		Assert.assertTrue(Value);

	}

	@Test(priority = 9)
	public void FirstnameClickIsSelectableValidationTest2() {
		boolean sirname = CreateAcoountObj.sirnameSelection();
		Assert.assertEquals(sirname, true);
	}

	@Test(priority = 10)
	public void FirstnameClickIsSelectableValidationTest4() {
		boolean sirname = CreateAcoountObj.sirnameclickable();
		Assert.assertEquals(sirname, true);
	}

	@DataProvider
	public Object[][] getDataExcel() throws IOException  {
		Object data [][]=Util.getEachRowAllCellValue(name);
		return data;
	}

	@Test(priority = 11, dataProvider="getDataExcel")
	public void enterAllDataFromExcel(String Firstname,String Sirname, String mail, String mailverify, String password) {
		CreateAcoountObj.allData(Firstname,Sirname,mail,mailverify,password);
//		CreateAcoountObj.allData("Kishor","Deshmane","kishordeshmane321@gmail.com","kishor@1996");
		System.out.println(Driver.getTitle());
	}

	@AfterMethod
	public void tearDown() {
		Driver.quit();
	}
}