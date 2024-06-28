package com.kiwiqa.pomexample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegPageElementIdentification 
{


	WebDriver driver;

	By firstName = By.xpath("//input[@name='firstName']");
	By lastName = By.xpath("//input[@name='lastName']");
	

	RegPageElementIdentification(WebDriver d)
	{
		driver=d;
	}

	public void setFirstName(String firstNameValue)
	{
		driver.findElement(firstName).sendKeys(firstNameValue);
	}

	public void setLastName(String lastNameValue)
	{
		driver.findElement(lastName).sendKeys(lastNameValue);
	}
	
}
