package mavenpro;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class DatePicker {

	public static void main(String[] args) 
	{
		WebDriver driver= new ChromeDriver();
		String month ="July";
		String year ="2024";
		String date = "5";
		driver.get("https://demoqa.com/date-picker");
		
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='datePickerMonthYearInput']")));
       
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", input);
        input.click();
       
        WebElement monthField = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
        monthField.click();
       
        driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']/option[contains(text(), '" + month + "')]")).click();
        driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']/option[contains(text(), '" + year + "') ]")).click();
        driver.findElement(By.xpath("//div[@class='react-datepicker__month']//div[contains(text(), '"+ date+ "') and contains(@aria-label, '"+ month +"')]   ")).click();

	}

}
