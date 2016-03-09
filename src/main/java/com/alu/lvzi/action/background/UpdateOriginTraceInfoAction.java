package com.alu.lvzi.action.background;

import com.alu.lvzi.pojo.RfidBatch;
import com.alu.lvzi.service.RfidBatchService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UpdateOriginTraceInfoAction extends ActionSupport implements ModelDriven<RfidBatch>
{
	private RfidBatchService rfidBatchService;
	private Integer batchId;
	private RfidBatch batch;
	
	@Override
	public RfidBatch getModel()
	{
		return new RfidBatch();
	}
	
	public void setRfidBatchService(RfidBatchService rfidBatchService)
	{
		this.rfidBatchService = rfidBatchService;
	}

	public void setBatchId(Integer batchId)
	{
		this.batchId = batchId;
	}
	
	public RfidBatch getBatch()
	{
		return batch;
	}

	@Override
	public String execute() throws Exception
	{
		batch = rfidBatchService.get(batchId);
		return SUCCESS;
	}
	
	public String doUpate()
	{
		rfidBatchService.add(batch);
		return SUCCESS;
	}
}
