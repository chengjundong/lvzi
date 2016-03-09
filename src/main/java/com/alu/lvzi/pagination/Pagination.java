package com.alu.lvzi.pagination;

import java.util.List;

/**
 * 分页Bean
 * 
 * @author jundonch
 * @since 2016/2/4
 *
 * @param <T>
 */
public class Pagination<T>
{
	private final int startPageOffset;
	private final int endPageOffset;
	private final int pageElementsCount;
	
	private int startPageNo;
	private int endPageNo;
	private int currentPageNo;
	private int totalPageCount;
	private int totalElementsCount;
	private List<T> elements;

	/**
	 * 默认构造：
	 * 显示前4页页码、后5页页码
	 * 页面大小是5
	 */
	public Pagination()
	{
		this.startPageOffset = 4;
		this.endPageOffset = 5;
		this.pageElementsCount = 5;
	}
	
	/**
	 * 自定义当前页的向前偏移量、向后偏移量、总页面大小
	 * 
	 * @param startPageOffset
	 * @param endPageOffset
	 * @param pageElementsCount
	 */
	public Pagination(int startPageOffset, int endPageOffset, int pageElementsCount)
	{
		this.startPageOffset = startPageOffset;
		this.endPageOffset = endPageOffset;
		this.pageElementsCount = pageElementsCount;
	}

	public int getPageElementsCount()
	{
		return pageElementsCount;
	}

	public int getCurrentPageNo()
	{
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo)
	{
		this.currentPageNo = currentPageNo;
	}

	public List<T> getElements()
	{
		return elements;
	}

	public int getTotalElementsCount()
	{
		return totalElementsCount;
	}

	public int getStartPageNo()
	{
		return startPageNo;
	}

	public int getEndPageNo()
	{
		return endPageNo;
	}

	public int getTotalPageCount()
	{
		return totalPageCount;
	}
	
	public int getCurrentRecordStartIndex()
	{
		return this.pageElementsCount * (this.currentPageNo - 1);
	}

	/**
	 * 当查询出了总元素数量和当前页面需要的所有元素后，可以调用该方法对分页数据进行全部初始化
	 * 
	 * @param totalElementsCount
	 * @param elements
	 */
	public void initPagination(int totalElementsCount, List<T> elements)
	{
		// 保存总元素数量 & 当前页面需要的元素
		this.totalElementsCount = totalElementsCount;
		this.elements = elements;
				
		// 计算出总页面数量：（总元素数量-1）/页面大小 + 1
		this.totalPageCount = (this.totalElementsCount - 1) / pageElementsCount + 1;
		
		// 初始化首页、尾页
		this.startPageNo = 1;
		this.endPageNo = this.totalPageCount;
		
		// 计算出需要显示的页码数量
		int diplayPageNumber = this.startPageOffset + this.endPageOffset + 1;
		
		// 如果总页数大于需要显示的页数
		if(this.totalPageCount > diplayPageNumber)
		{
			// 使用当前页码和前后显示的偏移量重新计算首页与尾页
			this.startPageNo = this.currentPageNo - this.startPageOffset;
			this.endPageNo = this.currentPageNo + this.endPageOffset;
			
			// 检查首页。如果首页小于1说明当前页位于第一页与首页偏移量边界之间，所以首页就等于1
			// 尾页就等于要显示的页码数
			if(1 > this.startPageNo)
			{
				this.startPageNo = 1;
				this.endPageNo = diplayPageNumber;
			}
			
			// 检查尾页。如果总页数小于尾页，说明当前页位于总页数与尾页偏移量边界之间，所以尾页就等于总页数
			// 首页就等于尾页减去需要显示的页数+1
			if(this.totalPageCount < this.endPageNo)
			{
				this.endPageNo = this.totalPageCount;
				this.startPageNo = this.totalPageCount - diplayPageNumber + 1;
			}
		}
	}
}
