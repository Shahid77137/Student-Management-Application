package com.masai.Service;

import java.util.List;

import com.masai.Exception.StudentException;
import com.masai.Exception.TeacherException;
import com.masai.Model.Student;
//import com.masai.Model.Employee;
import com.masai.Model.Teacher;


public interface TeacherService {

	public Teacher registerTeacher(Teacher teacher)throws TeacherException;
	public Teacher getTeacherById(int id)throws TeacherException;
	public List<Teacher> getAllTeachers()throws TeacherException;
	public Teacher UpdateTeacher(Teacher teacher,int id)throws TeacherException;
	public Teacher DeleteTeacher(Teacher teacher,int id)throws TeacherException;
	public List<Student> getstudentofTeacher(int sid)throws TeacherException;
	public void assignStudentToTeacher(int sid,int tid)throws StudentException,TeacherException;
}
