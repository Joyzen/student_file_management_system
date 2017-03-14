package cn.zcc1907.service;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

	/**
	 * 根据账号查询User权限
	 * @return
	 */
	public List<GrantedAuthority> getAuthoritiesByUserAccount(String userAccount);
	
}
