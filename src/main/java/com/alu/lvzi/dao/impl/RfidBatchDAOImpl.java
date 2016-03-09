package com.alu.lvzi.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.alu.lvzi.dao.RfidBatchDAO;
import com.alu.lvzi.pojo.RfidBatch;

public class RfidBatchDAOImpl extends GenericDAOImpl<RfidBatch, Integer> implements
		RfidBatchDAO
{
	@Override
	public Long findTotalCount()
	{
		String hql = "SELECT COUNT(*) FROM RfidBatch";
		Session session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		return (Long) session.createQuery(hql).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RfidBatch> findBatchesByPagination(int start, int offerset)
	{
		Session session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		return session.createCriteria(RfidBatch.class).setFirstResult(start).setMaxResults(offerset).list();
	}
}
