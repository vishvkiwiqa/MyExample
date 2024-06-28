package com.kiwiqa.pomexample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegPageElementIdentificationMethod2 
{

	WebDriver driver;

	@FindBy(how = How.XPATH, using = "//input[@name='firstName']" )
	WebElement firstName;

	@FindBy(how = How.XPATH, using = "//input[@name='lastName']" )
	WebElement lastName;

	RegPageElementIdentificationMethod2(WebDriver d)
	{
		driver = d;
	}

	public void setFirstName(String firstNameValue)
	{
		firstName.sendKeys(firstNameValue);
	}
	public void setLastName(String lastNameValue)
	{
		firstName.sendKeys(lastNameValue);
	}

}
