package cn.zcc1907.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.Page;

import cn.zcc1907.bean.UserBean;
import cn.zcc1907.service.UserService;
import cn.zcc1907.util.Configs;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService us;
	
	/**
	 * 用户页面信息
	 * @param pageNum
	 * @param model
	 * @return
	 */
	@RequestMapping("/users")
	public String toUsersPage(@RequestParam(defaultValue="0",required=false)int pageNum
							  ,Model model){
		//us.getUserList(pageNum);
		if(pageNum<0){
			pageNum = 0;
		}//避免页数小于零的情况
		Map map = new HashMap();
		map.put("pageNum", pageNum);
		Page<UserBean> page = us.getUserList(map);
		model.addAttribute("users",page.getResult());
		model.addAttribute("pages",Configs.getPagination(pageNum,(int)page.getTotal()));
		model.addAttribute("pageNum",pageNum);
		return "/user/users";
	}
	
}
