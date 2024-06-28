package com.kiwiqa.testNGexamples;

import java.awt.AWTException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTesting 
{
	WebDriver driver;

	@Parameters("browser")
	@BeforeMethod
	public void openBrowser(String browser) throws AWTException 
	{
		if (browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if (browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();

			driver.manage().window().maximize();
		}
	}

	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException
	{
		driver.get("https://www.google.com/");
		Thread.sleep(5000);
	}

}
