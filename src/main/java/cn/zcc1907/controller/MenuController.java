package cn.zcc1907.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zcc1907.bean.MenuBean;
import cn.zcc1907.bean.TreeBean;
import cn.zcc1907.dao.MenuDao;
import cn.zcc1907.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {

	private final static Logger logger = LoggerFactory.getLogger(MenuController.class);
	
	@Autowired
	MenuService ms;
	@Autowired
	MenuDao md;
	
	@RequestMapping("/load")
	@ResponseBody
	public MenuBean test(){
		MenuBean m = md.load("root");
		logger.info(m.toString());
		return m;
	}
	
	@RequestMapping("/tree")
	@ResponseBody
	public List<TreeBean> getTree(){
		MenuBean m = md.load("root");
		List<TreeBean> tree = new ArrayList<TreeBean>();
		for(Object n:m.getChildren()){
			MenuBean node = (MenuBean)n;
			TreeBean tb = new TreeBean();
			tb.setText(node.getText());
			tb.setIcon(node.getIcon());
			if(node.getChildren()!=null){
				List<TreeBean> ltb = new ArrayList<TreeBean>();
				for(Object o:node.getChildren()){
					MenuBean no = (MenuBean)o;
					TreeBean t = new TreeBean();
					t.setText(no.getText());
					t.setIcon(no.getIcon());
					ltb.add(t);
					t = null;
				}
				tb.setNodes(ltb);
			}
			tree.add(tb);
			tb = null;
		}
		return tree;
	}
	
	@RequestMapping("/index")
	public String toIndex(){
		return "index";
	}
	
	@RequestMapping("/menu")
	public String tolll(){
		return "menu";
	}
}
