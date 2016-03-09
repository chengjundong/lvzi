package com.alu.lvzi.action.background;


import com.alu.lvzi.pagination.Pagination;
import com.alu.lvzi.pojo.RfidBatch;
import com.alu.lvzi.service.RfidBatchService;
import com.opensymphony.xwork2.ActionSupport;

public class RfidManagementAction extends ActionSupport
{
	private static final long serialVersionUID = 3418680825762900067L;
	
	private RfidBatchService rfidBatchService;
	private Pagination<RfidBatch> page = new Pagination<RfidBatch>();
	private Integer currentPageNo;

	public RfidBatchService getRfidBatchService()
	{
		return rfidBatchService;
	}

	public void setRfidBatchService(RfidBatchService rfidBatchService)
	{
		this.rfidBatchService = rfidBatchService;
	}
	
	public void setCurrentPageNo(Integer currentPageNo)
	{
		this.currentPageNo = currentPageNo;
	}
	
	public Pagination<RfidBatch> getPage()
	{
		return page;
	}

	public void setPage(Pagination<RfidBatch> page)
	{
		this.page = page;
	}

	public String queryRfidBatches()
	{
		page.setCurrentPageNo(currentPageNo);
		page = rfidBatchService.findByPagination(page);
		
		return SUCCESS;
	}
}
