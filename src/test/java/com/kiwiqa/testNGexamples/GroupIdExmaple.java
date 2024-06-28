package com.kiwiqa.testNGexamples;

import org.testng.annotations.Test;

public class GroupIdExmaple 
{

	@Test(groups = {"smoke"}, priority = 2)
	public void method3()
	{
		System.out.println("This is method 3");
	}
	
	@Test(groups = {"smoke","smoke1"}, priority = 1)
	public void method4()
	{
		System.out.println("This is method 4");
	}
}
