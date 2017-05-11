package cn.zcc1907.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SystemController {

	/**
	 * 映射项目根路径到登录页面
	 * @return
	 */
	@RequestMapping("/")
	public String toLogin(){
		return "index";
	}
	
	/**
	 * 映射到主页面
	 * @return
	 */
	@RequestMapping("/index")
	public String toIndex(){
		return "index";
	}
	
	/**
	 * 映射到无权限页面
	 * @return
	 */
	@RequestMapping("/403")
	public String toNoPower(){
		return "403";
	}
	
	@RequestMapping("/404")
	public String toNotFound(){
		return "404";
	}
	
	@RequestMapping("/500")
	public String toServererror(){
		return "500";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String toLogi(){
		return "sign-in";
	}
	
}
