package cn.zcc1907.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public String toUser(String userId,Model model){
		
		UserBean userBean = new UserBean();
		userBean.setUserId(userId);
		
		List<UserBean> lu = us.getUserList(userBean);
		
		if(lu.size()==1){
			model.addAttribute("user", lu.get(0));
		}
		
		return "user/user";
	}
	
	/**
	 * 
	 * @param user
	 * @return String
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	@ResponseBody
	public String updateUser(UserBean user){
		
		String message = "";//返回给客户端的操作回馈信息
		
		if(us.updateUser(user)){
			message = "success";
		}else{
			message = "fail";
		}
		
		return message;
	}
	
	@RequestMapping(value="form",method=RequestMethod.GET)
	public String form(){
		return "user/form";
	}
	
	@RequestMapping(value="updatePassword")
	@ResponseBody
	public String updatePassword(String npassword,String opassword,String uuserAccount){
		String message = "";//返回信息
		
		UserBean userBean = new UserBean();
		userBean.setPassword(opassword);
		userBean.setUserAccount(uuserAccount);
		
		List<UserBean> lu = us.getUserList(userBean);
		int result = lu.size();
		
		if(result==1){
			userBean.setPassword(npassword);
			userBean.setUserId(lu.get(0).getUserId());
			
			message = us.updateUser(userBean)?"success":"error";
			
		}else{
			message = result<1?"fail":"error";
		}
		
		return message;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delUser(String id){
		String message = null;
		
		if(us.delUser(id)){
			message = "success";
		}else{
			message = "fail";
		}
		
		return message;
	}
	
	
	@RequestMapping("/toadd")
	public String toAdd(Model model){
		model.addAttribute("user", new UserBean());
		return "user/user";
	}
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> addUser(UserBean user){
		
		Map<String,String> map = new HashMap<String,String>();
		
		String message = null;
		
		if(us.addUser(user)){
			message = "success";
		}else{
			message = "fail";
		}
		
		map.put("message", message);
		map.put("userId", user.getUserId());
		
		return map;
	}
	
}
