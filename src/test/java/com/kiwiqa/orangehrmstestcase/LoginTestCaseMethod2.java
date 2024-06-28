package com.kiwiqa.orangehrmstestcase;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.kiwiqa.commonfiles.CommonFiles;
import com.kiwiqa.orangehrmpages.MyInfoPageMethod2;

public class LoginTestCaseMethod2 {

	public static void main(String[] args) throws AWTException, InterruptedException, IOException 
	{
		WebDriver driver = new ChromeDriver();

		Actions action = new Actions(driver);

		Robot robot = new Robot();

		String aExcelFilePath="src/test/resources/TestData/Odata.xlsx";
		String sheetName = "Sheet1";

		MyInfoPageMethod2 lp =new MyInfoPageMethod2(driver,action,robot);

		CommonFiles.impWait(13);



		lp.openUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		CommonFiles.zoomIn(2);

		lp.setUserName(CommonFiles.getCellData(aExcelFilePath, sheetName, 0, 1));
		Thread.sleep(2000);

		lp.setPassword(CommonFiles.getCellData(aExcelFilePath, sheetName, 1, 1));
		Thread.sleep(2000);

		lp.clickSubmitButton();

		lp.clickMyinfo();

		lp.setFirstName(CommonFiles.getCellData(aExcelFilePath, sheetName, 2, 1));

		lp.setEmpID(CommonFiles.getCellData(aExcelFilePath, sheetName, 3, 1));

		lp.setOtherID(CommonFiles.getCellData(aExcelFilePath, sheetName, 4, 1));

		lp.clickSaveButtonFirst();

		lp.verifySuccessfullyUpdate("Successfully Updated");



	}

}




