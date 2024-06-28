package com.kiwiqa.testNGexamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependentTestsExamples 
{
	@Test
	public void a()
	{
		System.out.println(" a ");
	}
	@Test
	public void b()
	{
		Assert.assertTrue(2 > 4);
	}

	@Test(dependsOnMethods = {"b"})
	public void c()
	{
		System.out.println("Test Two");
	}
}