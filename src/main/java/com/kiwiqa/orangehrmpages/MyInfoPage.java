package com.kiwiqa.orangehrmpages;

import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MyInfoPage extends LoginPage
{
	//Locators

	By webMyInfo = By.xpath("//span[text()='My Info']");
	By webfirstName= By.xpath("//input[@name='firstName']");
	By webMiddleName= By.xpath("//input[@name='middleName']");
	By webLastName= By.xpath("//input[@name='lastName']");
	By webEmpID =By.xpath("//*[contains(text(),'Employee Id')]/parent::div/following-sibling::div/child::input");
	By webOtherID =By.xpath("//*[contains(text(),'Other Id')]/parent::div/following-sibling::div/child::input");
	By webSaveButtonFirst =By.xpath("//*[text()=' * Required']/parent::div/child::button");


	public MyInfoPage(WebDriver driver, Actions action, Robot robot)
	{
		super(driver, action, robot);

	}

	public static void actionForRemoveText(WebElement e) throws InterruptedException
	{
		Thread.sleep(1000);
		e.click();
		e.sendKeys(Keys.CONTROL + "a");
		e.sendKeys(Keys.BACK_SPACE);
	}


	public void clickMyinfo()
	{
		driver.findElement(webMyInfo).click();
	}

	public void setFirstName(String firstNameValue) throws InterruptedException
	{
		actionForRemoveText(driver.findElement(webfirstName));
		driver.findElement(webfirstName).sendKeys(firstNameValue);
	}

	public void setMiddleName(String middleNameValue) throws InterruptedException
	{
		actionForRemoveText(driver.findElement(webMiddleName));
		driver.findElement(webMiddleName).sendKeys(middleNameValue);
	}

	public void setLastName(String lastNameValue) throws InterruptedException
	{
		actionForRemoveText(driver.findElement(webMiddleName));
		driver.findElement(webLastName).sendKeys(lastNameValue);
	}

	public void setempID(String empIdValue) throws InterruptedException
	{
		actionForRemoveText(driver.findElement(webEmpID));
		driver.findElement(webEmpID).sendKeys(empIdValue);
	}

	public void setOtherID(String otherIdValue) throws InterruptedException
	{
		actionForRemoveText(driver.findElement(webOtherID));
		driver.findElement(webOtherID).sendKeys(otherIdValue);
	}
	public void clickSaveButtonFirst()
	{
		driver.findElement(webSaveButtonFirst).click();
	}
	public void verifySuccessfullyUpdate(String msgValueToVerify)
	{
		String msg =driver.findElement(By.xpath("//*[text()='Successfully Updated']")).getText();
		if(msg.equals(msgValueToVerify))
		{
			System.out.println("Test Case is Pass");
		}
		else
		{
			System.out.println("Test Case is fail");
		}
	}


}
