package cn.zcc1907.bean;

import java.util.List;

/**
 * 菜单数据bean
 * @author Joyzen
 *
 */

public class MenuBean {

	private String id;//菜单项ID
	
	private String text;//菜单显示名称
	
	private String parent;//菜单上级菜单ID
	
	private List<MenuBean> children;//下级菜单
	
	private String path;//菜单对应页面js文件地址
	
	private boolean leaf;//该菜单项是否为叶子结点
	
	private String icon;
	
	private short order;

	public void setChildren(List<MenuBean> children) {
		this.children = children;
	}
	
	public List<MenuBean> getChildren() {
		return children;
	}
	
	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public short getOrder() {
		return order;
	}

	public void setOrder(short order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "MenuBean [id=" + id + ", text=" + text + ", parent=" + parent + ", children=" + children + ", path="
				+ path + ", leaf=" + leaf + ", icon=" + icon + ", order=" + order + "]";
	}
	
}
