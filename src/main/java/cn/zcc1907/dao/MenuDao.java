package cn.zcc1907.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.zcc1907.bean.MenuBean;

/**
 * 
 * @author Joyzen
 *操作菜单数据DAO
 */
@Mapper
public interface MenuDao {

	public MenuBean load(String id);//根据传入条件查询菜单及其子菜单项
	
	public List<MenuBean> findByParent(String id);//根据ID查找子菜单项
	
	public List<MenuBean> selectMenusByRoleId(String roleId);  //根据ID查询Menu
	
}
