package com.kiwiqa.orangehrmstestcase;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import com.kiwiqa.orangehrmpages.MyInfoPage;

public class LoginTestCase {

	public static void main(String[] args) throws AWTException, InterruptedException, IOException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		Actions action = new Actions(driver);

		Robot robot = new Robot();

		MyInfoPage lp =new MyInfoPage(driver,action,robot);

		lp.openUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		lp.zoomIn(2);
		
		// Properties file use
		Properties prop = new Properties();
		File file = new File("config.properties");
		FileInputStream fis = new FileInputStream(file); 
		prop.load(fis);
	
		lp.setUserName(prop.getProperty("userName"));
		Thread.sleep(2000);

		lp.setPassword(prop.getProperty("password"));
		Thread.sleep(2000);

		lp.clickSubmitButton();

		lp.clickMyinfo();

		lp.setFirstName("Vishv");

		lp.setempID("20000");

		lp.setOtherID("30000")
		;
		lp.clickSaveButtonFirst();

		lp.verifySuccessfullyUpdate("Successfully Updated");



	}

}
