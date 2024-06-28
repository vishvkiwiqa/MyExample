package com.kiwiqa.testNGexamples;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProviderWithTestNGExcle
{

	@Test(dataProvider = "data-provider1")
	public void testMethod1(String uname, String pass) {
		System.out.println(uname + " " + pass);
	}

	@DataProvider(name = "data-provider1")
	public Object[][] testData() throws IOException {
		String excelFilePath = "C:\\Users\\Anmol\\Downloads\\DataProWithTestNG.xlsx";
		FileInputStream inputStream = new FileInputStream(excelFilePath);

		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheetAt(0);

		DataFormatter formatter = new DataFormatter();

		int rows = sheet.getLastRowNum(); // Get the number of rows (0-based index)
		int cols = sheet.getRow(0).getLastCellNum(); // Get the number of columns

		Object[][] data = new Object[rows][cols]; // Adjust array size for data rows

		// Populate data array with values from the Excel file, starting from row 1
		for (int r = 1; r <= rows; r++) 
		{
			XSSFRow row = sheet.getRow(r);

			for (int j = 0; j < cols; j++) 
			{
				XSSFCell cell = row.getCell(j);
				String str = formatter.formatCellValue(cell);

				data[r - 1][j] = str; // Store data, excluding header row
			}
		}

		workbook.close();
		inputStream.close();

		return data;
	}
}

