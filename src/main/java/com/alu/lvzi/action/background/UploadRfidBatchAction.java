package com.alu.lvzi.action.background;

import java.io.File;

import com.alu.lvzi.pojo.Admin;
import com.alu.lvzi.service.RfidBatchService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UploadRfidBatchAction extends ActionSupport
{
	private static final long serialVersionUID = 6364300484519922523L;
	
	private File batch;
	private String batchFileName;
	private String batchContentType;
	private RfidBatchService rfidBatchService;

	public File getBatch()
	{
		return batch;
	}

	public void setBatch(File batch)
	{
		this.batch = batch;
	}

	public String getBatchFileName()
	{
		return batchFileName;
	}

	public void setBatchFileName(String batchFileName)
	{
		this.batchFileName = batchFileName;
	}

	public String getBatchContentType()
	{
		return batchContentType;
	}

	public void setBatchContentType(String batchContentType)
	{
		this.batchContentType = batchContentType;
	}

	public RfidBatchService getRfidBatchService()
	{
		return rfidBatchService;
	}

	public void setRfidBatchService(RfidBatchService rfidBatchService)
	{
		this.rfidBatchService = rfidBatchService;
	}

	public String upload()
	{

		Object object = ActionContext.getContext().getSession().get("user");
		if (object instanceof Admin)
		{
			boolean batchUploadResult = rfidBatchService.saveRfidBatches(batch, batchFileName, (Admin) object);
			ActionContext.getContext().getSession().put("batchUploadResult", batchUploadResult);
		}

		return SUCCESS;
	}
}
