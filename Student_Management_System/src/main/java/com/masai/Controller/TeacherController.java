package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.StudentException;
import com.masai.Exception.TeacherException;
import com.masai.Model.Student;
//import com.masai.Model.Employee;
import com.masai.Model.Teacher;
import com.masai.Service.TeacherService;

@RestController
@RequestMapping("/teachers")
@CrossOrigin("*")
public class TeacherController {

	@Autowired
	private TeacherService teacherservice;
	
	@PostMapping("/addTeacher")
	public ResponseEntity<Teacher>  addTeacher(@RequestBody Teacher teacher)throws TeacherException{
		Teacher st = teacherservice.registerTeacher(teacher);
		return new ResponseEntity<>(st,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/getTeacherById/{id}")
	public ResponseEntity<Teacher> getTeacherById(@PathVariable int id)throws TeacherException{
		
		Teacher stu = teacherservice.getTeacherById(id);
		return new ResponseEntity<>(stu,HttpStatus.OK);
	}
	
	@GetMapping("/getAllTeachers")
	public ResponseEntity<List<Teacher>> getAllTeachers()throws TeacherException{
		List<Teacher> list = teacherservice.getAllTeachers();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@PutMapping("/updateTeacher/{id}")
	public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher,@PathVariable int id)throws TeacherException{
		Teacher stu = teacherservice.UpdateTeacher(teacher, id);
		return new ResponseEntity<>(stu,HttpStatus.OK);
	}
	
	@DeleteMapping("/DeleteTeacher/{id}")
	public ResponseEntity<Teacher> DeleteTeacher(Teacher teacher,@PathVariable int id)throws TeacherException{
		Teacher stu = teacherservice.DeleteTeacher(teacher, id);
		return new ResponseEntity<>(stu,HttpStatus.OK);
		
	}
	
	@GetMapping("/getstudentofTeacher/{sid}")
	public ResponseEntity<List<Student>> getstudentofTeacher(@PathVariable int sid)throws StudentException, TeacherException{
		
		List<Student> students = teacherservice.getstudentofTeacher(sid);
		
		return new ResponseEntity<>(students,HttpStatus.OK);
		
	}
	
	
	@PostMapping("/assignStudentToTeacher/{sid}/{tid}")
	public ResponseEntity<String> assignStudentToTeacher(@PathVariable int sid,@PathVariable int tid)throws StudentException,TeacherException{
		
		teacherservice.assignStudentToTeacher(sid, tid);
		
		return new ResponseEntity<>("assigned student to teacher",HttpStatus.OK);
	
	}
	
}
