package com.springORM.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.springORM.entity.Student;

public class StudentDAO {

	
	private HibernateTemplate hibernateTemplate;
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}


	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	// CRUD operation
	// Insert student
	
	@Transactional
	public int insertStudent(Student student) {
		Integer i= (Integer) this.hibernateTemplate.save(student);
		return i;
		
	}

	// delete student
	
	@Transactional
	public void deleteStudent(int id)
	{
		Student student=this.hibernateTemplate.get(Student.class, id);
		this.hibernateTemplate.delete(student);
	}
	 
	// update student
	
	@Transactional
	public void updateStudent(Student student)
	{
		 this.hibernateTemplate.update(student);
		
	}
	
	// Read/get student details
	// Single student details
	
	public Student getStudent(int id)
	{
		Student student= this.hibernateTemplate.get(Student.class, id);
		return student;
	}
	
	// get all students record
	public List<Student> getAllStudents()
	{
		List<Student> student= this.hibernateTemplate.loadAll(Student.class);
		return student;
	}
	
	public Student findStudent(int id)
	{
		String query= "Select stuName,subject,mobileNo from Student where stuId=?1";
		
		Student student= (Student) this.hibernateTemplate.find(query,id,Student.class);	
		return student;
	}
}
