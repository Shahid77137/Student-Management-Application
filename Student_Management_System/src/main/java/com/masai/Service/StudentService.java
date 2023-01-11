package com.masai.Service;

import com.masai.Exception.StudentException;
import com.masai.Exception.TeacherException;
import com.masai.Model.Student;
import com.masai.Model.Teacher;

import java.util.List;

public interface StudentService {

	/**
	* Creates a new student and adds it to the database.
	*
	* @param student The student object containing the details of the student to be created.
	* @param studentId The ID of the user creating the recipe.
	* @return The created student object.
	* @throws StudentException      If an error occurs while creating the recipe.
	* 
	* @author SoumitDas
	*/	
	public Student registerStudent(Student student)throws StudentException;
	
	
	 /**
     * Retrieves a Student by its id
     *
     * @return The list of all student objects.
     * @throws StudentException If an error occurs while retrieving the student.
     * 
     * @author SoumitDas
     */ 
	
	public Student getStudentById(int id)throws StudentException;
	public List<Student> getAllStudents()throws StudentException;
	public Student UpdateStudent(Student student,int id)throws StudentException;
	public Student DeleteStudent(Student student,int id)throws StudentException;
	public List<Teacher> getTeacherofstudent(int sid)throws StudentException;
	public void assignTeacherToStudent(int sid,int tid)throws StudentException,TeacherException;
	
	
}
