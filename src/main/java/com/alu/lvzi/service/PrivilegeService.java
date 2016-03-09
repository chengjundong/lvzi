package com.alu.lvzi.service;

import java.util.List;

import com.alu.lvzi.pojo.Admin;
import com.alu.lvzi.pojo.Privilege;

public interface PrivilegeService
{
	public List<Privilege> findPrivileges(Admin admin);
}
