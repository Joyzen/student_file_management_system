package cn.zcc1907.service;

import java.util.List;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.github.pagehelper.Page;

import cn.zcc1907.bean.UserBean;

public interface UserService extends UserDetailsService {

	
	/**
	 * 获取用户信息列表
	 */
	public List<UserBean> getUserList(UserBean userBean);
	
	/**
	 * 更新用户资料
	 * @param userBean
	 * @return
	 */
	public boolean updateUser(UserBean userBean);
	
	/**
	 * 删除用户账号
	 * @param id
	 * @return
	 */
	public boolean delUser(String id);
	
	/**
	 * 新增用户
	 * @param userBean
	 * @return
	 */
	public boolean addUser(UserBean userBean);
	
	public void updateUserRole(String userId,String[] powers);
	
}
