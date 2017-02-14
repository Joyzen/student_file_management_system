package cn.zcc1907.bean;

import java.util.List;

public class TreeBean {

	private String text;
	
	private List<TreeBean> nodes;
	
	private String icon;
	
	
	
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<TreeBean> getNodes() {
		return nodes;
	}
	public void setNodes(List<TreeBean> nodes) {
		this.nodes = nodes;
	}
	
}
