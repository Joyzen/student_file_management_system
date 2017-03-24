package cn.zcc1907.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.zcc1907.bean.UserBean;
import cn.zcc1907.service.UserService;
import cn.zcc1907.util.Configs;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final Log logger = LogFactory.getLog(UserController.class);
	
	@Autowired
	UserService us;
	
	/**
	 * 用户页面信息
	 * @param pageNum
	 * @param model
	 * @return
	 */
	@RequestMapping("/users")
	public String toUsersPage(@RequestParam(defaultValue="1",required=false)int pageNum,
							  UserBean condition,
							  Model model){
		logger.info(condition.getUserId());
		
		if(pageNum<1){
			pageNum = 1;
		}//避免页数小于零的情况
		
		Page<UserBean> page = PageHelper.startPage(pageNum, Configs.pageSzie);
		
		us.getUserList(condition);  //使用了PageHelper,返回结果储存在page对象中
		
		model.addAttribute("users",page.getResult());//展示的结果集
		
		Configs.setPagination(model, pageNum, page.getPages()); //调用公共方法设置分页所需参数
		
		return "user/users";
	}
	
}
