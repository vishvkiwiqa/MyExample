package com.kiwiqa.actionsclassmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsClassMethods 
{
	static WebDriver driver;
	static Actions action;

	@BeforeMethod
	public void openBrowser()
	{
		driver=new ChromeDriver();
		action = new Actions(driver);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}

	@Test
	public void rightClickExample() throws InterruptedException
	{
		driver.get("https://www.google.com/");
		WebElement webElementToClick = driver.findElement(By.xpath("//*[@id='APjFqb']"));
		action.contextClick(webElementToClick).perform();
		Thread.sleep(3000);
	}

	@Test
	public void doubleClickExample() throws InterruptedException
	{
		driver.get("https://demo.guru99.com/test/tooltip.html");
		WebElement webElementToClick = driver.findElement(By.xpath("//*[@id=\"demo_content\"]/div/p[3]/samp[2]"));


		action.doubleClick(webElementToClick).perform();
		Thread.sleep(3000);
	}

	@Test
	public void dragAndDropDemo() throws InterruptedException
	{
		driver.get("https://demoqa.com/droppable");
		WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
		WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));

		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("window.scrollBy(0,150);");

		action.dragAndDrop(drag, drop).perform();

		String afterDropText = driver.findElement(By.xpath("//*[@id='droppable']/p")).getText();
		if(afterDropText.equals("Dropped!"))
		{
			System.out.println("dragAndDropDemo Testcase IS pass ");
		}
		else
		{
			System.out.println("dragAndDropDemo Testcase IS Fail ");
		}
		Thread.sleep(3000);
	}

	@Test
	public void multiSelect() throws InterruptedException
	{

		driver.get("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
		WebElement carDropManu =driver.findElement(By.xpath("//select[@name='States']"));
		Select carDropmanuOption = new Select(carDropManu);
		System.out.println("Se");
		carDropmanuOption.selectByIndex(2);
		carDropmanuOption.selectByIndex(3);
		Thread.sleep(3000);
		carDropmanuOption.deselectAll();
		Thread.sleep(3000);
		carDropmanuOption.selectByIndex(1);
		carDropmanuOption.selectByIndex(4);
		System.out.println("multiSelectExample is pass ");
	}

	@Test
	public void iframeDemo() throws InterruptedException
	{
		driver.get("https://demo.automationtesting.in/Frames.html");
		driver.switchTo().frame("singleframe");
		driver.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("This is Vishv");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("/html/body/section/div[1]/div/div/div/div[1]/div/ul/li[2]/a")).click();
		Thread.sleep(3000);
		WebElement outerFrame= driver.findElement(By.xpath("//*[@id='Multiple']/iframe"));
		driver.switchTo().frame(outerFrame);

		WebElement innerFrame= driver.findElement(By.xpath("/html/body/section/div/div/iframe"));
		driver.switchTo().frame(innerFrame);
		driver.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("Vishv Patel");
		Thread.sleep(3000);
	}

	@Test
	public void iframeNestedDemo() throws InterruptedException
	{
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
		driver.switchTo().frame("iframeResult");
		Thread.sleep(3000);
		//WebElement innerFrame1= driver.findElement(By.xpath("/html/body/iframe"));
		driver.switchTo().frame(0);
		System.out.println("Inner frame Heading Text is : "+driver.findElement(By.xpath("/html/body/h1")).getText());
		Thread.sleep(3000);
		driver.switchTo().parentFrame();
		System.out.println("Outer  frame Heading Text is : "+driver.findElement(By.xpath("/html/body/p")).getText());
		Thread.sleep(3000);
	}

	@Test
	public void resizeDemo() throws InterruptedException
	{
		driver.get("https://jqueryui.com/resizable/");
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(iframe);
		Thread.sleep(3000);
		WebElement resizeElement = driver.findElement(By.xpath("//*[@id='resizable']/div[3]"));
		action.dragAndDropBy(resizeElement, 300, 100).perform();
		Thread.sleep(3000);
	}

	@Test
	public void toolTipExample() throws InterruptedException
	{
		driver.get("https://www.w3schools.com/css/tryit.asp?filename=trycss_tooltip_top");
		driver.switchTo().frame("iframeResult");
		WebElement  toolTip =driver.findElement(By.xpath("/html/body/div"));
		action.moveToElement(toolTip).perform();
		System.out.println(driver.findElement(By.xpath("/html/body/div/span")).getText());
		Thread.sleep(3000);

	}

	@Test
	public void modalDialogsExamples() throws InterruptedException
	{
		driver.get("https://demoqa.com/modal-dialogs");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='showSmallModal']")).click();
		Thread.sleep(2000);
		String textSmall =driver.findElement(By.xpath("//div[@class='modal-body']")).getText();
		Thread.sleep(2000);
		System.out.println(textSmall);
		driver.findElement(By.xpath("//*[@id='closeSmallModal']")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='showLargeModal']")).click();
		Thread.sleep(2000);
		String textLarge =driver.findElement(By.xpath("//*[@class='modal-body']/p")).getText();
		Thread.sleep(2000);
		System.out.println(textLarge);
		driver.findElement(By.xpath("//*[@id='closeLargeModal']")).click();

	}



	@Test
	public void subMenuDemo() throws InterruptedException
	{
		driver.get("https://demoqa.com/menu");
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("window.scrollBy(0,250);");
		action.moveToElement(driver.findElement(By.xpath("//*[text()='Main Item 2']"))).perform();
		Thread.sleep(3000);
		action.moveToElement(driver.findElement(By.xpath("//*[text()='SUB SUB LIST »']"))).perform();
		Thread.sleep(3000);
		action.moveToElement(driver.findElement(By.xpath("//*[text()='Sub Sub Item 2']"))).perform();
		Thread.sleep(4000);
		String str = driver.findElement(By.xpath("//*[text()='Sub Sub Item 2']")).getText();
		Thread.sleep(3000);
		System.out.println("Text Is : " + str );
		Thread.sleep(3000);
		if(str.equals("Sub Sub Item 2"))
		{
			System.out.println("subMenuDemo Testcase is pass ");
		}
		else
		{
			System.out.println("subMenuDemo Testcase is Fail");
		}
	}
}
