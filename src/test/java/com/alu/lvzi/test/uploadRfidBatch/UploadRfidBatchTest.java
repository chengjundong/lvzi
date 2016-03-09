package com.alu.lvzi.test.uploadRfidBatch;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.alu.lvzi.dao.AdminDAO;
import com.alu.lvzi.pojo.Admin;
import com.alu.lvzi.service.RfidBatchService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class UploadRfidBatchTest
{
	@Autowired
	@Qualifier("rfidBatchService")
	private RfidBatchService rfidBatchService;
	
	@Autowired
	@Qualifier("adminDAO")
	private AdminDAO adminDAO;
	
	@Test
	public void testQueryAll()
	{
		System.out.println(rfidBatchService.findAll());
	}
	
	@Test
	@Transactional
	@Rollback(value=true)
	public void testImportRfidBatch()
	{
		File f = new File("C:/Users/jundonch/Desktop/780717a4-5420-42a8-92c1-848511fa1b94.xlsx");
		String fname = "780717a4-5420-42a8-92c1-848511fa1b94.xlsx";
		Admin admin = adminDAO.findById(1);
		rfidBatchService.saveRfidBatches(f, fname, admin);
		System.out.println(rfidBatchService.findAll());
	}
}
