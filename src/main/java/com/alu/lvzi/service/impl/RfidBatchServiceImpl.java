package com.alu.lvzi.service.impl;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.alu.lvzi.dao.RfidBatchDAO;
import com.alu.lvzi.dao.RfidDAO;
import com.alu.lvzi.pagination.Pagination;
import com.alu.lvzi.pojo.Admin;
import com.alu.lvzi.pojo.Rfid;
import com.alu.lvzi.pojo.RfidBatch;
import com.alu.lvzi.service.RfidBatchService;

public class RfidBatchServiceImpl implements RfidBatchService
{
	private RfidBatchDAO rfidBatchDAO;
	private RfidDAO rfidDAO;

	public RfidBatchDAO getRfidBatchDAO()
	{
		return rfidBatchDAO;
	}

	public void setRfidBatchDAO(RfidBatchDAO rfidBatchDAO)
	{
		this.rfidBatchDAO = rfidBatchDAO;
	}

	public RfidDAO getRfidDAO()
	{
		return rfidDAO;
	}

	public void setRfidDAO(RfidDAO rfidDAO)
	{
		this.rfidDAO = rfidDAO;
	}

	@Override
	public boolean saveRfidBatches(File batchFile, String fileName, Admin operator)
	{
		try
		{
			int rfidCount = 0;
			// 保存RFID Batch信息
			RfidBatch batch = new RfidBatch();
			batch.setFileName(fileName);
			batch.setOperator(operator);
			batch.setImportingTime(new Timestamp(System.currentTimeMillis()));
			rfidBatchDAO.add(batch);
			
			// 保存RFID信息
			List<Rfid> rfids = new ArrayList<Rfid>();
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(batchFile);
			XSSFSheet sheet = workbook.getSheet("sheet 1");
			Iterator<Row> rows = sheet.iterator();
			while(rows.hasNext())
			{
				Row row = rows.next();
				Iterator<Cell> cells = row.iterator();
				while(cells.hasNext())
				{
					Cell cell = cells.next();
					String value = cell.getStringCellValue();
					if(!Objects.equals(value, "CODE"))
					{
						Rfid rfid = new Rfid();
						rfid.setBatch(batch);
						rfid.setCode(value);
						rfidCount++;
						rfids.add(rfid);
					}
				}
			}
			
			// 保存所有的RFID
			rfidDAO.add(rfids.toArray(new Rfid[rfids.size()]));
			
			// 更新RFID总数
			batch.setRfidCount(rfidCount);
			
			return true;
			
		} catch (InvalidFormatException | IOException e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<RfidBatch> findAll()
	{
		return this.rfidBatchDAO.findAll();
	}

	@Override
	public Pagination<RfidBatch> findByPagination(Pagination<RfidBatch> pagination)
	{
		Long totalCount = rfidBatchDAO.findTotalCount();
		List<RfidBatch> rfidBatches = rfidBatchDAO.findBatchesByPagination(pagination.getCurrentRecordStartIndex(), 
				pagination.getPageElementsCount());
		pagination.initPagination(totalCount.intValue(), rfidBatches);
		return pagination;
	}
	
	@Override
	public RfidBatch get(Integer id)
	{
		return rfidBatchDAO.findById(id);
	}
	
	@Override
	public void add(RfidBatch... batches)
	{
		rfidBatchDAO.add(batches);
	}
}
