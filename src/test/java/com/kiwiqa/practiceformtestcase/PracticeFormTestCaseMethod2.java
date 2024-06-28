package com.kiwiqa.practiceformtestcase;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.kiwiqa.commonfiles.CommonFiles;
import com.kiwiqa.practiceformpage.PracticeFormPageMethod2;

public class PracticeFormTestCaseMethod2
{

	public static void main(String[] args) throws AWTException, IOException
	{


		WebDriver driver = new ChromeDriver();
		Actions action = new Actions(driver);
		Robot robot = new Robot();

		PracticeFormPageMethod2 reg = new PracticeFormPageMethod2(driver,action,robot);



		CommonFiles.impWait(10);

		reg.openUrl("https://demoqa.com/automation-practice-form");

		CommonFiles.zoomIn(2);

		reg.scrollToFormTitle();

		String aExcelFilePath="src/test/resources/TestData/FormData.xlsx";
		String sheetName = "Sheet1";

		String aFirstName =CommonFiles.getCellData(aExcelFilePath,sheetName,0,1);
		reg.setFirstName(aFirstName);

		String aLastName = CommonFiles.getCellData(aExcelFilePath,sheetName,1,1);
		reg.setLastName(aLastName);

		String astudentName = aFirstName + " " +aLastName ;

		String aEmailID =  CommonFiles.getCellData(aExcelFilePath,sheetName,2,1);
		reg.setEmailID(aEmailID);

		String aGender =CommonFiles.getCellData(aExcelFilePath,sheetName,14,1);;
		reg.setGender(aGender);

		String aPhoneNumber = CommonFiles.getCellData(aExcelFilePath,sheetName,3,1);
		reg.setPhoneNumber(aPhoneNumber);

		reg.clickDobTextField();

		String aYear = CommonFiles.getCellData(aExcelFilePath,sheetName,4,1);
		String aMonth = CommonFiles.getCellData(aExcelFilePath,sheetName,5,1);
		String aDate = CommonFiles.getCellData(aExcelFilePath,sheetName,6,1);
		String adob = aDate+ " "+ aMonth+","+ aYear ;

		reg.setYear(aYear);
		reg.setMonth(aMonth);
		reg.setDate(aDate);

		String asubject1= CommonFiles.getCellData(aExcelFilePath,sheetName,7,1);
		String asubject2= CommonFiles.getCellData(aExcelFilePath,sheetName,8,1);
		reg.setSubject(asubject1, asubject2);
		String atotalSubject =asubject1 +", "+ asubject2;


		String aHobby = CommonFiles.getCellData(aExcelFilePath,sheetName,13,1);
		reg.setHobby(aHobby);

		String fileName = CommonFiles.getCellData(aExcelFilePath,sheetName,9,1);
		reg.setPic(fileName);

		String aCurrentAddress =  CommonFiles.getCellData(aExcelFilePath,sheetName,10,1);
		reg.setCurrentAddress(aCurrentAddress);

		String aStateName= CommonFiles.getCellData(aExcelFilePath,sheetName,11,1);
		reg.setState(aStateName);

		String aCity=CommonFiles.getCellData(aExcelFilePath,sheetName,12,1);
		reg.setCity(aCity);

		String astateAndCity =aStateName + " " +aCity ;

		reg.clickSubmitButton();

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
	}
}
