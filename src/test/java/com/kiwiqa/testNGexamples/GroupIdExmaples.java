package com.kiwiqa.testNGexamples;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class GroupIdExmaples 
{

	@Test(groups = {"smoke1"})
	public void method1()
	{
		System.out.println("This is method 1");
		assertEquals(1, 2);
	}

	
	@Test(groups = {"smoke"})
	public void method2()
	{
		System.out.println("This is method 2");
	}
	@Test(dependsOnGroups = "smoke1" ,groups = "navigate")
	public void method5()
	{
		System.out.println("This is method 5");
	}
	
}
