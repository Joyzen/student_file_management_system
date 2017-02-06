package cn.zcc1907.bean;

import java.util.List;

public class Category {

	private String cid;   //分类主键
	private String cname;   //分类名
	private Category parent;  //父分类，是根据pid的自连接对象，一个二级分类只有一个一级分类
	private String desc;   //描述
	private List<Category> children;  //子分类，一个一级分类可能有多个二级分类，而二级分类无子分类
	
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
	public Category getParent() {
		return parent;
	}
	public void setParent(Category parent) {
		this.parent = parent;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public List<Category> getChildren() {
		return children;
	}
	public void setChildren(List<Category> children) {
		this.children = children;
	}
	
}
