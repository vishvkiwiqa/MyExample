package com.kiwiqa.testNGexamples;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.kiwiqa.commonfiles.CommonFiles;
import com.kiwiqa.orangehrmpages.MyInfoPageMethod2;

public class OrangeWithTestNG extends CommonFiles
{
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("start of test suite");
	}

	@AfterSuite
	public void afterSuite()
	{
		System.out.println("end of test suite");
	}

	@Parameters("browser")
	@BeforeMethod
	public void beforeClass(String browser) throws AWTException, IOException
	{
		System.out.println("run testcase in " + browser);
		CommonFiles.openBrowser(browser);
		//CommonFiles.chromeDriverIn();
		CommonFiles.actionsClassIn();
		CommonFiles.robotClassIn();
		CommonFiles.loadConfigFile();
	}

	@AfterMethod
	public void AfterClass()
	{
		driver.quit();
	}

	@Test
	public void verifyUpdateMsg() throws IOException, InterruptedException
	{

		String aExcelFilePath=prop.getProperty("TestDataExcelFilePathForOrange");
		String sheetName = prop.getProperty("sheetNameForOrangeHrm");

		MyInfoPageMethod2 lp =new MyInfoPageMethod2(driver,action,robot);

		driver.get(prop.getProperty("Orangeurl"));

		CommonFiles.impWait(15);
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
