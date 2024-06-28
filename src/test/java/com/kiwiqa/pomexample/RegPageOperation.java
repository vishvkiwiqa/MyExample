package com.kiwiqa.pomexample;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegPageOperation
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
	public void regForm() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		RegPageElementIdentification reg = new RegPageElementIdentification(driver);
		driver.get("https://demo.guru99.com/selenium/newtours/register.php");
		Thread.sleep(2000);
		reg.setFirstName("Vishv");
		Thread.sleep(2000);
		reg.setLastName("Patel");
		
	}

}
