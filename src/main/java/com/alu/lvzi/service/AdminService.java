package com.alu.lvzi.service;

import com.alu.lvzi.pojo.Admin;
import com.alu.lvzi.user.LoginInfor;

public interface AdminService
{
	abstract public LoginInfor login(LoginInfor loginInfor);
	abstract public void update(Admin admin);
}
