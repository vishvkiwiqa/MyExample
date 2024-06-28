package com.kiwiqa.windohandlesexample;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiWindo {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/browser-windows");
		driver.findElement(By.xpath("//button[@id=\"messageWindowButton\"]")).click();
		Set<String> currentWindow = driver.getWindowHandles();
		
		//String currentWindow = driver.getWindowHandle();
		for (String windowHandle : driver.getWindowHandles()) 
		{
			String title = driver.switchTo().window(windowHandle).getTitle();
			System.out.println(title);
		}
		
		
		
		//String text = driver.findElement(By.tagName("/html/body/text()")).getText();
		//System.out.println("Text from about:blank page: " + text);

	}

}
