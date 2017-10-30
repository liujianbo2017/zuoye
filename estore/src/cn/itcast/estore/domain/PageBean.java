package cn.itcast.estore.domain;

import java.util.List;

public class PageBean<T> {

	private List<T> data;  //本页的数据集合
	private int pageNum;   //当前页号
	private int pageSize;  //页大小
	private long recordCount; //总记录条数
	private int pageCount;   //总页数
	private int startIndex;  //起始下标
	
	
	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageBean(List<T> data, int pageNum, int pageSize, long recordCount, int pageCount, int startIndex) {
		super();
		this.data = data;
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.recordCount = recordCount;
		this.pageCount = pageCount;
		this.startIndex = startIndex;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(long recordCount) {
		this.recordCount = recordCount;
	}
	public int getPageCount() {
		//总页数为总记录条数除以页大小,根据是否有余数决定是否加1
		this.pageCount = (int)recordCount/pageSize + (recordCount%pageSize==0?0:1);
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getStartIndex() {
		//在数据库中执行SQL语句时的起始下标时: 页号减一乘以页大小
		this.startIndex = (pageNum-1)*pageSize;
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	
	
}
