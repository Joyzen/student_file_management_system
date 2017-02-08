package cn.zcc1907.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zcc1907.bean.Category;
import cn.zcc1907.bean.MenuBean;
import cn.zcc1907.dao.CategoryDao;
import cn.zcc1907.dao.MenuDao;
import cn.zcc1907.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {

	private final static Logger logger = LoggerFactory.getLogger(MenuController.class);
	
	@Autowired
	MenuService ms;
	@Autowired
	CategoryDao cd;
	@Autowired
	MenuDao md;
	
	
	@RequestMapping("/g")
	@ResponseBody
	public Category getMenu(){
		return cd.load("root");
	}
	
	@RequestMapping("/load")
	@ResponseBody
	public MenuBean test(){
		MenuBean m = md.load("root");
		logger.info(m.toString());
		return m;
	}
	
	@RequestMapping("/index")
	public String toIndex(){
		return "index";
	}
	
	@RequestMapping("/c")
	public String tolll(){
		return "calendar";
	}
}
