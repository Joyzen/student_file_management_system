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
	
}
