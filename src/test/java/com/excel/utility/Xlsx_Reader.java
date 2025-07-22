package com.excel.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Xlsx_Reader {
    private Workbook workbook;

    public Xlsx_Reader(String filePath) {
        try (FileInputStream fis = new FileInputStream(new File(filePath))) {
            if (filePath.toLowerCase().endsWith(".xlsx")) {
                workbook = new XSSFWorkbook(fis); // For .xlsx files
            } else if (filePath.toLowerCase().endsWith(".xls")) {
                workbook = new HSSFWorkbook(fis); // For .xls files
            } else {
                throw new IllegalArgumentException("Invalid file extension. Only .xls or .xlsx allowed.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getRowCount(String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) return 0;

        return sheet.getLastRowNum() + 1;
    }

    public String getCellData(String sheetName, int rowNum, String colName) {
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) return "";

        Row headerRow = sheet.getRow(0); // Assume first row is header
        if (headerRow == null) return "";

        int colIndex = -1;
        for (Cell cell : headerRow) {
            if (cell.getCellType() == CellType.STRING &&
                cell.getStringCellValue().trim().equalsIgnoreCase(colName.trim())) {
                colIndex = cell.getColumnIndex();
                break;
            }
        }

        if (colIndex == -1) {
            System.out.println("Column \"" + colName + "\" not found in sheet: " + sheetName);
            return "";
        }

        Row row = sheet.getRow(rowNum);
        if (row == null) return "";

        Cell cell = row.getCell(colIndex);
        if (cell == null) return "";

        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue();
            case NUMERIC -> String.valueOf(cell.getNumericCellValue());
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            case FORMULA -> cell.getCellFormula();
            default -> "";
        };
    }
}