package com.kiwiqa.practiceformtestcase;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.kiwiqa.practiceformpage.TryPracticeFormPage;


public class TryPracticeFormMethod3
{

	public static void main(String[] args) throws AWTException, IOException
	{


		WebDriver driver = new ChromeDriver();
		Actions action = new Actions(driver);
		Robot robot = new Robot();

		TryPracticeFormPage reg = new TryPracticeFormPage(driver,action,robot);

		reg.maximizeWindo();

		reg.impWait(10);

		reg.openUrl("https://demoqa.com/automation-practice-form");

		reg.zoomIn(2);

		reg.scrollToFormTitle();

		String aExcelFilePath="src/test/resources/TestData/Book1.xlsx";
		String sheetName = "Sheet1";

		String aFirstName =reg.getCellData(aExcelFilePath,sheetName,"hFirstName");
		reg.setFirstName(aFirstName);

		String aLastName = reg.getCellData(aExcelFilePath,sheetName,"hLastName");
		reg.setLastName(aLastName);

		String astudentName = aFirstName + " " +aLastName ;

		String aEmailID =  reg.getCellData(aExcelFilePath,sheetName,"hEmailID");
		reg.setEmailID(aEmailID);

		String aGender =reg.getCellData(aExcelFilePath,sheetName,"hGender");
		reg.setGender(aGender);

		String aPhoneNumber = reg.getCellData(aExcelFilePath,sheetName,"hPhoneNumber");
		reg.setPhoneNumber(aPhoneNumber);

		reg.clickDobTextField();

		String aYear = reg.getCellData(aExcelFilePath,sheetName,"hYear");
		String aMonth = reg.getCellData(aExcelFilePath,sheetName,"hMonth");
		String aDate = reg.getCellData(aExcelFilePath,sheetName,"hDate");
		String adob = aDate+ " "+ aMonth+","+ aYear ;

		reg.setYear(aYear);
		reg.setMonth(aMonth);
		reg.setDate(aDate);

		String asubject1= reg.getCellData(aExcelFilePath,sheetName,"hSubject1");
		String asubject2= reg.getCellData(aExcelFilePath,sheetName,"hSubject2");
		reg.setSubject(asubject1, asubject2);
		String atotalSubject =asubject1 +", "+ asubject2;


		String aHobby = reg.getCellData(aExcelFilePath,sheetName,"hHobby");
		reg.setHobby(aHobby);

		String fileName = reg.getCellData(aExcelFilePath,sheetName,"hFileName");
		reg.setPic(fileName);

		String aCurrentAddress =  reg.getCellData(aExcelFilePath,sheetName,"hCurrentAddress");
		reg.setCurrentAddress(aCurrentAddress);

		String aStateName= reg.getCellData(aExcelFilePath,sheetName,"hStateName");
		reg.setState(aStateName);

		String aCity=reg.getCellData(aExcelFilePath,sheetName,"hCityName");
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
