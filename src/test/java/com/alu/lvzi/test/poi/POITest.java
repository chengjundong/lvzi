package com.alu.lvzi.test.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class POITest
{
	@Test
	public void testCreateWorkBook() throws IOException
	{
		XSSFWorkbook workbook = new XSSFWorkbook();
		FileOutputStream fos = new FileOutputStream(new File(
				"C:\\Users\\jundonch\\Desktop\\abc.xlsx"));
		workbook.write(fos);
		fos.close();
	}

	@Test
	public void testCreateExcel() throws IOException
	{
		// Create blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		// Create a blank sheet
		XSSFSheet spreadsheet = workbook.createSheet(" Employee Info ");
		// Create row object
		XSSFRow row;
		// This data needs to be written (Object[])
		Map<String, Object[]> empinfo = new TreeMap<String, Object[]>();
		empinfo.put("1", new Object[] { "EMP ID", "EMP NAME", "DESIGNATION" });
		empinfo.put("2", new Object[] { "tp01", "Gopal", "Technical Manager" });
		empinfo.put("3", new Object[] { "tp02", "Manisha", "Proof Reader" });
		empinfo.put("4", new Object[] { "tp03", "Masthan", "Technical Writer" });
		empinfo.put("5", new Object[] { "tp04", "Satish", "Technical Writer" });
		empinfo.put("6", new Object[] { "tp05", "Krishna", "Technical Writer" });
		// Iterate over data and write to sheet
		Set<String> keyid = empinfo.keySet();
		int rowid = 0;
		for (String key : keyid)
		{
			row = spreadsheet.createRow(rowid++);
			Object[] objectArr = empinfo.get(key);
			int cellid = 0;
			for (Object obj : objectArr)
			{
				Cell cell = row.createCell(cellid++);
				cell.setCellValue((String) obj);
			}
		}
		// Write the workbook in file system
		FileOutputStream out = new FileOutputStream(new File("C:/Users/jundonch/Desktop/Writesheet.xlsx"));
		workbook.write(out);
		out.close();
		System.out.println("Writesheet.xlsx written successfully");
	}
	
	@Test
	public void testReadExcel() throws IOException
	{
		FileInputStream fis = new FileInputStream(new File("C:/Users/jundonch/Desktop/Writesheet.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rows = sheet.iterator();
		while(rows.hasNext())
		{
			Row row = rows.next();
			Iterator<Cell> cells = row.iterator();
			while(cells.hasNext())
			{
				Cell cell = cells.next();
				switch (cell.getCellType())
				{
				case Cell.CELL_TYPE_NUMERIC:
					System.out.print(cell.getNumericCellValue() + "\t\t");
					break;
					
				case Cell.CELL_TYPE_STRING:
					System.out.print(cell.getStringCellValue() + "\t\t");
					break;

				default:
					break;
				}
			}
			System.out.print("\n");
		}
		fis.close();
	}
	
	@Test
	public void testCreateCells() throws IOException
	{
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.createSheet("cell types");
		XSSFRow row = spreadsheet.createRow((short) 2);
		row.createCell(0).setCellValue("Type of Cell");
		row.createCell(1).setCellValue("cell value");
		row = spreadsheet.createRow((short) 3);
		row.createCell(0).setCellValue("set cell type BLANK");
		row.createCell(1);
		row = spreadsheet.createRow((short) 4);
		row.createCell(0).setCellValue("set cell type BOOLEAN");
		row.createCell(1).setCellValue(true);
		row = spreadsheet.createRow((short) 5);
		row.createCell(0).setCellValue("set cell type ERROR");
		row.createCell(1).setCellValue(XSSFCell.CELL_TYPE_ERROR);
		row = spreadsheet.createRow((short) 6);
		row.createCell(0).setCellValue("set cell type date");
		row.createCell(1).setCellValue(new Date());
		row = spreadsheet.createRow((short) 7);
		row.createCell(0).setCellValue("set cell type numeric");
		row.createCell(1).setCellValue(20);
		row = spreadsheet.createRow((short) 8);
		row.createCell(0).setCellValue("set cell type string");
		row.createCell(1).setCellValue("A String");
		FileOutputStream out = new FileOutputStream(new File(
				"C:/Users/jundonch/Desktop/typesofcells.xlsx"));
		workbook.write(out);
		out.close();
		System.out.println("typesofcells.xlsx written successfully");
	}
	
	@Test
	public void testCreateComplexCells() throws IOException
	{
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.createSheet("cellstyle");
		XSSFRow row = spreadsheet.createRow((short) 1);
		row.setHeight((short) 800);
		XSSFCell cell = (XSSFCell) row.createCell((short) 1);
		cell.setCellValue("test of merging");
		// MEARGING CELLS
		// this statement for merging cells
		spreadsheet.addMergedRegion(new CellRangeAddress(1, // first row
															// (0-based)
				1, // last row (0-based)
				1, // first column (0-based)
				4 // last column (0-based)
				));
		// CELL Alignment
		row = spreadsheet.createRow(5);
		cell = (XSSFCell) row.createCell(0);
		row.setHeight((short) 800);
		// Top Left alignment
		XSSFCellStyle style1 = workbook.createCellStyle();
		spreadsheet.setColumnWidth(0, 8000);
		style1.setAlignment(XSSFCellStyle.ALIGN_LEFT);
		style1.setVerticalAlignment(XSSFCellStyle.VERTICAL_TOP);
		cell.setCellValue("Top Left");
		cell.setCellStyle(style1);
		row = spreadsheet.createRow(6);
		cell = (XSSFCell) row.createCell(1);
		row.setHeight((short) 800);
		// Center Align Cell Contents
		XSSFCellStyle style2 = workbook.createCellStyle();
		style2.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		style2.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		cell.setCellValue("Center Aligned");
		cell.setCellStyle(style2);
		row = spreadsheet.createRow(7);
		cell = (XSSFCell) row.createCell(2);
		row.setHeight((short) 800);
		// Bottom Right alignment
		XSSFCellStyle style3 = workbook.createCellStyle();
		style3.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
		style3.setVerticalAlignment(XSSFCellStyle.VERTICAL_BOTTOM);
		cell.setCellValue("Bottom Right");
		cell.setCellStyle(style3);
		row = spreadsheet.createRow(8);
		cell = (XSSFCell) row.createCell(3);
		// Justified Alignment
		XSSFCellStyle style4 = workbook.createCellStyle();
		style4.setAlignment(XSSFCellStyle.ALIGN_JUSTIFY);
		style4.setVerticalAlignment(XSSFCellStyle.VERTICAL_JUSTIFY);
		cell.setCellValue("Contents are Justified in Alignment");
		cell.setCellStyle(style4);
		// CELL BORDER
		row = spreadsheet.createRow((short) 10);
		row.setHeight((short) 800);
		cell = (XSSFCell) row.createCell((short) 1);
		cell.setCellValue("BORDER");
		XSSFCellStyle style5 = workbook.createCellStyle();
		style5.setBorderBottom(XSSFCellStyle.BORDER_THICK);
		style5.setBottomBorderColor(IndexedColors.BLUE.getIndex());
		style5.setBorderLeft(XSSFCellStyle.BORDER_DOUBLE);
		style5.setLeftBorderColor(IndexedColors.GREEN.getIndex());
		style5.setBorderRight(XSSFCellStyle.BORDER_HAIR);
		style5.setRightBorderColor(IndexedColors.RED.getIndex());
		style5.setBorderTop(XSSFCellStyle.BIG_SPOTS);
		style5.setTopBorderColor(IndexedColors.CORAL.getIndex());
		cell.setCellStyle(style5);
		// Fill Colors
		// background color
		row = spreadsheet.createRow((short) 10);
		cell = (XSSFCell) row.createCell((short) 1);
		XSSFCellStyle style6 = workbook.createCellStyle();
		style6.setFillBackgroundColor(HSSFColor.LEMON_CHIFFON.index);
		style6.setFillPattern(XSSFCellStyle.LESS_DOTS);
		style6.setAlignment(XSSFCellStyle.ALIGN_FILL);
		spreadsheet.setColumnWidth(1, 8000);
		cell.setCellValue("FILL BACKGROUNG/FILL PATTERN");
		cell.setCellStyle(style6);
		// Foreground color
		row = spreadsheet.createRow((short) 12);
		cell = (XSSFCell) row.createCell((short) 1);
		XSSFCellStyle style7 = workbook.createCellStyle();
		style7.setFillForegroundColor(HSSFColor.BLUE.index);
		style7.setFillPattern(XSSFCellStyle.LESS_DOTS);
		style7.setAlignment(XSSFCellStyle.ALIGN_FILL);
		cell.setCellValue("FILL FOREGROUND/FILL PATTERN");
		cell.setCellStyle(style7);
		FileOutputStream out = new FileOutputStream(new File(
				"C:/Users/jundonch/Desktop/cellstyle.xlsx"));
		workbook.write(out);
		out.close();
		System.out.println("cellstyle.xlsx written successfully");
	}
}
