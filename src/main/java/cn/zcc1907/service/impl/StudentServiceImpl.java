package cn.zcc1907.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zcc1907.bean.StudentBean;
import cn.zcc1907.dao.StudentDao;
import cn.zcc1907.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Resource
	private StudentDao sd;
	
	@Override
	public List<StudentBean> selectStudent(StudentBean student) {
		return sd.selectStudentByCondition(student);
	}

	@Override
	public boolean update(StudentBean student) {
		return sd.updateStudentById(student)==1?true:false;
	}

	@Override
	public boolean insert(StudentBean student) {
		return sd.insertStudent(student)==1?true:false;
	}

	@Override
	public boolean delete(int sno) {
		return sd.delStudentById(sno)==1?true:false;
	}

}
