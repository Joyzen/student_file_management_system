package cn.zcc1907.dao;

import java.util.List;

import cn.zcc1907.bean.RwdpunishBean;

public interface RwdpunishDao {

	public List<RwdpunishBean> list(RwdpunishBean rwdpunishBean);
	
	public int insert(RwdpunishBean rwdpunishBean);
	
	public int update(RwdpunishBean rwdpunishBean);
	
	public int del(int id);
	
}
