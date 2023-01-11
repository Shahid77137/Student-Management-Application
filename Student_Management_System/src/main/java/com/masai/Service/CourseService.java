package com.masai.Service;

import java.util.List;

import com.masai.Exception.CourseException;
import com.masai.Model.Course;


public interface CourseService {

	public Course AddCourse(Course course)throws CourseException; 
	public Course getCourseById(int id)throws CourseException;
	public List<Course> getAllCourses()throws CourseException;
	public Course UpdateCourse(Course course,int id)throws CourseException;
	public Course DeleteCourse(Course course,int id)throws CourseException;
	
}
