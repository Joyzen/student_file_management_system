package cn.zcc1907.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zcc1907.bean.MenuBean;
import cn.zcc1907.dao.MenuDao;

public interface MenuService {

	public List<MenuBean> getMenu();//获取菜单数据
	
}
