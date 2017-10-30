package cn.itcast.estore.domain;

public class Category {
	private String cid;				//分类ID
	private String cname;			//分类名称
	private String description;		//分类描述
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + ", description=" + description + "]";
	}
	
	
}

