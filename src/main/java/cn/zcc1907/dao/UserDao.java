package cn.zcc1907.dao;

import java.util.List;
import java.util.Map;

import cn.zcc1907.bean.UserBean;

public interface UserDao {

	/**
	 * 根据条件查询User
	 * @param map
	 */
	public List<UserBean> selectUserByCondition(Map map);
	
	/**
	 * 插入一条User记录
	 */
	public int insertUser(UserBean user);
	
	/**
	 * 根据条件删除User记录
	 */
	public int delUser(Map map);
	
	/**
	 * 根据ID修改User记录
	 */
	public int updateUserById(UserBean user);
	
	
}
