package com.com.BikkadIT.StudentRestServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.com.BikkadIT.StudentRestServices.model.Student;
import com.com.BikkadIT.StudentRestServices.service.StudentServiceI;

import jakarta.websocket.server.PathParam;

@RestController
public class StudentController {
	@Autowired
	private StudentServiceI studentServiceI;
	
	
	@PostMapping("/students")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
		Student saveStudent = studentServiceI.saveStudent(student);
		
		return new ResponseEntity<Student>(saveStudent,HttpStatus.CREATED);
		
	}
	
	@PostMapping("/saveAll")
public ResponseEntity<List<Student>> saveAllStudent(@RequestBody List<Student> list){
	
	List<Student> saveStudent = studentServiceI.saveAllStudent(list);
	return new ResponseEntity<List<Student>>(saveStudent,HttpStatus.CREATED);
	
}
	@GetMapping("/getAllStudent")
	public ResponseEntity<List<Student>> getAllRecords(){
		List<Student> allRecords = studentServiceI.getAllRecords();
		
		return new ResponseEntity<List<Student>> (allRecords,HttpStatus.OK);
		
	}
//	@GetMapping("/getstudent/{id}")
//	public ResponseEntity<Student> getStudentById(@PathVariable int id){
//		Student studenyById = studentServiceI.getStudentById(id);
//		
//		return new ResponseEntity<Student> (studenyById ,HttpStatus.OK);
//		
//	}
	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable int id){
		 Student updateStudent = studentServiceI.updateStudent(student,id);
		
		return new ResponseEntity<Student> (updateStudent,HttpStatus.OK);
		
	}
	 
	 @PutMapping("/updateAllStudent/{id}")
	public ResponseEntity<List<Student> >updateAllStudent(@RequestBody List< Student> student,@PathVariable List<Integer> id){
		List<Student> updateAllstudent = studentServiceI.updateAllstudent(student, id);
		return new ResponseEntity<List<Student>> (  updateAllstudent,  HttpStatus.ACCEPTED);
		
	}

	/*
	 * @GetMapping("/getstudent") public ResponseEntity<Student>
	 * getStudentById(@RequestParam("sid")int id){ Student student =
	 * studentServiceI.getStudentById(id); return new
	 * ResponseEntity<Student>(student, HttpStatus.OK);
	 * 
	 * }
	 */
	 @GetMapping("/getstudent")
	public ResponseEntity<Student> getStudentById(@PathParam("id") int id){
			Student studenyById = studentServiceI.getStudentById(id);
			
			return new ResponseEntity<Student> (studenyById ,HttpStatus.OK);
	 }	
	 @DeleteMapping("/deleteById")
	 public ResponseEntity<Void> deleteById(@PathParam("sid") int sid){
		 studentServiceI.deleteById(sid);
		return new ResponseEntity<Void>(HttpStatus.OK);
		 
	 }
	 
	 @DeleteMapping("/deleteAll")
	 public ResponseEntity<?> deleteAll(){
		 studentServiceI.deleteAll();
		return new ResponseEntity<>(HttpStatus.OK);
		 
	 }

}
