package resources;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDriven {
	static String path = System.getProperty("user.dir");
	//variables va = new variables();
	public static XSSFWorkbook ExcelWBook;
	public static XSSFSheet ExcelWSheet;
	public static XSSFCell Cell;
	public static String sheetName = "Sheet1";
	public static String issueDataPath = path + "\\src\\main\\java\\resources\\Issue-Data.xlsx";
	public static int cellNum;
	
		
	// Location of the Excel file
public static String excelData(String str) {
	try
	{
		FileInputStream ExcelFile = new FileInputStream(issueDataPath);
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet(sheetName);
		Iterator<Row> rows = ExcelWSheet.iterator();
		Row columnName = rows.next();
		Iterator<Cell> cell = columnName.cellIterator();
		for (int cn=0; cn<columnName.getLastCellNum(); cn++){
			
			Cell value = cell.next();
			//System.out.println(value.getStringCellValue());
			if(value.getStringCellValue().equalsIgnoreCase(str)) {
				cellNum = cn;
			}
		}

		Cell = ExcelWSheet.getRow(1).getCell(cellNum);
		String cellData = Cell.getStringCellValue();
		//System.out.println("Cell Data: " + cellData);
		return cellData;

	}catch(Exception e)
	{
		return "Data not found";
	}
}
}
