package com.kiwiqa.testNGexamples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersExamples 
{

	@Test
	@Parameters("browser")
	public void testParameter(String browser) 
	{
		System.out.println("Browser passed as parameter is: " + browser);
	}
}