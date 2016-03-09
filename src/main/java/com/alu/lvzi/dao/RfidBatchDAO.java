package com.alu.lvzi.dao;

import java.util.List;

import com.alu.lvzi.pojo.RfidBatch;

public interface RfidBatchDAO extends GenericDAO<RfidBatch, Integer>
{
	abstract public Long findTotalCount();
	abstract public List<RfidBatch> findBatchesByPagination(int start, int offerset);
}
