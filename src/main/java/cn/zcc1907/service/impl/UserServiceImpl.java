package cn.zcc1907.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.zcc1907.bean.UserBean;
import cn.zcc1907.dao.MenuDao;
import cn.zcc1907.dao.RoleDao;
import cn.zcc1907.dao.UserDao;
import cn.zcc1907.service.UserService;
import cn.zcc1907.util.Configs;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao ud;
	
	/**
	 * spring security用户验证方法实现
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Map<String,String> map = new HashMap<String,String>();
		map.put("userAccount", username);
		List<UserBean> lu = ud.selectUserByCondition(map);
		if(lu.size()==1){
			return lu.get(0);
		}else if(lu.size()>1){
			throw new RuntimeException("系统错误，用户名重复！");
		}
		throw new UsernameNotFoundException("用户名不存在");
	}

	@Override
	public Page<UserBean> getUserList(Map map) {
		Page<UserBean> page = PageHelper.startPage((Integer)map.get("pageNum"), Configs.pageSzie);
		ud.selectUserByCondition(map);
		return page;
	}


}
