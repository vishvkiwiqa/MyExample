package com.kiwiqa.practiceformtestcase;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import com.kiwiqa.commonfiles.*;

import com.kiwiqa.practiceformpage.PracticeFormPage;


class PracticeFormTestCase extends CommonFiles
{

	public static void main(String[] args) throws AWTException
	{

		//CommonFile.ChromeDriverIn();
		WebDriver driver = new ChromeDriver();

		//CommonFile.ActionsClassIn();
		Actions action = new Actions(driver);

		//CommonFile.RobotClassIn();
		Robot robot = new Robot();

		PracticeFormPage reg = new PracticeFormPage(driver,action,robot);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		reg.openUrl("https://demoqa.com/automation-practice-form");

		reg.zoomIn(2);

		WebElement formTitle =driver.findElement(By.xpath("//h1[text()='Practice Form']"));

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", formTitle);

		String aFirstName ="vishv";
		reg.setFirstName(aFirstName);

		String aLastName ="patel";
		reg.setLastName(aLastName);

		String astudentName = aFirstName + " " +aLastName ;

		String aEmailID = "vishv@gmail.com";
		reg.setEmailID(aEmailID);

		String aGender = driver.findElement(reg.webGenderMale).getText();
		reg.setGenderMale();

		String aPhoneNumber ="9898433284";
		reg.setPhoneNumber(aPhoneNumber);

		reg.clickdobTextFiled();

		String aYear ="2002";
		String aMonth ="May";
		String aDate ="20";
		String adob = aDate+ " "+ aMonth+","+ aYear ;

		reg.setYear(aYear);
		reg.setMonth(aMonth);
		reg.setDate(aDate);

		String asubject1="English";
		String asubject2="Maths";
		reg.SetSubject(asubject1, asubject2);
		String atotalSubject =asubject1 +", "+ asubject2;

		String aRHobby =driver.findElement(reg.webReadingHobby).getText();
		reg.setReadingHobby();

		String fileName ="MotuPatalu.jpg";
		reg.setPic(fileName);

		String aCurrentAddress = "56 Jaltarng Parck ,Shivaji chowk ,Ahmedabad";
		reg.setCurrentAddress(aCurrentAddress);

		String aStateName="NCR";
		reg.setState(aStateName);

		String aCity="Delhi";
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
		allText.add(aRHobby);
		allText.add(fileName);
		allText.add(aCurrentAddress);
		allText.add(astateAndCity);

		reg.verifyText(allText);
		//	int sized =driver.findElements(By.tagName("tr")).size();
		//System.out.println(sized);
	}

}



