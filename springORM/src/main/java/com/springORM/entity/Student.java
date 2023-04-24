package com.springORM.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Student")
public class Student {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stuId;
	
	@Column(name="Name")
	private String stuName;
	
	@Column(name="Subject")
	private String subject;
	
	@Column(name="Mobile_No")
	private String mobileNo;
	
	public Student() {}

	public Student(int stuId, String stuName, String subject, String mobileNo) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.subject = subject;
		this.mobileNo = mobileNo;
	}

	
	public Student(String stuName, String subject, String mobileNo) {
		super();
		this.stuName = stuName;
		this.subject = subject;
		this.mobileNo = mobileNo;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuName=" + stuName + ", subject=" + subject + ", mobileNo=" + mobileNo
				+ "]";
	}
}
