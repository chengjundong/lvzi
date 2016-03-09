package com.alu.lvzi.dao;

import java.util.List;

import com.alu.lvzi.pojo.Privilege;

public interface PrivilegeDAO extends GenericDAO<Privilege, Integer>
{ 
	abstract public List<Privilege> findPrivileges(List<Integer> privilegeIDs);
}
