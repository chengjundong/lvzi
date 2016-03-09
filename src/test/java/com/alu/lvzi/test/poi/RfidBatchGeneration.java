package com.alu.lvzi.test.poi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class RfidBatchGeneration
{
	@Test
	public void generateRfidBatch() throws IOException
	{
		int rfidCount = 1000;
		String fileName = "C:/Users/jundonch/Desktop/"+UUID.randomUUID().toString()+".xlsx";
		
		// 生成文件
		XSSFWorkbook workbook = new XSSFWorkbook();
		FileOutputStream fos = new FileOutputStream(new File(fileName));
		XSSFSheet sheet = workbook.createSheet("sheet 1");
		
		// 生成title行
		XSSFRow titleRow = sheet.createRow(0);
		XSSFCell codeCell = titleRow.createCell(0, XSSFCell.CELL_TYPE_STRING);
		codeCell.setCellValue("CODE");
		
		// 生成code
		for(int i=1;i<rfidCount;i++)
		{
			XSSFRow row = sheet.createRow(i);
			XSSFCell cell = row.createCell(0, XSSFCell.CELL_TYPE_STRING);
			cell.setCellValue(UUID.randomUUID().toString());
		}
		
		// 写出文件
		workbook.write(fos);
		fos.close();
		
		System.out.println("RFID批次文件导出成功");
	}
}
