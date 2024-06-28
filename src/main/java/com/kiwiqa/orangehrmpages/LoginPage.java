package com.kiwiqa.orangehrmpages;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public abstract class LoginPage
{
	WebDriver driver;
	Actions action;
	Robot robot;
	
	// Locators
	By webUserName = By.xpath("//input[@name='username' or @placeholder='username']");
	By webPassword = By.xpath("//input[@name='password' or @placeholder='password']");
	By webSubmitButton = By.xpath("//button[@type='submit']");

	public void openUrl(String webUrl)
	{
		driver.get(webUrl);
	}

	public LoginPage(WebDriver driver,Actions action,Robot robot)
	{
		this.driver = driver;
		this.action =action;
		this.robot =robot;	
	}
	public void zoomIn(int n)
	{
		for (int i = 0; i <n; i++) 
		{
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
	}

	public void setUserName(String userNameValue)
	{
		driver.findElement(webUserName).sendKeys(userNameValue);
	}
	public void setPassword(String passwordValue)
	{
		driver.findElement(webPassword).sendKeys(passwordValue);
	}
	public void clickSubmitButton()
	{
		driver.findElement(webSubmitButton).click();
	}



}
