package com.alu.lvzi.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.alu.lvzi.dao.AdminDAO;
import com.alu.lvzi.message.MessageBox;
import com.alu.lvzi.pojo.Admin;
import com.alu.lvzi.service.AdminService;
import com.alu.lvzi.user.LoginInfor;

public class AdminServiceImpl implements AdminService
{
	private AdminDAO adminDAO;

	public AdminDAO getAdminDAO()
	{
		return adminDAO;
	}

	public void setAdminDAO(AdminDAO adminDAO)
	{
		this.adminDAO = adminDAO;
	}

	@Override
	public LoginInfor login(LoginInfor loginInfor)
	{
		String hql = "FROM Admin WHERE name='"+loginInfor.getInputUserName()+"'";
		List<Admin> admins = adminDAO.findByHQL(hql);
		
		// 用户不存在
		if(admins.isEmpty())
		{
			loginInfor.setMessage(MessageBox.Login_NoUser.getMessage());
			return loginInfor;
		}
		else
		{
			Admin admin = admins.get(0);
			
			// 密码校验
			if(!loginInfor.getMD5Password().equals(admin.getPassword()))
			{
				loginInfor.setMessage(MessageBox.Login_WrongPassword.getMessage());
				return loginInfor;
			}
			
			// IP地址校验
			if(null != admin.getBoundedIP() && !admin.getBoundedIP().equals(loginInfor.getInputIpAddress()))
			{
				loginInfor.setMessage(MessageBox.Login_WrongBoundedIpAddress.getMessage());
				return loginInfor;
			}
			
			// 账户锁定
			if(admin.getLocked())
			{
				loginInfor.setMessage(MessageBox.Login_LockedAccount.getMessage());
				return loginInfor;
			}
			
			// 更新用户信息
			admin.setLastLoginIP(loginInfor.getInputIpAddress());
			admin.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
			if(null == admin.getLoginCount())
			{
				admin.setLoginCount(1);
			}
			else
			{
				admin.setLoginCount(admin.getLoginCount()+1);
			}
			
			// 返回查询到的用户
			loginInfor.setAdmin(admin);
			loginInfor.setMessage(MessageBox.Login_Success.getMessage());
			return loginInfor;
		}
	}

	@Override
	public void update(Admin admin)
	{
		adminDAO.update(admin);
	}
}
