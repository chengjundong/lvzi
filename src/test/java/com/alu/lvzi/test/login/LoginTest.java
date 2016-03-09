package com.alu.lvzi.test.login;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alu.lvzi.action.background.AdminAction;
import com.alu.lvzi.service.AdminService;
import com.alu.lvzi.user.LoginInfor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class LoginTest
{
	@Autowired
	@Qualifier("adminLoginService")
	private AdminService adminLoginService;
	
	@Autowired
	@Qualifier("adminLoginAction")
	private AdminAction adminLoginAction;
	
	@Test
	public void testMD5()
	{
		LoginInfor loginInfor = new LoginInfor().inputPassword("abc");
		System.out.println(loginInfor.getMD5Password());
	}
	
	@Test
	public void testLogin()
	{
		LoginInfor loginInfor = new LoginInfor().inputUserName("super").inputPassword("123456");
		LoginInfor loginInfor2 = adminLoginService.login(loginInfor);
		Assert.assertNotNull(loginInfor2.getAdmin());
		System.out.println(loginInfor2.getMessage());
	}
	
	@Test
	public void testAction()
	{
		System.out.println(adminLoginAction.getAdminService());
	}
}
