package com.kiwiqa.pomexample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegPageOperationMethod2 
{
	static WebDriver driver;

	@BeforeMethod
	public void openBrowser()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void closeBrowser()
	{
		//driver.quit();
	}


	@Test
	public void regForm()
	{

		RegPageElementIdentificationMethod2 reg = new RegPageElementIdentificationMethod2(driver);
		driver.get("https://demo.guru99.com/selenium/newtours/register.php");
		reg.setFirstName("Vishv");
		reg.setLastName("Patel");
	}

}
