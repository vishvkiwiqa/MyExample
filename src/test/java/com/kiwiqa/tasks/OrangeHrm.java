package com.kiwiqa.tasks;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import javax.swing.Action;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHrm
{
	static void  actionForRemoveText(WebElement e) throws InterruptedException
	{
		Thread.sleep(1000);
		e.click();
		e.sendKeys(Keys.CONTROL + "a");
		e.sendKeys(Keys.BACK_SPACE);
	}

	public static void main(String[] args) throws InterruptedException, AWTException
	{


		WebDriver driver = new ChromeDriver();
		Actions action = new Actions(driver);
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(12));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		Robot robot = new Robot();
		for (int i = 0; i <2; i++) 
		{
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}

		//WebElement txtUsername = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		WebElement user =driver.findElement(By.xpath("//input[@placeholder='Username']"));
		WebElement txtUsername = myWait.until(ExpectedConditions.visibilityOf(user));
		txtUsername.sendKeys("Admin");

		Thread.sleep(2000);

		WebElement txtPassword = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
		txtPassword.sendKeys("admin123");
		Thread.sleep(2000);

		WebElement submitBtn = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
		submitBtn.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='My Info']")).click();


		//For FirstName
		WebElement  firstName = driver.findElement(By.xpath("//input[@name='firstName']"));
		actionForRemoveText(firstName);
		firstName.sendKeys("vishv");

		//For Middle Name
		WebElement  middleName = driver.findElement(By.xpath("//input[@name='middleName']"));
		actionForRemoveText(middleName);
		middleName.sendKeys("Kumar");

		//For Last Name
		WebElement  lastName = driver.findElement(By.xpath("//input[@name='lastName']"));
		actionForRemoveText(lastName);
		lastName.sendKeys("Patel");

		//For emp ID  
		WebElement  empID = driver.findElement(By.xpath("//*[contains(text(),'Employee Id')]/parent::div/following-sibling::div/child::input"));
		actionForRemoveText(empID);
		empID.sendKeys("51000");


		//For other ID  
		WebElement  otherID = driver.findElement(By.xpath("//*[contains(text(),'Other Id')]/parent::div/following-sibling::div/child::input"));
		actionForRemoveText(otherID);
		otherID.sendKeys("520000");


		driver.findElement(By.xpath("//*[text()=' * Required']/parent::div/child::button")).click();

		String  msg =driver.findElement(By.xpath("//*[text()='Successfully Updated']")).getText();
		if(msg.equals("Successfully Updated"))
		{
			System.out.println("Test Case is Pass");
		}
		else
		{
			System.out.println("Test Case is fail");
		}


	}

}
