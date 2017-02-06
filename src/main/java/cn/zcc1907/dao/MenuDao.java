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

	public List<MenuBean> selectMenuByCondition(String id);//根据传入条件查询
	
	public List<MenuBean> selectMenuChildren(String id);//根据ID查找子菜单项
	
}
