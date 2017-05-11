package cn.zcc1907.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.zcc1907.bean.StudentBean;
import cn.zcc1907.service.StudentService;

@Controller
@RequestMapping("/student")
@PreAuthorize("hasAnyRole('student')")
public class StudentController {

	@Resource
	StudentService ss;
	
	@RequestMapping(value="/students",method=RequestMethod.GET)
	public String listStudent(){
		return "students/student";
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	@ResponseBody
	public String getList(StudentBean student,
			@RequestParam(defaultValue="",required=false)String search,
			@RequestParam(defaultValue="0",required=false)int limit,
			@RequestParam(defaultValue="0",required=false)int offset){
		String data = null;
		student.setName(search);
		Map<String,Object> map = new HashMap<String,Object>();
		
		Page<StudentBean> page = PageHelper.offsetPage(offset, limit);
		ss.selectStudent(student);
		
		map.put("rows", page.getResult());
		map.put("total", page.getTotal());
		
		JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
		data = JSON.toJSONString(map,SerializerFeature.WriteDateUseDateFormat);
		
		return data;
	}
	
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String form(){
		return "students/form";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public String update(StudentBean student){
		return ss.update(student)?"success":"fail";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public String add(StudentBean student){
		return ss.insert(student)?"success":"fail";
	}
	
	@RequestMapping(value="/del",method=RequestMethod.POST)
	@ResponseBody
	public String del(int sno){
		return ss.delete(sno)?"success":"fail";
	}
	
}
