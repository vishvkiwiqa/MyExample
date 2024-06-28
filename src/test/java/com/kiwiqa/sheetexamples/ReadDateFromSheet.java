package com.kiwiqa.sheetexamples;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDateFromSheet {

	public static void main(String[] args) throws IOException 
	{
		//ReadData Form File
		String excelFilePath ="C:\\Users\\Anmol\\Downloads\\try.xlsx";
		//		FileInputStream inputStream =new FileInputStream(sheetPath);
		//		try (XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {
		//			XSSFSheet sheet = workbook.getSheetAt(0);
		//
		//			DataFormatter formatter = new DataFormatter();
		//			int rows = sheet.getLastRowNum();
		//			int cols =sheet.getRow(1).getLastCellNum();
		//
		//
		//			for(int r= 0;r<rows;r++)
		//			{
		//				XSSFRow row = sheet.getRow(r);
		//
		//				for(int j=1;j<cols;j++)
		//				{
		//					XSSFCell cell =row.getCell(j);
		//
		//					System.out.println(cell.getStringCellValue());
		//				}
		//
		//
		//
		//			}

		try (FileInputStream fis = new FileInputStream(excelFilePath);
				XSSFWorkbook workbook = new XSSFWorkbook(fis)) 
		{

			XSSFSheet sheet = workbook.getSheetAt(0);
			DataFormatter formatter = new DataFormatter();

			List<String[]> hSubjectRows = new ArrayList<>();

			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext())
			{
				Row row = rowIterator.next();

				Cell firstCell = row.getCell(0);

				if (firstCell != null && "hSubject".equals(formatter.formatCellValue(firstCell))) 
				{
					List<String> cellValues = new ArrayList<>();
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) 
					{
						Cell cell = cellIterator.next();
						cellValues.add(formatter.formatCellValue(cell));
					}
					hSubjectRows.add(cellValues.toArray(new String[0]));
				} else {
					// Use an iterator for the cells in the row
					Iterator<Cell> cellIterator = row.cellIterator();
					boolean isFirstCell = true;
					while (cellIterator.hasNext()) 
					{
						Cell cell = cellIterator.next();

						// Skip printing the first cell
						if (isFirstCell) 
						{
							isFirstCell = false;
							continue;
						}

						String str = formatter.formatCellValue(cell);
						System.out.println(str);
					}
				}
			}

			// Print the hSubject row values (optional)
			System.out.println("hSubject Row Values:");
			for (String[] rowValues : hSubjectRows) 
			{
				for (String value : rowValues)
				{
					System.out.print(value);
				}
				System.out.println();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}