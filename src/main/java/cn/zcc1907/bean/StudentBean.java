package cn.zcc1907.bean;

import java.sql.Date;

public class StudentBean {

	/**
	 * 学生学号
	 */
	private int sno;
	
	/**
	 * 学生姓名
	 */
	private String name;
	
	/**
	 * 姓名（0：男，1：女）
	 */
	private int sex;
	
	/**
	 * 出生日期
	 */
	private Date birth;
	
	/**
	 * 电话
	 */
	private String phone;
	
	/**
	 * 电子邮箱
	 */
	private String email;
	
	/**
	 * 身份证号码
	 */
	private String idnum;
	
	/**
	 * 班级ID
	 */
	private int classId;
	
	/**
	 * 民族
	 */
	private String nation;
	
	/**
	 * 照片
	 */
	private String pic;

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdnum() {
		return idnum;
	}

	public void setIdnum(String idnum) {
		this.idnum = idnum;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
	
	
	
}
