package com.framework.utilities;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

/**
 * Created by hungduong on 5/27/17.
 */
public class ExcelSheetDriver {
    static Sheet wrksheet;
    static Workbook wrkbook = null;
    static Hashtable dict = new Hashtable();
    static Hashtable flaggedMethod = new Hashtable();

    //Create a Constructor
    public ExcelSheetDriver(String ExcelSheetPath, String sheetName) throws BiffException, IOException {
        //Initialize
        wrkbook = Workbook.getWorkbook(new File(ExcelSheetPath));
        wrksheet = wrkbook.getSheet(sheetName);

        //Put all column name and column id inside the hashtable
        ColumnDictionary();
    }

    public static int RowCount() {
        return wrksheet.getRows();
    }

    //Returns the Cell value by taking row and Column values as argument
    public static String ReadCell(int column, int row) {
        return wrksheet.getCell(column, row).getContents();
    }

    public static String ReadCell(String colName, int row) {
        return ReadCell(GetCell(colName), row);
    }

    //Create Column Dictionary to hold all the Column Names
    public static void ColumnDictionary() {
        //Iterate through all the columns in the Excel sheet and store the value in Hashtable
        for (int col = 0; col < wrksheet.getColumns(); col++) {
            dict.put(ReadCell(col, 0), col);
        }
    }

    //Read Column Names
    public static int GetCell(String colName) {
        try {
            int value;
            value = ((Integer) dict.get(colName)).intValue();
            return value;
        } catch (NullPointerException e) {
            return (0);
        }
    }

    //Get all the Flagged methodes from excel sheet
    public static Hashtable GetFlaggedMethods(String columnName) {
        try {
            int methodCount = 1;
            for (int row = 0; row < RowCount(); row++) {
                if (ReadCell(columnName, row).equals("Y")) {
                    flaggedMethod.put(methodCount, ReadCell("Function", row) + ";" + ReadCell("ExcelName", row));
                    methodCount++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flaggedMethod;
    }
}
