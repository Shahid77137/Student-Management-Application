package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.CourseException;
import com.masai.Exception.StudentException;
import com.masai.Exception.TeacherException;
import com.masai.Model.Student;
import com.masai.Model.Teacher;
import com.masai.Repository.BatchRepository;
import com.masai.Repository.StudentRepository;
import com.masai.Repository.TeacherRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	public StudentRepository studentrepository;
	

	@Autowired
	public TeacherRepository teacherrepository;
	
	
	@Autowired
	public BatchRepository batchRepository;
	
	
	@Override
	public Student registerStudent(Student student) throws StudentException {
		
		
		if(studentrepository.existsById(student.getStudentId())){
			throw new StudentException("Student with this name already exists in database");
		}else {
			return studentrepository.save(student);
		}
		
	}

	@Override
	public Student getStudentById(int id) throws StudentException {
		
		Optional<Student> student = studentrepository.findById(id);
		
		if(student.isEmpty()) {
			throw new StudentException("No student exists with id : "+id);
		}
		
		return student.get();
	}

	@Override
	public List<Student> getAllStudents() throws StudentException {
		
		List<Student> list = studentrepository.findAll();
		
		return list;
	}

	@Override
	public Student UpdateStudent(Student student, int id) throws StudentException {
		
		Optional<Student> stu = studentrepository.findById(id);
		
		if(stu.isEmpty()) {
			throw new StudentException("No student exists with id : "+id);
		}
		
		Student stud = stu.get();
		stud.setName(student.getName());
		stud.setEmail(student.getEmail());
		stud.setPhone(student.getPhone());
		stud.setAddress(student.getAddress());
		stud.setAge(student.getAge());
		stud.setGender(student.getGender());
		stud.setPassword(student.getPassword());
		stud.setConfirm_password(student.getConfirm_password());
		stud.setPin(student.getPin());
//		stud.setBatch(null);
//		stud.setCourses(null);
//		stud.setTeachers(null);
		
		return studentrepository.save(stud);
	}

	@Override
	public Student DeleteStudent(Student student, int id) throws StudentException {
		
        Optional<Student> stu = studentrepository.findById(id);
		
		if(stu.isEmpty()) {
			throw new StudentException("No student exists with id : "+id);
		}
		 Student stud = stu.get();
		 studentrepository.delete(stud);
		 return stud;
	}

//	@Override
//	public List<Teacher> getTeacherofstudent(int sid) throws StudentException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	
//
//	@Override
//	public void assignTeacherToStudent(int sid, int tid) throws StudentException, TeacherException {
//		// TODO Auto-generated method stub
//		
//	}
	
	
	@Override
    public List<Teacher> getTeacherofstudent(int studentId) throws StudentException {
        Student student = studentrepository.findById(studentId)
                .orElseThrow(() -> new StudentException("Student not found with ID: " + studentId));

        return student.getTeachers();
    }

    @Override
    public void assignTeacherToStudent(int teacherId, int studentId) throws StudentException, TeacherException {
        Teacher teacher = teacherrepository.findById(teacherId)
                .orElseThrow(() -> new TeacherException("Teacher not found with ID: " + teacherId));
        Student student = studentrepository.findById(studentId)
                .orElseThrow(() -> new StudentException("Student not found with ID: " + studentId));

        student.getTeachers().add(teacher);
        teacher.getStudents().add(student);

        studentrepository.save(student);
        teacherrepository.save(teacher);
    }
	
	

}
