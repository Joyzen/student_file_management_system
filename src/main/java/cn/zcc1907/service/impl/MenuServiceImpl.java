package cn.zcc1907.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zcc1907.bean.MenuBean;
import cn.zcc1907.dao.MenuDao;
import cn.zcc1907.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Resource
	MenuDao md;
	
	@Override
	public List<MenuBean> getMenu() {
		Map map = new HashMap<String, String>();
		map.put("id", "root");
		return md.selectMenuByCondition("root");
	}

}
