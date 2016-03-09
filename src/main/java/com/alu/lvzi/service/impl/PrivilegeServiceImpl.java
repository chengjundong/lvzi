package com.alu.lvzi.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.alu.lvzi.dao.PrivilegeDAO;
import com.alu.lvzi.pojo.Admin;
import com.alu.lvzi.pojo.Privilege;
import com.alu.lvzi.service.PrivilegeService;

public class PrivilegeServiceImpl implements PrivilegeService
{
	private PrivilegeDAO privilegeDAO;

	public PrivilegeDAO getPrivilegeDAO()
	{
		return privilegeDAO;
	}

	public void setPrivilegeDAO(PrivilegeDAO privilegeDAO)
	{
		this.privilegeDAO = privilegeDAO;
	}

	@Override
	public List<Privilege> findPrivileges(Admin admin)
	{
		List<Integer> privilegeIDs = new ArrayList<Integer>();

		if (null != admin.getPrivileges())
		{
			for (String privilegeID : admin.getPrivileges().split(","))
			{
				privilegeIDs.add(Integer.parseInt(privilegeID));
			}
		}

		return privilegeDAO.findPrivileges(privilegeIDs);
	}
}
