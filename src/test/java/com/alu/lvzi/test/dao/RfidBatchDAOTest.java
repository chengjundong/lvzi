package com.alu.lvzi.test.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.alu.lvzi.dao.RfidBatchDAO;
import com.alu.lvzi.pojo.RfidBatch;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class RfidBatchDAOTest
{
	@Autowired
	@Qualifier("rfidBatchDAO")
	private RfidBatchDAO rfidBatchDAO;
	
	@Test
	@Transactional
	public void testQuery()
	{
		List<RfidBatch> batches = rfidBatchDAO.findAll();
		for (RfidBatch rfidBatch : batches)
		{
			System.out.println(rfidBatch + ":" + rfidBatch.getOperator());
		}
	}
	
	@Test
	@Transactional
	public void testFindTotalCount()
	{
		Long count = rfidBatchDAO.findTotalCount();
		System.out.println(count);
	}
	
	@Test
	@Transactional
	public void testFindByPagination()
	{
		List<RfidBatch> list = rfidBatchDAO.findBatchesByPagination(2, 1);
		System.out.println(list);
	}
}
