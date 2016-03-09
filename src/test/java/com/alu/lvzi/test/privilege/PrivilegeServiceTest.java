package com.alu.lvzi.test.privilege;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.alu.lvzi.dao.AdminDAO;
import com.alu.lvzi.pojo.Admin;
import com.alu.lvzi.pojo.Privilege;
import com.alu.lvzi.service.PrivilegeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class PrivilegeServiceTest
{
	@Autowired
	@Qualifier("privilegeService")
	private PrivilegeService privilegeService;
	
	@Autowired
	@Qualifier("adminDAO")
	private AdminDAO adminDAO;
	
	@Test
	@Transactional
	public void testQueryPrivileges()
	{
		Admin admin = adminDAO.findById(1);
		List<Privilege> privileges = privilegeService.findPrivileges(admin);
		Assert.assertEquals(privileges.size(), admin.getPrivileges().split(",").length);
	}
}
