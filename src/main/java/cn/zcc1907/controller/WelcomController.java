package cn.zcc1907.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomController {

	@RequestMapping("/")
	public String toIndex(){
		return "index";
	}
	
}
