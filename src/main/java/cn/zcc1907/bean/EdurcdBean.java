package cn.zcc1907.bean;

import java.sql.Date;

public class EdurcdBean {

	private int id;
	
	private Date fro;
	
	private Date too;
	
	private String witness;
	
	private String position;
	
	private String school;
	
	private int sno;
	
	private String sname;

	public Date getToo() {
		return too;
	}

	public void setToo(Date too) {
		this.too = too;
	}

	public Date getFro() {
		return fro;
	}

	public void setFro(Date fro) {
		this.fro = fro;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWitness() {
		return witness;
	}

	public void setWitness(String witness) {
		this.witness = witness;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}
	
}
