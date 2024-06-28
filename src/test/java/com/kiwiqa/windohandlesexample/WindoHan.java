package com.kiwiqa.windohandlesexample;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindoHan {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div[2]/button")).click();
		Set<String> currWindo = driver.getWindowHandles();


		List<String> windoList = new ArrayList<>(currWindo);
		String parID = windoList.get(0);
		String childID = windoList.get(1);
		driver.switchTo().window(childID);



		String str = driver.findElement(By.xpath("//*[@id='sampleHeading']")).getText();
		System.out.println(" Text is Displayed In Page : " + str);
		driver.close();
		driver.switchTo().window(parID);
		if(driver.getTitle().equals("DEMOQA"))
		{
			System.out.println("getWindowHandlesExmaple is Pass");
		}
		else
		{
			System.out.println("getWindowHandlesExmaple is Pass");
		}


	}

}
