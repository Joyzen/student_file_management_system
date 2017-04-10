package cn.zcc1907.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.zcc1907.bean.StudentBean;
import cn.zcc1907.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Resource
	StudentService ss;
	
	@RequestMapping(value="/students",method=RequestMethod.GET)
	public String listStudent(){
		return "students/student";
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	@ResponseBody
	public String getList(StudentBean student,int limit,int offset){
		String data = null;
		Map<String,Object> map = new HashMap<String,Object>();
		
		Page<StudentBean> page = PageHelper.startPage(offset, limit);
		ss.selectStudent(student);
		map.put("rows", page.getResult());
		map.put("total", page.getTotal());
		//map.put("page", page.getPages());
		
		data = JSON.toJSONString(map);
		
		return data;
	}
	
}
