package com.test.utility;

import java.util.ArrayList;

import com.excel.utility.Xlsx_Reader;

public class TestUtil {
	
	static Xlsx_Reader reader;
	
	public static  ArrayList<Object[]> getDataFromExcel() {
		
		ArrayList<Object[]> mydata = new ArrayList<Object[]>();
		
		try {
			reader = new Xlsx_Reader("C:\\Users\\Acer\\OneDrive\\Desktop\\Test_Data.xlsx");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		for(int rowNum=1; rowNum<reader.getRowCount("Sheet1");rowNum++) {
			
			String firstname = reader.getCellData("Sheet1",rowNum,"firstname");
			String lastname = reader.getCellData("Sheet1",rowNum,"lastname");
			String email = reader.getCellData("Sheet1",rowNum,"email");
			String password = reader.getCellData("Sheet1",rowNum,"password");
			Object ob[]= {firstname,lastname,email,password};
			mydata.add(ob);
		}
		System.out.println("Total Rows: " + reader.getRowCount("Sheet1"));
		
		return mydata;	
	}
}	
