package cn.zcc1907.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring4.context.SpringWebContext;

@Controller
public class SystemController {

	/**
	 * 映射项目根路径到登录页面
	 * @return
	 */
	@RequestMapping("/")
	public String toLogin(){
		return "sign-in";
	}
	/**
	 * 映射到主页面
	 * @return
	 */
	@RequestMapping("/index")
	public String toIndex(){
		return "index";
	}
	
	
	
}
