package com.com.BikkadIT.StudentRestServices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.com.BikkadIT.StudentRestServices.model.Student;
import com.com.BikkadIT.StudentRestServices.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentServiceI{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {
		Student save = studentRepository.save(student);
		return save;
	}

	@Override
	public List<Student> saveAllStudent(List<Student> list) {
		List<Student> saveAll = (List<Student>) studentRepository.saveAll(list);
		return saveAll;
	}

	@Override
	public List<Student> getAllRecords() {
		List<Student> findAll = (List<Student>) studentRepository.findAll();
		return findAll;
	}

	@Override
	public Student getStudentById(int id) {
		 Optional<Student> optional = studentRepository.findById( id);
		 Student student = optional.get();
		 return student ;
	}

	@Override
	public Student updateStudent(Student student, int id) {
		Student save = studentRepository.save(student);
		return save;
	}

	@Override
	public List<Student> updateAllstudent(List<Student> student, List<Integer> id) {
		List<Student> saveAll = (List<Student>) studentRepository.saveAll(student);
		return saveAll;
	}

	@Override
	public void deleteById(int sid) {
		studentRepository.deleteById(sid);
				
	}

	@Override
	public void deleteAll() {
		studentRepository.deleteAll();
		
	}

	
}
