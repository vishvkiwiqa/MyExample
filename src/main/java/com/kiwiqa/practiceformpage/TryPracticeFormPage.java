package com.kiwiqa.practiceformpage;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TryPracticeFormPage
{
	WebDriver driver;
	Actions action;
	Robot robot;

	// Locators using @FindBy annotations
	@FindBy(xpath="//h1[text()='Practice Form']")
	WebElement formTitle;

	@FindBy(xpath = "//*[@id='firstName']")
	WebElement webFirstName;

	@FindBy(xpath = "//*[@id='lastName']")
	WebElement webLastName;

	@FindBy(xpath = "//*[@id='userEmail']")
	WebElement webEmailID;

	@FindBy(xpath = "//*[text()='Male']")
	WebElement webGenderMale;

	@FindBy(xpath = "//*[@id='userNumber']")
	WebElement webPhoneNumber;

	@FindBy(xpath = "//*[@id='dateOfBirthInput']")
	WebElement webClickBobTextBox;

	@FindBy(xpath = "//select[@class='react-datepicker__year-select']")
	WebElement webYearDrop;

	@FindBy(xpath = "//select[@class='react-datepicker__month-select']")
	WebElement webMonthDrop;

	@FindBy(xpath = "//*[@role='option']")
	WebElement webDateDrop;

	@FindBy(xpath = "//*[@id='subjectsInput']")
	WebElement webClickSubjectTextBox;

	@FindBy(xpath = "//label[text()='Reading']")
	WebElement webReadingHobby;

	@FindBy(xpath = "//*[@id='uploadPicture']")
	WebElement webUploadPic;

	@FindBy(xpath = "//*[@id='currentAddress']")
	WebElement webCurrentAddress;

	@FindBy(xpath = "//*[@id='state']/child::div")
	WebElement webClickState;

	@FindBy(xpath = "//*[@id='city']/child::div")
	WebElement webClickCity;

	@FindBy(xpath = "//*[@id='submit']")
	WebElement webClickSubmit;

	// Constructor to initialize the driver
	public TryPracticeFormPage(WebDriver driver, Actions action, Robot robot) {
		this.driver = driver;
		this.action = action;
		this.robot = robot;
		PageFactory.initElements(driver, this);
	}

	public void maximizeWindo()
	{
		driver.manage().window().maximize();
	}
	public void impWait(int waitSeconds)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitSeconds));
	}
	public void zoomIn(int n) {
		for (int i = 0; i < n; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
	}

	public void scrollToFormTitle()
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", formTitle);
	}
	public String getCellData(String excelFilePath,String sheetName, String keyValue) throws IOException
	{
		FileInputStream inputStream =new FileInputStream(excelFilePath);
		try (XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {
			XSSFSheet sheet = workbook.getSheetAt(0);
			int rows = sheet.getLastRowNum();
			DataFormatter formatter = new DataFormatter();
			HashMap<String, String> map = new HashMap<>();


			for(int r= 0;r<=rows;r++)
			{
				XSSFRow row = sheet.getRow(r);
				XSSFCell key =row.getCell(0);
				String str = formatter.formatCellValue(key);
				XSSFCell value =row.getCell(1);
				String str1 = formatter.formatCellValue(value);
				map.put(str,str1);	
			}

			return map.get(keyValue);
		}  
	}

	public void openUrl(String webUrl) {
		driver.get(webUrl);
	}

	// Method to set the first name 
	public void setFirstName(String firstNameValue) {
		webFirstName.sendKeys(firstNameValue);
	}

	// Method to set the last name
	public void setLastName(String lastNameValue) {
		webLastName.sendKeys(lastNameValue);
	}

	// Method to set the email ID
	public void setEmailID(String emailIDValue) {
		webEmailID.sendKeys(emailIDValue);
	}

	// Method to click the male gender radio button
	public void setGender(String gender) {
		driver.findElement(By.xpath("//*[text()='Gender']/following::div/descendant::label[text()='"+gender+"']")).click();
	}

	// Method to set the phone number
	public void setPhoneNumber(String phoneNumberValue) {
		webPhoneNumber.sendKeys(phoneNumberValue);
	}

	public void clickDobTextField() {
		webClickBobTextBox.click();
	}

	public void setYear(String yearName) {
		Select selectYears = new Select(webYearDrop);
		selectYears.selectByVisibleText(yearName);
	}

	public void setMonth(String monthNameValue) {
		Select selectMonth = new Select(webMonthDrop);
		selectMonth.selectByVisibleText(monthNameValue);
	}

	public void setDate(String dateValue) {
		List<WebElement> allDates = driver.findElements(By.xpath("//*[@role='option']"));
		for (WebElement obj : allDates) {
			if (obj.getText().equals(dateValue)) {
				obj.click();
				break;
			}
		}
	}
	//SetSubject
	public void setSubject(String subject1Value, String subject2Value) {
		webClickSubjectTextBox.click();
		action.sendKeys(subject1Value, Keys.ENTER).perform();
		action.sendKeys(subject2Value, Keys.ENTER).perform();
	}

	//setHobby
	public void setHobby(String hobby)
	{
		driver.findElement(By.xpath("//*[text()='Hobbies']/following::div/descendant::label[text()='"+hobby+"']")).click();
	}

	public void setPic(String picName) {
		webUploadPic.sendKeys("C:\\Users\\Anmol\\Downloads\\" + picName);
	}

	public void setCurrentAddress(String currentAddressValue) {
		webCurrentAddress.sendKeys(currentAddressValue);
	}

	public void setState(String stateNameValue) {
		webClickState.click();
		action.sendKeys(stateNameValue, Keys.ENTER).perform();
	}

	public void setCity(String cityNameValue) {
		webClickCity.click();
		action.sendKeys(cityNameValue, Keys.ENTER).perform();
	}

	public void clickSubmitButton() {
		webClickSubmit.click();
	}

	public void verifyText(ArrayList<Object> objValue) {
		for (int i = 0; i < objValue.size(); i++) {
			String actualText = driver.findElement(By.xpath("//tbody//tr[" + (i + 1) + "]//td[last()]")).getText();
			String fieldName = driver.findElement(By.xpath("//tbody//tr[" + (i + 1) + "]//td[1]")).getText();
			if (objValue.get(i).equals(actualText)) {
				System.out.println("Value matches for: " + fieldName);
			} else {
				System.out.println("Value does not match for: " + fieldName);
			}
		}
	}
}
