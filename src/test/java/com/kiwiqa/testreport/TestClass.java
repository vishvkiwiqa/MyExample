package com.kiwiqa.testreport;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.kiwiqa.commonfiles.CommonFiles;
import com.kiwiqa.orangehrmpages.MyInfoPageMethod2;
import com.kiwiqa.practiceformpage.PracticeFormPageMethod2;

public class TestClass extends CommonFiles
{
	String aExcelFilePath;
	String sheetName;
	MyInfoPageMethod2 lp ;


	@BeforeClass
	public void beforeTest() throws AWTException, IOException
	{
		CommonFiles.setupreport();
		CommonFiles.edgeDriverIn();
		CommonFiles.actionsClassIn();
		CommonFiles.robotClassIn();
		CommonFiles.loadConfigFile();
		aExcelFilePath=prop.getProperty("TestDataExcelFilePathForOrange");
		sheetName = prop.getProperty("sheetNameForOrangeHrm");
		lp =new MyInfoPageMethod2(driver,action,robot);
	}

	@Test
	public void loginVerify() throws IOException, InterruptedException
	{
		test=extent.createTest("Login Test By ITestResult ");

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
	
	@Test
	public void formReg() throws IOException
	{
		test=extent.createTest(" FormReg");
		
		PracticeFormPageMethod2 reg = new PracticeFormPageMethod2(driver,action,robot);

		CommonFiles.impWait(10);

		driver.get(prop.getProperty("FormUrl"));
		test.info("Open Url");

		reg.scrollToFormTitle();
		test.info("Scroll TO Form Title");
		
		CommonFiles.zoomIn(2);
		test.info("zoom");
		
		String aExcelFilePath=prop.getProperty("TestDataExcelFilePathForForm");
		String sheetName = prop.getProperty("sheetNameForForm");

		String aFirstName =CommonFiles.getCellData(aExcelFilePath,sheetName,0,1);
		reg.setFirstName(aFirstName);
		test.info("set first name");

		String aLastName = CommonFiles.getCellData(aExcelFilePath,sheetName,1,1);
		reg.setLastName(aLastName);
		test.info("set Last name");

		String astudentName = aFirstName + " " +aLastName ;

		String aEmailID =  CommonFiles.getCellData(aExcelFilePath,sheetName,2,1);
		reg.setEmailID(aEmailID);
		test.info("set Email Id");

		String aGender =CommonFiles.getCellData(aExcelFilePath,sheetName,14,1);;
		reg.setGender(aGender);
		test.info("set Gender");

		String aPhoneNumber = CommonFiles.getCellData(aExcelFilePath,sheetName,3,1);
		reg.setPhoneNumber(aPhoneNumber);
		test.info("set Phone numer");

		reg.clickDobTextField();

		String aYear = CommonFiles.getCellData(aExcelFilePath,sheetName,4,1);
		String aMonth = CommonFiles.getCellData(aExcelFilePath,sheetName,5,1);
		String aDate = CommonFiles.getCellData(aExcelFilePath,sheetName,6,1);
		String adob = aDate+ " "+ aMonth+","+ aYear ;
		test.info("set DOB");
		
		reg.setYear(aYear);
		reg.setMonth(aMonth);
		reg.setDate(aDate);

		String asubject1= CommonFiles.getCellData(aExcelFilePath,sheetName,7,1);
		String asubject2= CommonFiles.getCellData(aExcelFilePath,sheetName,8,1);
		reg.setSubject(asubject1, asubject2);
		String atotalSubject =asubject1 +", "+ asubject2;
		test.info("set sub");


		String aHobby = CommonFiles.getCellData(aExcelFilePath,sheetName,13,1);
		reg.setHobby(aHobby);
		test.info("set hobby");

		String fileName = CommonFiles.getCellData(aExcelFilePath,sheetName,9,1);
		reg.setPic(fileName);
		test.info("set file");

		String aCurrentAddress = CommonFiles.getCellData(aExcelFilePath,sheetName,10,1);
		reg.setCurrentAddress(aCurrentAddress);
		test.info("set address");

		String aStateName= CommonFiles.getCellData(aExcelFilePath,sheetName,11,1);
		reg.setState(aStateName);
		test.info("set state name");

		String aCity=CommonFiles.getCellData(aExcelFilePath,sheetName,12,1);
		reg.setCity(aCity);
		test.info("set city name");

		String astateAndCity =aStateName + " " +aCity ;

		reg.clickSubmitButton();
		test.info("click submit button");

		ArrayList<Object> allText =new ArrayList<Object>();
		allText.add(astudentName);
		allText.add(aEmailID);
		allText.add(aGender);
		allText.add(aPhoneNumber);
		allText.add(adob);
		allText.add(atotalSubject);
		allText.add(aHobby);
		allText.add(fileName);
		allText.add(aCurrentAddress);
		allText.add(astateAndCity);

		reg.verifyText(allText);
		test.info("text is verified");
	}


	@AfterMethod
	public void afterMethod(ITestResult result) throws InterruptedException
	{
		CommonFiles.attScreenShort(result);

	}

	@AfterClass
	public void afterclass()
	{
		extent.flush();

	}


}

