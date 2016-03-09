package com.alu.lvzi.dao.impl;

import java.util.List;

import com.alu.lvzi.dao.PrivilegeDAO;
import com.alu.lvzi.pojo.Privilege;

public class PrivilegeDAOImpl extends GenericDAOImpl<Privilege, Integer> implements
		PrivilegeDAO
{
	@SuppressWarnings("unchecked")
	@Override
	public List<Privilege> findPrivileges(List<Integer> privilegeIDs)
	{
		String hql = "FROM Privilege WHERE id in :list";
		return (List<Privilege>) this.getHibernateTemplate().findByNamedParam(hql, "list", privilegeIDs);
	}
}
