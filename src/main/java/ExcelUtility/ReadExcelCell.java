package ExcelUtility;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class ReadExcelCell {
    ReadExcelCell readExcelCell;

    //	public  ReadExcelCell getInstance(String excelName , String sheetName) {
//		if (readExcelCell==null)
//		{
//			readExcelCell=new  ReadExcelCell(excelName,sheetName);
//		}
//		return readExcelCell;
//	}
    FileInputStream excelFile;
    XSSFWorkbook WB;
    XSSFSheet sheet;

    ReadExcelCell(String excelName, String sheetName) {
        try {
            excelFile = new FileInputStream(
                    new File(System.getProperty("user.dir") + excelName));
            WB = new XSSFWorkbook(excelFile);
            sheet = WB.getSheet(sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ReadExcelCell readExcelCell = new ReadExcelCell("/src/test/resources/ObjectRepo.xlsx", "Test Data");
        System.out.println(readExcelCell.readCell("url", 1));
        readExcelCell = new ReadExcelCell("/src/test/resources/ObjectRepo.xlsx", "Object Repository");
        System.out.println(readExcelCell.readCell("postcode", 3));
        System.out.println(readExcelCell.readCell("url", 1));


    }

    public String readCell(int rowNum, int coulmnNum) {
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(coulmnNum);
        return cell.getStringCellValue();

    }

    public String readCell(String rowName, int coulmnNum) {
        int rowNum = 0;
        for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
            if (rowName.toLowerCase().equals(sheet.getRow(i).getCell(0).getStringCellValue().toLowerCase())) {
                rowNum = i;
                break;
            }
        }
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(coulmnNum);
        try {
            return cell.getStringCellValue();
        } catch (java.lang.IllegalStateException e1) {
            DecimalFormat df = new DecimalFormat("#");
            df.setMaximumFractionDigits(0);
            return String.valueOf(df.format(cell.getNumericCellValue()));
        } catch (java.lang.NullPointerException e) {
            return "";
        }
    }
}
