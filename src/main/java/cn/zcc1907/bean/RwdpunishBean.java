package cn.zcc1907.bean;

import java.sql.Date;

public class RwdpunishBean {

	private int id;
	
	private Date date;
	
	private String record;
	
	private int flag;
	
	private String place;
	
	private int sno;
	private String sname;
	
	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	private StudentBean student;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public StudentBean getStudent() {
		return student;
	}

	public void setStudent(StudentBean student) {
		this.student = student;
	}
	
}
