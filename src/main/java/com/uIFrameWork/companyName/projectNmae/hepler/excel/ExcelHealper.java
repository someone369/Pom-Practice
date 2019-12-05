package com.uIFrameWork.companyName.projectNmae.hepler.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.uIFrameWork.companyName.projectNmae.hepler.logger.LoggerHelper;
import com.uIFrameWork.companyName.projectNmae.hepler.resource.ResourecHelper;

public class ExcelHealper {


	private Logger log = LoggerHelper.getLogger(ExcelHealper.class);

	public Object[][] getExcelData(String excelLocation, String sheetName){
		
		try{
			Object dataset[][] = null;

			FileInputStream file = new FileInputStream(new File(excelLocation));
			
				// create workbook instance
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			
				// Get the sheet name from workbook
			XSSFSheet sheet = workbook.getSheet(sheetName);
			
				// Counting number of active rows in the workbook
			int totalRow = sheet.getLastRowNum();
			
			System.out.println("Total number of rows is :"+ totalRow);
				// counting number of active cells in the row
			int totalColumn = sheet.getRow(1).getLastCellNum();
			
			System.out.println("Total number of columns is :"+ totalColumn);
				//Saving excel Sheet in to 2D array
			dataset = new Object [totalRow][totalColumn-1];

				//Iterate through rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			
			int i = 0;//this is for rows
			while(rowIterator.hasNext()){
				//for every row we need to iterate over columns
				i++;
				Row row = rowIterator.next();
				
				Iterator<Cell> celliterator = row.cellIterator();
				
				int j = 0;// this is for columns
				while(celliterator.hasNext()){

					Cell cell = celliterator.next();
					if (cell.getStringCellValue().contains("Start")) {
						i = 0;
						break;
					}
					
					switch(cell.getCellTypeEnum()){
					case STRING:
						dataset[i-1][j++] = cell.getStringCellValue();
						break;
					case NUMERIC:
						dataset[i-1][j++] = cell.getNumericCellValue();
						break;
					case BOOLEAN:
						dataset[i-1][j++] = cell.getBooleanCellValue();
						break;
					case FORMULA:
						dataset[i-1][j++] = cell.getCellFormula();
						break;
					default:
						System.out.println("NO matching enum data type is found");
						break;
						}
				}
			}
			return dataset; 
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public void updateResults(String excelLocation, String sheetName, String testCaseName, String testStatus){
		try{
			FileInputStream file = new FileInputStream(new File(excelLocation));
			// Create Workbook instance
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get sheet Name from Workbook
			XSSFSheet sheet = workbook.getSheet(sheetName);
			// count number of active rows in excel sheet
			int totalRow = sheet.getLastRowNum()+1;
			for(int i =1; i<totalRow; i++){
				XSSFRow r = sheet.getRow(i);
				String ce = r.getCell(0).getStringCellValue();
				if(ce.contains(testCaseName)){
					r.createCell(1).setCellValue(testStatus);
					file.close();
					log.info("result updated..");
					FileOutputStream out = new FileOutputStream(new File(excelLocation));
					workbook.write(out);
					out.close();
					break;
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ExcelHealper excelhealper = new ExcelHealper();
		String excelLocation = ResourecHelper.getResourcePath("/resources/TestData/TestData21.xlsx");
		
		String sheetName = "Logindata";
		Object[][] data = excelhealper.getExcelData(excelLocation, sheetName);
		System.out.println(data);
		
			
		/*excelhealper.updateResults(excelLocation, "LoginPage", "Login", "PASS");
		excelhealper.updateResults(excelLocation, "LoginPage", "Registration", "FAIL");
		excelhealper.updateResults(excelLocation, "LoginPage", "Add to Cart", "PASS");
		excelhealper.updateResults(excelLocation, "LoginPage", "Logout", "FAIL");*/
	}
}