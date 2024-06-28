package com.kiwiqa.testNGexamples;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGMethodExample2
{
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("This is  BeforSuite method2 ");
	}

	@AfterSuite
	public void afterSuite()
	{
		System.out.println("This is  AfterSuite method 2 ");
	}


	@BeforeTest
	public void beforeTest2()
	{
		System.out.println("This is  BeforTest2");
	}

	@AfterTest
	public void afterTest2()
	{
		System.out.println("This is  AfterTest2 method ");
	}

	@BeforeClass
	public void beforeClass2()
	{
		System.out.println("This is  BeforClass2 method ");
	}

	@AfterClass
	public void afterClass2()
	{
		System.out.println("This is  Afterclass2 method ");
	}

	@BeforeMethod
	public void beforeMethod2()
	{
		System.out.println("This is  Befor method2 ");
	}

	@AfterMethod
	public void afterMethod2()
	{
		System.out.println("This is  After method 2 ");
	}


	@Test
	public void signup()
	{
		System.out.println("This is method signup");
	}

	@Test(priority = 1)
	public void home()
	{
		System.out.println("This is method home");
	}
	@Test(priority = 1)
	public void login()
	{
		System.out.println("This is method login");
	}
}
