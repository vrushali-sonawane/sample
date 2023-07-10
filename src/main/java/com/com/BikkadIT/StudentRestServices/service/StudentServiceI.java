package com.com.BikkadIT.StudentRestServices.service;

import java.util.List;

import com.com.BikkadIT.StudentRestServices.model.Student;

public interface StudentServiceI {
	
	public  Student saveStudent(Student student);
	
	public List<Student> saveAllStudent(List<Student> list);
	
	public List<Student> getAllRecords();
	
	public Student getStudentById(int id);
	
	public Student updateStudent(Student student ,int id);
	
	public List<Student> updateAllstudent(List<Student> student,List<Integer>id);
	
	public void deleteById(int sid); 
	
	public void deleteAll();
	

}
