package com.masai.Controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.CourseException;
import com.masai.Model.Course;
import com.masai.Service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	public CourseService courseService;
	
	@PostMapping("/AddCourse")
	public ResponseEntity<Course> AddCourse(@RequestBody Course course)throws CourseException{
		
		Course c = courseService.AddCourse(course);
		
		return new ResponseEntity<>(c,HttpStatus.CREATED);
	}
	
	@GetMapping("/getCourseById/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable int id)throws CourseException{
		
		Course c = courseService.getCourseById(id);
		
		return new ResponseEntity<>(c,HttpStatus.OK);
	}
	
	@GetMapping("/getAllCourses")
	public ResponseEntity<List<Course>> getAllCourses()throws CourseException{
		
		List<Course> c = courseService.getAllCourses();
		
		return new ResponseEntity<>(c,HttpStatus.OK);
	}
	
	@PutMapping("/UpdateCourse/{id}")
	public ResponseEntity<Course> UpdateCourse(@RequestBody Course course,@PathVariable int id)throws CourseException{
		
		Course c = courseService.UpdateCourse(course, id);
		
		return new ResponseEntity<>(c,HttpStatus.OK);
	}
	
	@DeleteMapping("/DeleteCourse/{id}")
	public ResponseEntity<String> DeleteCourse(Course course,@PathVariable int id)throws CourseException{
		
		Course c = courseService.DeleteCourse(course, id);
		
		return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
	}
	
}
