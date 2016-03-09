package com.alu.lvzi.test.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.alu.lvzi.dao.RfidDAO;
import com.alu.lvzi.pojo.Rfid;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class RfidDAOTest
{
	@Autowired
	@Qualifier("rfidDAO")
	private RfidDAO rfidDAO;
	
	@Test
	@Transactional
	public void testQuery()
	{
		List<Rfid> rfids = rfidDAO.findAll();
		for (Rfid rfid : rfids)
		{
			System.out.println(rfid + ":" + rfid.getBatch());
		}
	}
}
