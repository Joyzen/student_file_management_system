package cn.zcc1907.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.zcc1907.bean.Category;

@Mapper
public interface CategoryDao {

	public Category load(String cid);
	
	public List<Category> findByParent(String pid);
	
}
