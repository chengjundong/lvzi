package com.alu.lvzi.test.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.alu.lvzi.dao.AdminDAO;
import com.alu.lvzi.pojo.Admin;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class AdminDAOTest
{
	@Autowired
	@Qualifier("adminDAO")
	private AdminDAO adminDAO;
	
	@Test
	@Transactional
	public void testQuery()
	{
		List<Admin> admins = adminDAO.findAll();
		for (Admin admin : admins)
		{
			System.out.println(admin);
		}
	}
}
