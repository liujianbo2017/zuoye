package cn.itcast.estore.domain;

import java.util.List;

//为了配合datagrid组件的分页JavaBean
public class PaginationBean<T> {

	private List<T> rows;      //本页数据
	private int total;         //总条数
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
}
