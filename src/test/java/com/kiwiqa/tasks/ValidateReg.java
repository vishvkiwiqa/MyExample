package com.kiwiqa.tasks;
import java.awt.AWTException;
import java.awt.Robot;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class ValidateReg {

	public static void main(String[] args) throws AWTException, InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		
		Actions action = new Actions(driver);
		
		Robot robot = new Robot();

		ValidateRegPage reg = new ValidateRegPage(driver,action,robot);

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


		//driver.findElement(By.xpath("//*[@id='state']/child::div")).click();
		String aStateName="NCR";
		reg.setState(aStateName);
		


		//driver.findElement(By.xpath("//*[@id='city']/child::div")).click();
		String aCity="Delhi";
		reg.setCity(aCity);
		//action.sendKeys(aCity,Keys.ENTER).perform();

		String astateAndCity =aStateName + " " +aCity ;


		reg.clickSubmitButton();


		//		//for student name
		//		if(studentName.equals(driver.findElement(By.xpath("//*[@class='table-responsive']//tbody//tr[1]//td[2]")).getText()))
		//			System.out.println("Student Name is match");
		//		else
		//			System.out.println("Student name is Not match");
		//
		//		//for email
		//		if(aEmailID.equals(driver.findElement(By.xpath("//*[@class='table-responsive']//tbody//tr[2]//td[2]")).getText()))
		//			System.out.println("Student Email is match");
		//		else
		//			System.out.println("Student Email is Not match");
		//
		//		//for Gender	
		//		if(aGender.equals(driver.findElement(By.xpath("//*[@class='table-responsive']//tbody//tr[3]//td[2]")).getText()))
		//			System.out.println("Gender is match");
		//		else
		//			System.out.println("Gender is not match");
		//
		//		//for phone number
		//		if(aPhoneNumber.equals(driver.findElement(By.xpath("//*[@class='table-responsive']//tbody//tr[4]//td[2]")).getText()))
		//			System.out.println("Mobile is match");
		//		else
		//			System.out.println("Mobile is not match");
		//
		//
		//		// for birth of date
		//		if(dob.equals(driver.findElement(By.xpath("//*[@class='table-responsive']//tbody//tr[5]//td[2]")).getText()))
		//			System.out.println("Date of Birth is match");
		//		else
		//			System.out.println("Date of Birth is not match");
		//
		//		//for subject
		//		if(totalSubject.equals(driver.findElement(By.xpath("//*[@class='table-responsive']//tbody//tr[6]//td[2]")).getText()))
		//			System.out.println("Subject is match");
		//		else
		//			System.out.println("Subject is not match");
		//
		//
		//		//for hobby
		//		if(aRHobby.equals(driver.findElement(By.xpath("//*[@class='table-responsive']//tbody//tr[7]//td[2]")).getText()))
		//			System.out.println("Hobbies is match");
		//		else
		//			System.out.println("Hobbies is not match");
		//
		//
		//		//for img
		//		if(fileName.equals(driver.findElement(By.xpath("//*[@class='table-responsive']//tbody//tr[8]//td[2]")).getText()))
		//			System.out.println("img is match");
		//		else
		//			System.out.println("img is not match");
		//
		//
		//		//for aCurrentAddress
		//		if(aCurrentAddress.equals(driver.findElement(By.xpath("//*[@class='table-responsive']//tbody//tr[9]//td[2]")).getText()))
		//			System.out.println("Address is match");
		//		else
		//			System.out.println("Address is not match");
		//
		//		//for stateAndCity
		//		if(stateAndCity.equals(driver.findElement(By.xpath("//*[@class='table-responsive']//tbody//tr[10]//td[2]")).getText()))
		//			System.out.println("State And City is match");
		//		else
		//			System.out.println("State And City is not match");


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

		
	}
}
