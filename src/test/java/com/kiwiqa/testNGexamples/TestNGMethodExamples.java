package com.kiwiqa.testNGexamples;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class TestNGMethodExamples
{
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("This is  BeforSuite method ");
	}

	@AfterSuite
	public void afterSuite()
	{
		System.out.println("This is  AfterSuite method ");
	}

	@BeforeTest
	public void beforeTest()
	{
		System.out.println("This is  BeforTest method ");
	}

	@AfterTest
	public void afterTest()
	{
		System.out.println("This is  AfterTest method ");
	}

	@BeforeClass
	public void beforeClass()
	{
		System.out.println("This is  BeforClass method ");
	}

	@AfterClass
	public void afterClass()
	{
		System.out.println("This is  Afterclass method ");
	}

	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("This is  Befor method ");
	}

	@AfterMethod
	public void afterMethod()
	{
		System.out.println("This is  After method ");
	}

	@Test
	public void update()
	{
		System.out.println("This is method update");
	}

	@Test(priority = 1)
	public void delete()
	{
		System.out.println("This is method delete");
		Reporter.log("Comp Pass");
	}

}
