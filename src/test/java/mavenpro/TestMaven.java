package mavenpro;

import org.openqa.selenium.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
//import java.util.ArrayList;
import java.util.List;
//import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.FluentWait;


public class TestMaven {

	public static void main(String[] arg) throws MalformedURLException, InterruptedException
	{
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	

		driver.get("https://www.nopcommerce.com/en");
		List<WebElement> links = driver.findElements(By.xpath("/html/body/div[7]/footer//a"));
		System.out.println("Total number of web  element is find : " +links.size());

		for(WebElement ele : links)
		{
			String obj = ele.getText();
			System.out.println(obj);
			if(obj.equals("Showcase"))
			{
				ele.click();
				break;
			}

		}

		// TestCase For Check Web Title (Test Case :1)
		driver.get("https://www.orangehrm.com/");	
		if(driver.getTitle().equals("Human Resources Management Software | OrangeHRM"))
		{
			System.out.println("TestCase 1 IS Pass");
		}
		else
		{
			System.out.println("TestCase 1 Is Fail");
		}

		// Navigate Exmaple (Test Case :3)
		URL myUrl1 = new URL("https://www.google.com/");
		driver.navigate().to(myUrl1);
		driver.navigate().to("https://www.kiwiqa.com/");
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
		driver.navigate().refresh();
		driver.navigate().forward();
		System.out.println(driver.getCurrentUrl());
		driver.navigate().refresh();
		if(driver.getTitle().equals("Home | Software and Quality Assurance Testing Services | KiwiQA"))
		{	
			System.out.println("Test Case 3 is Pass");
		}
		else 
		{
			System.out.println("Test Case 3 is Fail");
		}

		//Alerts handling
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li[1]/button")).click();

		driver.switchTo().alert().accept();


		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li[2]/button")).click();
		driver.switchTo().alert().accept();


		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li[2]/button")).click();
		driver.switchTo().alert().dismiss();


		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();
		Alert alertWindo = driver.switchTo().alert();
		System.out.println("Your Pop-up Msg Is "+alertWindo.getText());	
		alertWindo.sendKeys("Hello Vishv");
		alertWindo.accept();	
		// provide value on web
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
        //iframe example
		driver.get("https://demo.automationtesting.in/Frames.html");
		driver.switchTo().frame("singleframe");
		driver.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("This is Vishv");
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("/html/body/section/div[1]/div/div/div/div[1]/div/ul/li[2]/a")).click();

		WebElement outerFrame= driver.findElement(By.xpath("//*[@id=\"Multiple\"]/iframe"));
		driver.switchTo().frame(outerFrame);

		WebElement innerFrame= driver.findElement(By.xpath("/html/body/section/div/div/iframe"));
		driver.switchTo().frame(innerFrame);
		driver.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("Vishv Patel");


		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
		driver.switchTo().frame("iframeResult");

		WebElement innerFrame1= driver.findElement(By.xpath("/html/body/iframe"));
		driver.switchTo().frame(innerFrame1);
		System.out.println("Inner frame Heading Text is : "+driver.findElement(By.xpath("/html/body/h1")).getText());

		driver.switchTo().parentFrame();
		System.out.println("Outer  frame Heading Text is : "+driver.findElement(By.xpath("/html/body/p")).getText());

		// Wait Example

		//		// Define a FluentWait instance with a maximum timeout of 30 seconds
		//        FluentWait<WebDriver> fWait = new FluentWait<>(driver)
		//            .withTimeout(Duration.ofSeconds(30))
		//            .pollingEvery(Duration.ofSeconds(5)) // Check for the condition every 5 seconds
		//            .ignoring(NoSuchElementException.class); // Ignore NoSuchElementException during the wait
		//
		//        // Use the until() method along with an ExpectedCondition to wait until the condition is met
		//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//        WebElement txtUsername = fWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("//input[@placeholder='Username']")));
		//        txtUsername.sendKeys("vishv");

		//Window handles Test Case (Test Case :2)
		//		driver.get("https://www.kiwiqa.com/");
		//		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/div/div/div[2]/ul/li[3]/a/i")).click();
		//		Set<String> windoIDs = driver.getWindowHandles();
		//		List<String> windoList = new ArrayList<>(windoIDs);
		//		String parID = windoList.get(0);
		//		String childID = windoList.get(1);
		//		driver.switchTo().window(childID);
		//		if(driver.getTitle().equals("KiwiQA Services | LinkedIn"))
		//		{
		//			System.out.println("TestCase 2 Is Pass");	
		//		}
		//		else
		//		{
		//			System.out.println("TestCase 2 Is Fail");
		//		}

	}
}


