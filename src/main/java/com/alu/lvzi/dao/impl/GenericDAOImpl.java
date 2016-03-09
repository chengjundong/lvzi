package com.alu.lvzi.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.alu.lvzi.dao.GenericDAO;

/**
 * 
 * @author jundonch
 * @since 2016-1-21
 *
 * @param <E>
 * @param <PK>
 */
public class GenericDAOImpl<E extends Serializable, PK extends Serializable> 
	extends HibernateDaoSupport implements GenericDAO<E, PK>
{

	private Class<E> entityClass;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl()
	{
		ParameterizedType type = (ParameterizedType)getClass().getGenericSuperclass();
		this.entityClass = (Class<E>)type.getActualTypeArguments()[0];
	}
	
	@SuppressWarnings("unchecked")
	public void add(E... entities)
	{
		
		for (int i=0;i<entities.length;i++)
		{
			this.getHibernateTemplate().save(entities[i]);
			if(i % 20 ==0)
			{
				this.getHibernateTemplate().flush();
				this.getHibernateTemplate().clear();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void update(E... entities)
	{
		for (int i=0;i<entities.length;i++)
		{
			this.getHibernateTemplate().update(entities[i]);
			if(i % 20 ==0)
			{
				this.getHibernateTemplate().flush();
				this.getHibernateTemplate().clear();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void merge(E... entities)
	{
		for (int i=0;i<entities.length;i++)
		{
			this.getHibernateTemplate().merge(entities[i]);
			if(i % 20 ==0)
			{
				this.getHibernateTemplate().flush();
				this.getHibernateTemplate().clear();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void delete(E... entities)
	{
		for (int i=0;i<entities.length;i++)
		{
			this.getHibernateTemplate().delete(entities[i]);
			if(i % 20 ==0)
			{
				this.getHibernateTemplate().flush();
				this.getHibernateTemplate().clear();
			}
		}
	}

	public E findById(PK pk)
	{
		return this.getHibernateTemplate().get(entityClass, pk);
	}
	
	public List<E> findAll()
	{
		List<E> result = this.getHibernateTemplate().loadAll(entityClass);
		return null == result ? new ArrayList<E>() : result;
	}

	@SuppressWarnings("unchecked")
	public List<E> findByHQL(String hql)
	{
		List<E> result = (List<E>) this.getHibernateTemplate().find(hql);
		return null == result ? new ArrayList<E>() : result;
	}

	@SuppressWarnings("unchecked")
	public List<E> findByCriteria(DetachedCriteria criteria)
	{
		List<E> result = (List<E>) this.getHibernateTemplate().findByCriteria(criteria);
		return null == result ? new ArrayList<E>() : result;
	}

}
