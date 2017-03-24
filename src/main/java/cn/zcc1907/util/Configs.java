package cn.zcc1907.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;

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
	public static List<String> getPaginations(int pageNum,int total){
		List<String> l = new ArrayList<String>();
		int start = pageNum-(pages-1)/2;
		int end = pageNum+(pages-1)/2;
		if(start<1){//设置起始页标签
			start = 1;
			if(total<pages){
				end = total;
			}else{
				end = pages;
			}
		}
		if(end>total){//设置尾页标签
			end = total;
			if(total<pages){
				start = 1;
			}else{
				start = total+1-pages;
			}
		}
		for(;start<=end;start++){//分页栏展示序号集
			l.add(start+"");
		}
		return l;
	}
	
	/**
	 * 分页参数设置公用方法
	 * @param model  请求返回Mode
	 * @param pageNum  当前页
	 * @param total 总页数
	 */
	public static void setPagination(final Model model,int pageNum,int total){
		
		model.addAttribute("pages",//页签导航数字
				Configs.getPaginations(pageNum,total));
		
		model.addAttribute("pageNum",pageNum);//当前页
		
		model.addAttribute("total",total);//总页数
		
		model.addAttribute("prePage",pageNum>1?(pageNum-1):1);//上一页
		
		model.addAttribute("nextPage",
				(pageNum+1)>total?total:(pageNum+1));//下一页
	}
	
}
