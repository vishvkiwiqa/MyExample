package com.kiwiqa.testNGexamples;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExamples 
{

	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() 
	{
		return new Object[][]
				{
			{"data1"}, {"data2"}, {"data3"}
				};
	}

	@Test(dataProvider = "data-provider")
	public void testMethod(String data)
	{
		System.out.println("Data: " + data);
	}
	
	//another way
	@DataProvider(name = "data-provider1")
	public Object[][] dataSet()
	{
		Object[][] dataset = new Object[2][2];
		
		dataset[0][0]="u1";
		dataset[0][1]="p1";
		
		dataset[1][0]="u2";
		dataset[1][1]="p2";
		
		return dataset;
		
	} 

	@Test(dataProvider = "data-provider1")
	public void testMethod1(String uname, String pass)
	{
		System.out.println(uname + " " + pass);
	}
}
