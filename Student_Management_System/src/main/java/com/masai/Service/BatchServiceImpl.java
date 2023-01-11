package com.masai.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.BatchException;
import com.masai.Exception.CourseException;
import com.masai.Exception.StudentException;
import com.masai.Exception.TeacherException;
import com.masai.Model.Batch;
import com.masai.Model.Course;
import com.masai.Model.Student;
import com.masai.Model.Teacher;
import com.masai.Repository.BatchRepository;
import com.masai.Repository.CourseRepository;
import com.masai.Repository.StudentRepository;
import com.masai.Repository.TeacherRepository;

@Service
public class BatchServiceImpl implements BatchService{

	@Autowired
	public BatchRepository batchRepository;
	
	@Autowired
	public StudentRepository studentrepository;
	
	@Autowired
	public TeacherRepository teacherrepository;
	
//	@Override
//	public Batch AddBatch(Batch batch) throws BatchException {
//		
//		if(batchRepository.existsById(batch.getBatchid())){
//			throw new BatchException("Batch with this name already exists in database");
//		}else {
//			return batchRepository.save(batch);
//		}
//		
////		return null;
//	}

//	@Override
//	public Batch getBatchById(int id) throws BatchException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<Batch> getAllBatchs() throws BatchException {
		
		List<Batch> batches = new ArrayList<>();
		batches = batchRepository.findAll();
		
		return batches;
	}

	@Override
	public Batch getBatchByStudentid(int id) throws StudentException {
		
//        Batch batch = batchRepository.findByStudentId(id);
//		
//		if(batch == null) {
//			throw new StudentException("No batch for the student with id : "+id);
//		}
//		
		return null;

	}

	@Override
	public Batch getBatchById(int id) throws BatchException {
		// TODO Auto-generated method stub
		return null;
	}


//	@Override
//	public Batch UpdateBatch(Batch batch, int id) throws BatchException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Batch DeleteBatch(Batch batch, int id) throws BatchException {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public void assignStudentToBatch(int sid, int bid) throws StudentException, BatchException {
//		// TODO Auto-generated method stub
//		
//	}
//	
//	@Override
//	public void assignTeacherToBatch(int tid, int bid) throws TeacherException, BatchException {
//		// TODO Auto-generated method stub
//		
//	}
	
//	@Override
//    public void assignStudentToBatch(int studentId, int batchId) throws StudentException, BatchException  {
//        Student student = studentrepository.findById(studentId)
//                .orElseThrow(() -> new StudentException("Student not found with ID: " + studentId));
//        Batch batch = batchRepository.findById(batchId)
//                .orElseThrow(() -> new BatchException("Batch not found with ID: " + batchId));
//
//        batch.getStudents().add(student);
//        student.getBatches().add(batch);
//
//        batchRepository.save(batch);
//        studentrepository.save(student);
//    }

	
	@Override
	public void assignStudentToBatch(int studentId, int batchId) throws StudentException, BatchException {
	    Student student = studentrepository.findById(studentId)
	            .orElseThrow(() -> new StudentException("Student not found with ID: " + studentId));
	    Batch batch = batchRepository.findById(batchId)
	            .orElseThrow(() -> new BatchException("Batch not found with ID: " + batchId));

	    batch.getStudents().add(student);
	    student.setBatch(batch);

	    batchRepository.save(batch);
	    studentrepository.save(student);
	}
	
	
    @Override
    public void assignTeacherToBatch(int teacherId, int batchId) throws TeacherException, BatchException {
        Teacher teacher = teacherrepository.findById(teacherId)
                .orElseThrow(() -> new TeacherException("Teacher not found with ID: " + teacherId));
        Batch batch = batchRepository.findById(batchId)
                .orElseThrow(() -> new BatchException("Batch not found with ID: " + batchId));

        batch.getTeachers().add(teacher);
        teacher.getBatches().add(batch);

        batchRepository.save(batch);
        teacherrepository.save(teacher);
    }
	
}
