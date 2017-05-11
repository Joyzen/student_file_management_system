package cn.zcc1907.controller;

import java.util.HashMap;
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

import cn.zcc1907.bean.ClassBean;
import cn.zcc1907.bean.StudentBean;
import cn.zcc1907.dao.ClassDao;

@Controller
@RequestMapping("/class")
@PreAuthorize("hasAnyRole('class')")
public class ClassController {

	@Resource
	ClassDao cd;
	@RequestMapping(value="/page",method=RequestMethod.GET)
	public String toPage(){
		return "class/class";
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	@ResponseBody
	public String getList(ClassBean classBean,
			@RequestParam(defaultValue="",required=false)String search,
			@RequestParam(defaultValue="0",required=false)int limit,
			@RequestParam(defaultValue="0",required=false)int offset){
		String data = null;
		classBean.setName(search);
		Map<String,Object> map = new HashMap<String,Object>();
		
		Page<StudentBean> page = PageHelper.offsetPage(offset, limit);
		cd.select(classBean);
		
		map.put("rows", page.getResult());
		map.put("total", page.getTotal());
		
		JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
		data = JSON.toJSONString(map,SerializerFeature.WriteDateUseDateFormat);
		
		return data;
	}
	
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String form(){
		return "class/classform";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public String update(ClassBean classBean){
		return cd.update(classBean)==1?"success":"fail";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public String add(ClassBean classBean){
		return cd.insert(classBean)==1?"success":"fail";
	}
	
	@RequestMapping(value="/del",method=RequestMethod.POST)
	@ResponseBody
	public String del(int id){
		return cd.delete(id)==1?"success":"fail";
	}
	
}
