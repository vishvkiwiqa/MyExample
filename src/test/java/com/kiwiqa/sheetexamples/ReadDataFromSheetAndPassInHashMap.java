package com.kiwiqa.sheetexamples;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class ReadDataFromSheetAndPassInHashMap 
{
	public static void main(String[] args) throws IOException
	{

		//ReadData Form File
		String sheetPath ="C:\\Users\\Anmol\\Downloads\\Book1.xlsx";
		FileInputStream inputStream =new FileInputStream(sheetPath);
		try (XSSFWorkbook workbook = new XSSFWorkbook(inputStream))
		{
			XSSFSheet sheet = workbook.getSheetAt(0);
			int rows = sheet.getLastRowNum();
			System.out.println(rows);
			int cols =sheet.getRow(1).getLastCellNum();

			DataFormatter formatter = new DataFormatter();
			//	String str = formatter.formatCellValue(cell);

			HashMap<String, String> map = new HashMap<>();


			for(int r= 0;r<rows+1;r++)
			{
				XSSFRow row = sheet.getRow(r);
				XSSFCell key =row.getCell(0);
				String str = formatter.formatCellValue(key);
				XSSFCell value =row.getCell(1);
				String str1 = formatter.formatCellValue(value);
				map.put(str,str1);	
			}
			
			System.out.println(map.size());
	}
}

}
