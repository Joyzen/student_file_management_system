package cn.zcc1907.bean;

import java.util.List;

public class RoleBean {
	
	private String roleId;
	
	private String roleName;
	
	private String remark;
	
	private List<MenuBean> menus;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<MenuBean> getMenus() {
		return menus;
	}

	public void setMenus(List<MenuBean> menus) {
		this.menus = menus;
	}
	
	

}
