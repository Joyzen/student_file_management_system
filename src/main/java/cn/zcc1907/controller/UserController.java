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
	public String toUsersPage(@RequestParam(defaultValue="1",required=false)int pageNum
							  ,Model model){
		//us.getUserList(pageNum);
		if(pageNum<1){
			pageNum = 1;
		}//避免页数小于零的情况
		Map map = new HashMap();
		map.put("pageNum", pageNum);
		Page<UserBean> page = us.getUserList(map);
		if(pageNum>((int)page.getTotal()/Configs.pageSzie+1)){
			pageNum = (int)page.getTotal()/Configs.pageSzie+1;
		}
		model.addAttribute("users",page.getResult());//展示的结果集
		
		model.addAttribute("pages",//页签导航数字
				Configs.getPaginations(pageNum,(int)page.getTotal()));
		
		model.addAttribute("pageNum",pageNum);//当前页
		
		model.addAttribute("total",//总页数
				((int)page.getTotal()/Configs.pageSzie+1));
		//TODO--此处关于分页数据显示的方法应有较大改进和抽象空间
		return "user/users";
	}
	
}
