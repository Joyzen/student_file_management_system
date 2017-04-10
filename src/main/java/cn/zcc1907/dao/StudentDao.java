package cn.zcc1907.dao;

import java.util.List;

import cn.zcc1907.bean.StudentBean;

public interface StudentDao {
	
	/**
	 * 查询student
	 * @param map
	 * @return
	 */
	public List<StudentBean> selectStudentByCondition(StudentBean student);
	
	/**
	 * 修改学生信息
	 * @param student
	 * @return
	 */
	public int updateStudentById(StudentBean student);
	
	/**
	 * 新增学生
	 * @param student
	 * @return
	 */
	public int insertStudent(StudentBean student);
	
	/**
	 * 删除学生
	 * @param sno
	 * @return
	 */
	public int delStudentById(int sno);
	
}
