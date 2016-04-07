package edu.northwestern.bnlp.echoinfer;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import static org.apache.poi.hssf.usermodel.HeaderFooter.file;
import org.apache.poi.openxml4j.opc.OPCPackage;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class Echo_ReadExcelXFile {

    public static void main(String[] args) {
    	System.out.println("vsvjh");
        String fileName = "/Users/cnx471/Desktop/test.xlsx";
        // Read an Excel File and Store in a Vector
        Vector dataHolder = readExcelFile(fileName);
        
		// Print the data read

    }

    /**
     * Workbook wb = WorkbookFactory.create(new
     * File("/path/to/your/excel/file")); Sheet mySheet = wb.getSheetAt(0);
     * Iterator<Row> rowIter = mySheet.rowIterator();
     * System.out.println(mySheet.getRow(1).getCell(0));
     *
     * @param fileName
     * @return
     */

    public static Vector readExcelFile(String fileName) {
        /**
         * --Define a Vector --Holds Vectors Of Cells
         */
        Vector cellVectorHolder = new Vector();

        try {
            /**
             * Creating Input Stream *
             */
			// InputStream myInput= ReadExcelFile.class.getResourceAsStream(
            // fileName );
            File file;
            file = new File(fileName);
            OPCPackage opcPackage = OPCPackage.open(file.getAbsolutePath());
            XSSFWorkbook myWorkBook = new XSSFWorkbook(opcPackage);
            

			/** Get the first sheet from workbook **/
			XSSFSheet mySheet = myWorkBook.getSheetAt(0);

            /**
             * We now need something to iterate through the cells. *
             */
            Iterator rowIter = mySheet.rowIterator();

            while (rowIter.hasNext()) {
                XSSFRow myRow = (XSSFRow) rowIter.next();
                Iterator cellIter = myRow.cellIterator();
                Vector cellStoreVector = new Vector();
                while (cellIter.hasNext()) {
                    XSSFCell myCell = (XSSFCell) cellIter.next();
                    cellStoreVector.addElement(myCell);
                }
                cellVectorHolder.addElement(cellStoreVector);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cellVectorHolder;
    }

}
