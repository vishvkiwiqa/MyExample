package com.kiwiqa.sliderexamples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SliderExamples
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
	public void sliderDemo() throws InterruptedException
	{
		driver.get("https://jqueryui.com/slider/");
		WebElement iframe = driver.findElement(By.xpath("//*[@id='content']/iframe"));
		driver.switchTo().frame(iframe);
		Thread.sleep(3000);
		WebElement resizeElement = driver.findElement(By.xpath("//*[@id='slider']/span"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(resizeElement, 100, 0).perform();
		Thread.sleep(3000);
	}
	@Test
	public void sliderDemo1() throws InterruptedException
	{
		driver.get("https://demoqa.com/slider");
		Thread.sleep(3000);
		WebElement sliderElement = driver.findElement(By.xpath("//div[@id='sliderContainer']//child::input[@class='range-slider range-slider--primary']"));

		//System.out.println(sliderElement.getLocation()); // Defult (418, 523)
		Actions action = new Actions(driver);
		action.dragAndDropBy(sliderElement, 100,0).perform();

		WebElement sliderValue = driver.findElement(By.xpath("//*[@id=\"sliderContainer\"]/div[1]/span/input"));
		String textInSlider =  sliderValue.getAttribute("value");
		System.out.println(textInSlider);

		Thread.sleep(3000);
		WebElement textBoxSliderValue = driver.findElement(By.xpath("//*[@id='sliderValue']"));
		String textBoxSliderValueLocated =  textBoxSliderValue.getAttribute("value");
		System.out.println(textBoxSliderValueLocated);

		if(textInSlider.equals(textBoxSliderValueLocated))
		{
			System.out.println("sliderDemo1 Testcase Is Pass");
		}
		else
		{
			System.out.println("sliderDemo1 Testcase Is fail");
		}
		Thread.sleep(3000);
	}
	@Test
	public void progressBarDemo() throws InterruptedException
	{

		driver.get("https://demoqa.com/progress-bar");
		Thread.sleep(3000);
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("window.scrollBy(0,150);");

		driver.findElement(By.xpath("//button[@id='startStopButton']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='startStopButton']")).click();
		WebElement progressBarCurrentValue = driver.findElement(By.xpath("//*[@id=\"progressBar\"]/div"));
		String textInMinSlider = progressBarCurrentValue.getAttribute("aria-valuenow");
		System.out.println("Progress bar value is : "+textInMinSlider);
		Thread.sleep(3000);
	}

}



