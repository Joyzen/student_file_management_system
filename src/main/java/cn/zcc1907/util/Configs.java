package cn.zcc1907.util;

import java.util.ArrayList;
import java.util.List;

import com.mysql.fabric.xmlrpc.base.Array;

/**
 * 一些系统变量参数配置
 * @author Administrator
 *
 */
public class Configs {

	/**
	 * 分页每页数据行数
	 */
	public static final int pageSzie = 5;  
	
	/**
	 * 分页导航栏页数(必须设置为奇数切大于1)
	 */
	public static final int pages = 5;  
	
	/**
	 * 获取分页导航栏页数
	 * @param pageNum 当前页数
	 * @param total  总页数
	 * @return
	 */
	public static List<String> getPagination(int pageNum,int total){
		List<String> l = new ArrayList<String>();
		int start = pageNum-(pages-1)/2;
		int end = pageNum+(pages-1)/2;
		if(start<0){
			start = 0;
			end = pages-1;
		}else if(end>total){
			start = (int)total+1-pages;
			end = total;
		}
		for(;start<=end;start++){
			l.add(start+"");
		}
		return l;
	}
	
}