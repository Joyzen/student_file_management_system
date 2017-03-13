package cn.zcc1907.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import cn.zcc1907.dao.MenuDao;
import cn.zcc1907.dao.RoleDao;
import cn.zcc1907.dao.UserDao;
import cn.zcc1907.service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	UserDao ud;
	@Autowired
	RoleDao rd;
	@Autowired
	MenuDao md;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GrantedAuthority> getAuthoritiesByUserAccount() {
		// TODO Auto-generated method stub
		return null;
	}

}
