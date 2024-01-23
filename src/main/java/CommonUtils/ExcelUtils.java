package CommonUtils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

	
	public String getDataFromExcelFile(String sheetname,int rownumber,int cellnumber) throws EncryptedDocumentException, IOException {
		
		FileInputStream fisex = new FileInputStream("src\\test\\resources\\Data.xlsx");
		Workbook wb = WorkbookFactory.create(fisex);
		Sheet sh = wb.getSheet(sheetname);
		Row rw = sh.getRow(rownumber);
		Cell cl = rw.getCell(cellnumber);
		String value = cl.getStringCellValue();
		return value;
		
		
	}
}
