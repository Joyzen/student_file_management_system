package cn.zcc1907.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cn.zcc1907.bean.RoleBean;
import cn.zcc1907.bean.UserBean;
import cn.zcc1907.dao.RoleDao;
import cn.zcc1907.dao.UserDao;
import cn.zcc1907.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao ud;
	@Autowired
	RoleDao rd;
	
	/**
	 * spring security用户验证方法实现
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Map<String,String> map = new HashMap<String,String>();
		map.put("userAccount", username);
		List<UserBean> lu = ud.selectUserByCondition(map);
		if(lu.size()==1){
			UserBean user = lu.get(0);
			List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
			for(RoleBean role:user.getRoles()){
				System.out.println(role.getRoleName());
				authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
			}
			//return lu.get(0);
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
	                authorities);
		}else if(lu.size()>1){
			throw new RuntimeException("系统错误，用户名重复！");
		}
		throw new UsernameNotFoundException("用户名不存在");
	}

	@Override
	//查询用户
	public List<UserBean> getUserList(UserBean userBean) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", userBean.getUserId());
		map.put("userAccount", userBean.getUserAccount());
		map.put("password", userBean.getPassword());
		
		List<UserBean> lu = ud.selectUserByCondition(map);
		
		return lu;
	}
	
	@Override
	public boolean updateUser(UserBean userBean){
		
		if(ud.updateUserById(userBean)>-1){//
			return true;
		}
		
		return false;
	}

	@Override
	public boolean delUser(String id) {
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("userId", id);
		
		if(ud.delUser(map)==1){
			return true;
		}
		
		return false;
	}

	@Override
	public boolean addUser(UserBean userBean) {

		if(ud.insertUser(userBean)==1){
			return true;
		}
		
		return false;
	}

	
	public void updateUserRole(String userId,String[] powers){
		rd.delUserRole(userId);
		for(String roleId:powers){
			Map<String,String> map = new HashMap<String,String>();
			map.put("userId", userId);
			map.put("roleId", roleId);
			rd.insertUserRole(map);
			map = null;
		}
	}

}
