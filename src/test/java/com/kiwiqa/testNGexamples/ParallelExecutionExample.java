package com.kiwiqa.testNGexamples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ParallelExecutionExample
{
	WebDriver driver;
	
	@Test
	public void test1()
	{
	driver= new ChromeDriver();
	driver.get("https://www.google.com/");
	}
	
	@Test
	public void test2()
	{
	driver= new ChromeDriver();
	driver.get("https://demoqa.com/");
	}
	
	
}
