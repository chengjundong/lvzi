package com.alu.lvzi.test.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.alu.lvzi.dao.PrivilegeDAO;
import com.alu.lvzi.pojo.Privilege;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class PrivilegeDAOTest
{
	@Autowired
	@Qualifier("privilegeDAO")
	private PrivilegeDAO privilegeDAO;
	
	@Test
	@Transactional
	public void testQuery()
	{
		List<Privilege> ps = privilegeDAO.findAll();
		for (Privilege p : ps)
		{
			System.out.println(p + ":" + p.getParent());
		}
	}
	
	@Test
	@Transactional
	public void testQueryByList()
	{
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		List<Privilege> privileges = privilegeDAO.findPrivileges(list);
		for (Privilege privilege : privileges)
		{
			System.out.println(privilege);
		}
	}
}
