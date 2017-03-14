package cn.zcc1907.dao;

import java.awt.Menu;
import java.util.List;
import java.util.Map;

import cn.zcc1907.bean.RoleBean;

public interface RoleDao {

	/**
	 * 根据条件查询Role记录
	 * @param map
	 * @return
	 */
	public List<RoleBean> selectRoleByCondition(Map map);
	
	/**
	 * 插入一条Role记录
	 * @param role
	 * @return
	 */
	public int insertRole(RoleBean role);
	
	/**
	 * 根据条件删除Role记录
	 * @param map
	 * @return
	 */
	public int delRole(Map map);
	
	/**
	 * 修改一条Role信息
	 * @return
	 */
	public int updateRole(RoleBean role);
	
	/**
	 * 根据账户查询Role
	 * @param id
	 * @return
	 */
	public List<Menu> selectRoleByUserAccount(String userAccount);
	
}
