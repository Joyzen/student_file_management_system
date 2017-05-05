package cn.zcc1907.service;

import java.util.List;
import java.util.Map;

import cn.zcc1907.bean.StudentBean;

public interface StudentService {

	public List<StudentBean> selectStudent(StudentBean student);
	
	public boolean update(StudentBean student);
	
	public boolean insert(StudentBean student);
	
	public boolean delete(int	sno);
	
	
}
