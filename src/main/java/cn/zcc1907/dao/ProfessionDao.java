package cn.zcc1907.dao;

import java.util.List;

import cn.zcc1907.bean.ProfessionBean;

public interface ProfessionDao {

	public List<ProfessionBean> select(ProfessionBean profession);
	
	public int insert(ProfessionBean profession);
	
	public int update(ProfessionBean profession);
	
	public int delete(int id);
	
}
