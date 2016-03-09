package com.alu.lvzi.service;

import java.io.File;
import java.util.List;

import com.alu.lvzi.pagination.Pagination;
import com.alu.lvzi.pojo.Admin;
import com.alu.lvzi.pojo.RfidBatch;

public interface RfidBatchService
{
	abstract public boolean saveRfidBatches(File batchFile, String fileName, Admin operator);
	abstract public List<RfidBatch> findAll();
	abstract public Pagination<RfidBatch> findByPagination(Pagination<RfidBatch> pagination);
	abstract public RfidBatch get(Integer id);
	abstract public void add(RfidBatch... batches);
}
