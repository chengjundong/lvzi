package com.alu.lvzi.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

/**
 * 
 * @author jundonch
 * @since 2016-1-21
 *
 * @param <E> Class of POJO entity
 * @param <PK>
 */
public interface GenericDAO<E extends Serializable, PK extends Serializable>
{
	@SuppressWarnings("unchecked")
	abstract public void add(E... entities);
	@SuppressWarnings("unchecked")
	abstract public void update(E... entities);
	@SuppressWarnings("unchecked")
	abstract public void merge(E... entities);
	@SuppressWarnings("unchecked")
	abstract public void delete(E... entities);
	abstract public E findById(PK pk);
	abstract public List<E> findAll();
	abstract public List<E> findByHQL(String hql);
	abstract public List<E> findByCriteria(DetachedCriteria criteria);
}
