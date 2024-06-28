package com.kiwiqa.extentreportspark;


import static org.testng.Assert.assertEquals;
import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.kiwiqa.commonfiles.CommonFiles;
import com.kiwiqa.orangehrmpages.MyInfoPageMethod2;

@Listeners(TestListener.class)
public class ExtentReportExample extends CommonFiles
{
	String aExcelFilePath;
	String sheetName;
	MyInfoPageMethod2 lp ;

	@Parameters("browser")
	@BeforeClass
	public void beforeTest(String browser) throws AWTException, IOException
	{

		CommonFiles.setupreport();
		//CommonFiles.chromeDriverIn();

		CommonFiles.openBrowser(browser);
		actionsClassIn();
		CommonFiles.robotClassIn();
		CommonFiles.loadConfigFile();
		aExcelFilePath=prop.getProperty("TestDataExcelFilePathForOrange");
		sheetName = prop.getProperty("sheetNameForOrangeHrm");
		lp =new MyInfoPageMethod2(driver,action,robot);


	}
	@Parameters("browser")
	@Test
	public void loginVerify(String browser ) throws IOException, InterruptedException
	{
		test=extent.createTest("Login Test In " +browser );



		driver.get(prop.getProperty("Orangeurl"));
		test.info("Open URL");

		CommonFiles.impWait(15);
		CommonFiles.zoomIn(2);

		lp.setUserName(CommonFiles.getCellData(aExcelFilePath, sheetName, 0, 1));
		test.info("Enter UserName");

		lp.setPassword(CommonFiles.getCellData(aExcelFilePath, sheetName, 1, 1));
		test.info("Enter Password");

		lp.clickSubmitButton();
		test.info("click Submit Button");

		assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
		test.info("Open Dashboard");

		//		lp.clickMyinfo();
		//		test.info("Click MY Info");
		//
		//		lp.setFirstName(CommonFiles.getCellData(aExcelFilePath, sheetName, 2, 1));
		//		test.info("Enter First Name");
		//
		//		lp.setEmpID(CommonFiles.getCellData(aExcelFilePath, sheetName, 3, 1));
		//		test.info("Enter Emp Id");
		//
		//		lp.setOtherID(CommonFiles.getCellData(aExcelFilePath, sheetName, 4, 1));
		//		test.info("Enter Other Id");
		//
		//		lp.clickSaveButtonFirst();
		//		test.info("Click On Save Button");
		//
		//		lp.verifySuccessfullyUpdate("Successfully Updated");
		//		test.info("Update Msg Is Verified");
	}

	@Parameters("browser")
	@Test(dependsOnMethods = {"loginVerify"})
	public void updateMyInfoVerify(String browser) throws InterruptedException, IOException
	{
		test=extent.createTest("My Info Test in" + browser);

		//		String aExcelFilePath=prop.getProperty("TestDataExcelFilePathForOrange");
		//		String sheetName = prop.getProperty("sheetNameForOrangeHrm");
		//		MyInfoPageMethod2 lp =new MyInfoPageMethod2(driver,action,robot);

		lp.clickMyinfo();
		test.info("Click MY Info");

		lp.setFirstName(CommonFiles.getCellData(aExcelFilePath, sheetName, 2, 1));
		test.info("Enter First Name");

		lp.setEmpID(CommonFiles.getCellData(aExcelFilePath, sheetName, 3, 1));
		test.info("Enter Emp Id");

		lp.setOtherID(CommonFiles.getCellData(aExcelFilePath, sheetName, 4, 1));
		test.info("Enter Other Id");

		lp.clickSaveButtonFirst();
		test.info("Click On Save Button");

		lp.verifySuccessfullyUpdate("Successfully Updated");
		test.info("Update Msg Is Verified");

	}

	@AfterMethod
	public void afterTest()
	{

		extent.attachReporter(spark);
		extent.flush();

	}
	@AfterClass
	public void afterClass()
	{
		driver.quit();

	}
}

