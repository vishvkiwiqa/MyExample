package com.kiwiqa.testNGexamples;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertExamples 
{
	static WebDriver driver;

	@BeforeMethod
	public void openBrowser()
	{
		driver=new EdgeDriver();
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
	@Test
	public void testAssertions()
	{

		assertEquals(6, 5,"fail");
		
	}
	@Test
	public void testAssertions1()
	{
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(1, 5);
		Reporter.log("Comp Pass");
		System.out.println("fail");
		sa.assertAll();
	}

	@Test(description = " verify login")
	public void loginTestCase1() throws InterruptedException
	{
		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(12));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebElement txtUsername = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		//WebElement user =driver.findElement(By.xpath("//input[@placeholder='Username']"));
		//WebElement txtUsername = myWait.until(ExpectedConditions.visibilityOf(user));
		txtUsername.sendKeys("Admin");

		Thread.sleep(3000);

		WebElement txtPassword = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
		txtPassword.sendKeys("admin123");
		Thread.sleep(3000);


		WebElement submitBtn = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
		submitBtn.click();
		Thread.sleep(3000);
		String url=driver.getCurrentUrl();
		assertEquals(url,"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
		Reporter.log("Login Pass");
		

	}
}

