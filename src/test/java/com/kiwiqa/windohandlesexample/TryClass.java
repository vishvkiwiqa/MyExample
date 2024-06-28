package com.kiwiqa.windohandlesexample;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TryClass {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		String currentWindow = driver.getWindowHandle();
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://demo.automationtesting.in/");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://demo.automationtesting.in/Register.html");
		
		Set <String> s = driver.getWindowHandles();
		
		
//		for (String windowHandle : driver.getWindowHandles()) 
//		{
//		    if (!windowHandle.equals(currentWindow)) 
//		    {
//		        driver.switchTo().window(windowHandle);
//		        break;
//		    }
//		}
		
		driver.get("https://demo.automationtesting.in/DynamicData.html");

	}

}
