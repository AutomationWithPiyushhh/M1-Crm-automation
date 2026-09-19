package ddt_extra;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetDataFromExcelFile {
	public static void main(String[] args) throws IOException {
//		./src/test/resources/testscriptdata.xlsx
//		. means project level
//		Step 1> create jro of the physical file
		FileInputStream fis = new FileInputStream("./src/test/resources/testscriptdata.xlsx");

//		step 2> get access of workbook
		Workbook wb = WorkbookFactory.create(fis);

//		step 3> get the access of sheet
		Sheet sh = wb.getSheet("org");

//		step 4> get the access of row
		Row row = sh.getRow(2);

//		step 5> get the access of cell
		Cell cell = row.getCell(0);
		
//		step 6> get the data from cell
		String value = cell.getStringCellValue();
		
		System.out.println(value);

	}
}
