package cn.zcc1907.dao;

import java.util.List;

import cn.zcc1907.bean.ClassBean;

public interface ClassDao {

	public List<ClassBean> select(ClassBean classbean);
	
	public int insert(ClassBean classBean);
	
	public int update(ClassBean classBean);
	
	public int delete(int id);
	
}
