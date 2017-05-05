package cn.zcc1907.dao;

import java.util.List;

import cn.zcc1907.bean.EdurcdBean;

public interface EdurcdDao {

	public List<EdurcdBean> select(EdurcdBean edurcd);
	
	public int update(EdurcdBean edurcd);
	
	public int insert(EdurcdBean edurcd);
	
	public int delete(int id);
	
}
