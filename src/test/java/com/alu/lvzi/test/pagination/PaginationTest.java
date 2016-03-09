package com.alu.lvzi.test.pagination;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.alu.lvzi.pagination.Pagination;
import com.alu.lvzi.pojo.RfidBatch;
import com.alu.lvzi.service.RfidBatchService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class PaginationTest
{
	@Autowired
	@Qualifier("rfidBatchService")
	private RfidBatchService rfidBatchService;
	
	@Test
	public void testPageNumber()
	{
		Pagination<String> pagination = new Pagination<String>();
		
		pagination.setCurrentPageNo(6);
		pagination.initPagination(100, new ArrayList<String>());
		Assert.assertEquals(2, pagination.getStartPageNo());
		Assert.assertEquals(11, pagination.getEndPageNo());
		
		pagination.setCurrentPageNo(1);
		pagination.initPagination(100, new ArrayList<String>());
		Assert.assertEquals(1, pagination.getStartPageNo());
		Assert.assertEquals(10, pagination.getEndPageNo());
		
		pagination.setCurrentPageNo(19);
		pagination.initPagination(100, new ArrayList<String>());
		Assert.assertEquals(11, pagination.getStartPageNo());
		Assert.assertEquals(20, pagination.getEndPageNo());
		
		pagination.setCurrentPageNo(8);
		pagination.initPagination(100, new ArrayList<String>());
		Assert.assertEquals(4, pagination.getStartPageNo());
		Assert.assertEquals(13, pagination.getEndPageNo());
	}
	
	@Test
	@Transactional
	public void testQueryByPagination()
	{
		Pagination<RfidBatch> pagination = new Pagination<RfidBatch>();
		pagination.setCurrentPageNo(2);
		pagination = rfidBatchService.findByPagination(pagination);
		System.out.println("Result Size: " + pagination.getElements().size());
		System.out.println("Start Page No: " + pagination.getStartPageNo());
		System.out.println("End Page No: " + pagination.getEndPageNo());
		System.out.println("Total Page No: " + pagination.getTotalPageCount());
	}
}
