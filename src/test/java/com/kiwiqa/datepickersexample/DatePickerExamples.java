package com.kiwiqa.datepickersexample;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DatePickerExamples 
{
	static WebDriver driver;

	@BeforeMethod
	public void openBrowser()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}

	@Test
	public void dataPickerDemo() throws InterruptedException
	{
		driver.get("https://demoqa.com/date-picker");
		LocalDate currentDate = LocalDate.now();

		// Get the day of the month
		int day = currentDate.getDayOfMonth();

		// Get the full name of the month (e.g., "January")
		String monthName = currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

		// Get the year
		int cyear = currentDate.getYear();

		WebElement cdate = driver.findElement(By.xpath("//*[@id=\"datePickerMonthYearInput\"]"));
		Thread.sleep(1000);
		cdate.click();
		cdate.sendKeys(Keys.CONTROL + "a");
		cdate.sendKeys(Keys.BACK_SPACE);



		String year=Integer.toString(cyear);;
		String month= monthName;
		String date =Integer.toString(day);
		driver.findElement(By.xpath("//*[@id='datePickerMonthYearInput']")).click();
		while(true)
		{
			String  title = driver.findElement(By.xpath("//*[@id=\"datePickerMonthYear\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[1]")).getText();
			String a[] =title.split(" ");
			String mm =a[0];
			String yr =a[1]; 

			if(mm.equalsIgnoreCase(month) && yr.equalsIgnoreCase(year))
			{
				break;
			}
			else
			{
				driver.findElement(By.xpath("//*[@id=\"datePickerMonthYear\"]/div[2]/div[2]/div/div/button[2]")).click();
			}
		}
		List<WebElement> str=  driver.findElements(By.xpath("//*[@role='option']"));
		for(WebElement obj : str)
		{
			String text = obj.getText();
			if(text.equals(date))
			{
				obj.click();
				break;
			}

		}

		Thread.sleep(3000);
	}
}
