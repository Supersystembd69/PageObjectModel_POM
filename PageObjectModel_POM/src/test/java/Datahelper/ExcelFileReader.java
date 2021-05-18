package Datahelper;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReader {

	/**
	 * @param filePath  excel file path
	 * @param sheetName sheet name in xlsx file
	 * @return excel data object
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public static Object[][] ExcelDataReader(String filePath, String sheetName) throws IOException {
		
		FileInputStream file = new FileInputStream(filePath);

		XSSFWorkbook wb = new XSSFWorkbook(file);

		XSSFSheet ws = wb.getSheet(sheetName);

		int rowCount = ws.getLastRowNum();
		
		int colCount = ws.getRow(0).getLastCellNum();

		Object[][] object = new Object[rowCount][colCount];
		
		for (int i = 0; i <rowCount; i++) {
			
			Row row = ws.getRow(i+1);
	
			for (int j = 0; j < row.getLastCellNum(); j++) {
	
				object[i][j] = row.getCell(j).toString(); 
			} 
			
		}

		return object;
		
	}
}