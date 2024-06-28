package com.kiwiqa.orangehrmpages;

import static org.testng.Assert.assertEquals;
import java.awt.Robot;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyInfoPageMethod2 extends LoginPageMethod2 {

	// Locators using @FindBy
	@FindBy(xpath = "//span[text()='My Info']")
	WebElement webMyInfo;

	@FindBy(xpath = "//input[@name='firstName']")
	WebElement webFirstName;

	@FindBy(xpath = "//input[@name='middleName']")
	WebElement webMiddleName;

	@FindBy(xpath = "//input[@name='lastName']")
	WebElement webLastName;

	@FindBy(xpath = "//*[contains(text(),'Employee Id')]/parent::div/following-sibling::div/child::input")
	WebElement webEmpID;

	@FindBy(xpath = "//*[contains(text(),'Other Id')]/parent::div/following-sibling::div/child::input")
	WebElement webOtherID;

	@FindBy(xpath = "//*[text()=' * Required']/parent::div/child::button")
	WebElement webSaveButtonFirst;

	public MyInfoPageMethod2 (WebDriver driver, Actions action, Robot robot) {
		super(driver, action, robot);
		PageFactory.initElements(driver, this);
	}


	public static void actionForRemoveText(WebElement e) throws InterruptedException {
		Thread.sleep(1000);
		e.click();
		e.sendKeys(Keys.CONTROL + "a");
		e.sendKeys(Keys.BACK_SPACE);
	}

	public void clickMyinfo() {
		webMyInfo.click();
	}

	public void setFirstName(String firstNameValue) throws InterruptedException {
		actionForRemoveText(webFirstName);
		webFirstName.sendKeys(firstNameValue);
	}

	public void setMiddleName(String middleNameValue) throws InterruptedException {
		actionForRemoveText(webMiddleName);
		webMiddleName.sendKeys(middleNameValue);
	}

	public void setLastName(String lastNameValue) throws InterruptedException {
		actionForRemoveText(webLastName);
		webLastName.sendKeys(lastNameValue);
	}

	public void setEmpID(String empIdValue) throws InterruptedException {
		actionForRemoveText(webEmpID);
		webEmpID.sendKeys(empIdValue);
	}

	public void setOtherID(String otherIdValue) throws InterruptedException {
		actionForRemoveText(webOtherID);
		webOtherID.sendKeys(otherIdValue);
	}

	public void clickSaveButtonFirst() throws InterruptedException {
		webSaveButtonFirst.click();
		Thread.sleep(3);
	}

	public void verifySuccessfullyUpdate(String msgValueToVerify) throws InterruptedException
	{
		WebElement msgElement = driver.findElement(By.xpath("//*[text()='Successfully Updated']"));
		String msg = msgElement.getText();
		assertEquals(msg,msgValueToVerify);
		Thread.sleep(2000);

		
	}
}
