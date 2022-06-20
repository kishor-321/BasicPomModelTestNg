package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import BaseClassPackages.TestBase;

public class Util extends TestBase {
	public static long Page_Load_Time_Out = 20;
	public static long Implicit_Wait = 20;

	public void switchtoFrame() {
		Driver.switchTo().frame(0);
		// If we want call create an instance of tht class and call into objectclass and
		// print it

	}

	public static Object[][] getEachRowAllCellValue(String name) throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\main\\java\\TestDataXLfiles\\Book1.xlsx");
		// 2. Create an instance of required workbook
		Workbook x = new XSSFWorkbook(fis);
		// 3. get sheet
		Sheet sheet = x.getSheet("LogInMembersLists");
		// 4. get row count
		int rowCount = sheet.getLastRowNum();
		Object[][] data = new Object[rowCount][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < rowCount; i++) {

			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
//				System.out.print(sheet.getRow(i).getCell(j).getStringCellValue());
				System.out.println(data[i][j]);
			}
//			System.out.println();
		}
		return data;

	}

	public static void takeScreenshotAtEndOfTest() {
		TakesScreenshot sceenShot=(TakesScreenshot)Driver;
		File saveFile=sceenShot.getScreenshotAs(OutputType.FILE);
		try {
			
			FileUtils.copyFile(saveFile, new File("F:\\acceleration\\workspace\\PageObjectModel\\src\\main\\resources\\Screenshot\\"+System.currentTimeMillis()+ "case.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
