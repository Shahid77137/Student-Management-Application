package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.StudentException;
import com.masai.Exception.TeacherException;
import com.masai.Model.Batch;
import com.masai.Model.Student;
//import com.masai.Model.Employee;
import com.masai.Model.Teacher;
import com.masai.Repository.BatchRepository;
import com.masai.Repository.StudentRepository;
import com.masai.Repository.TeacherRepository;
@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	public TeacherRepository teacherrepository;
	
	@Autowired
	public StudentRepository studentrepository;
	
	@Autowired
	public BatchRepository batchrepository;
	
	@Override
	public Teacher registerTeacher(Teacher teacher) throws TeacherException {
		return teacherrepository.save(teacher);
	}

	@Override
	public Teacher getTeacherById(int id) throws TeacherException {
    Optional<Teacher> employee = teacherrepository.findById(id);
		
		if(employee.isEmpty()) {
			throw new TeacherException("No teacher exists with id : "+id);
		}
		
		return employee.get();
	}

	@Override
	public List<Teacher> getAllTeachers() throws TeacherException {
		
        List<Teacher> list = teacherrepository.findAll();
		
		return list;
	}

	@Override
	public Teacher UpdateTeacher(Teacher teacher, int id) throws TeacherException {
		
        Optional<Teacher> teach = teacherrepository.findById(id);
		
		if(teach.isEmpty()) {
			throw new TeacherException("No teacher exists with id : "+id);
		}
		
		Teacher teaches = teach.get();
		teaches.setName(teacher.getName());
		teaches.setAge(teacher.getAge());
		teaches.setGender(teacher.getGender());
		teaches.setPhone(teacher.getPhone());
		teaches.setEmail(teacher.getEmail());
		teaches.setSubject(teacher.getSubject());
		teaches.setSalary(teacher.getSalary());
		teaches.setAddress(teacher.getAddress());
		teaches.setPin(teacher.getPin());
//		teaches.setBatches(null);
//		teaches.setStudents(null);
		

		return teacherrepository.save(teaches);
	}

	@Override
	public Teacher DeleteTeacher(Teacher teacher, int id) throws TeacherException {
Optional<Teacher> stu = teacherrepository.findById(id);
		
		if(stu.isEmpty()) {
			throw new TeacherException("No teacher exists with id : "+id);
		}
		Teacher stud = stu.get();
		teacherrepository.delete(stud);
		 return stud;
	}

	@Override
    public List<Student> getstudentofTeacher(int teacherId)throws TeacherException {
        Teacher teacher = teacherrepository.findById(teacherId)
                .orElseThrow(() -> new TeacherException("Teacher not found with ID: " + teacherId));
        return teacher.getStudents();
    }

	
    @Override
    public void assignStudentToTeacher(int studentId, int teacherId)throws StudentException,TeacherException {
        Student student = studentrepository.findById(studentId)
                .orElseThrow(() -> new StudentException("Student not found with ID: " + studentId));
        Teacher teacher = teacherrepository.findById(teacherId)
                .orElseThrow(() -> new TeacherException("Teacher not found with ID: " + teacherId));

        teacher.getStudents().add(student);
        student.getTeachers().add(teacher);

        teacherrepository.save(teacher);
        studentrepository.save(student);
    }
	

}
