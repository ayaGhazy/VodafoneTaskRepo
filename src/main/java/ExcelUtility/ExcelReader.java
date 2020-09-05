package ExcelUtility;

public class ExcelReader {
    static ExcelReader excelReader;
    ReadExcelCell readExcelCellTestData;
    ReadExcelCell readExcelCell;

    private ExcelReader() {
        readExcelCellTestData = new ReadExcelCell("/src/test/resources/ObjectRepo.xlsx", "Test Data");
        readExcelCell = new ReadExcelCell("/src/test/resources/ObjectRepo.xlsx", "Object Repository");

    }

    public static ExcelReader getInstance() {
        if (excelReader == null) {
            excelReader = new ExcelReader();
        }
        return excelReader;
    }

    public static void main(String[] args) {
        ExcelReader reader = ExcelReader.getInstance();
        System.out.println(reader.readfindBy("signInBTN"));
        System.out.println(reader.readBy("signInBTN"));
        System.out.println(reader.readValue("signInBTN"));
        System.out.println(reader.readTestData("url"));
        System.out.println(reader.readfindBy("signInBTN"));


    }

    public String readTestData(String element) {
        //  ExcelReader.getInstance("/src/test/resources/ObjectRepo.xlsx","Test Data");
        return readExcelCellTestData.readCell(element, 1);
    }

    public String readfindBy(String element) {
        //ReadExcelCell readExcelCell =new ReadExcelCell("/src/test/resources/ObjectRepo.xlsx","Object Repository");
        return readExcelCell.readCell(element, 1);
    }

    public String readBy(String element) {
        //  ReadExcelCell readExcelCell = new ReadExcelCell("/src/test/resources/ObjectRepo.xlsx","Object Repository");
        return readExcelCell.readCell(element, 2);
    }

    public String readValue(String element) {
        // ReadExcelCell readExcelCell = new ReadExcelCell("/src/test/resources/ObjectRepo.xlsx","Object Repository");
        return readExcelCell.readCell(element, 3);
    }
}
