package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.CourseException;
import com.masai.Model.Course;
import com.masai.Repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	public CourseRepository courseRepository;
	
	@Override
	public Course AddCourse(Course course) throws CourseException {
		
		if(courseRepository.existsById(course.getCourseId())){
			throw new CourseException("Course with this name already exists in database");
		}else {
			return courseRepository.save(course);
		}

//		return courseRepository.save(course);
		
	}

	@Override
	public Course getCourseById(int id) throws CourseException {
Optional<Course> course = courseRepository.findById(id);
		
		if(course.isEmpty()) {
			throw new CourseException("No course exists with id : "+id);
		}
		
		return course.get();
		
	}

	@Override
	public List<Course> getAllCourses() throws CourseException {
List<Course> list = courseRepository.findAll();
		
		return list;
	}

	@Override
	public Course UpdateCourse(Course course, int id) throws CourseException {
    Optional<Course> corse = courseRepository.findById(id);
		
		if(corse.isEmpty()) {
			throw new CourseException("No course exists with id : "+id);
		}
		
		Course cor = corse.get();
		cor.setCourseType(course.getCourseType());
		cor.setImage(course.getImage());
		cor.setDescription(course.getDescription());
		cor.setCourseStatus(course.getCourseStatus());
		cor.setDuration(course.getDuration());
		cor.setFee(course.getFee());
//		cor.setBatches(null);
//		cor.setStudents(null);
		
		return courseRepository.save(cor);
	}

	@Override
	public Course DeleteCourse(Course course, int id) throws CourseException {
Optional<Course> cor = courseRepository.findById(id);
		
		if(cor.isEmpty()) {
			throw new CourseException("No course exists with id : "+id);
		}
		Course co = cor.get();
		courseRepository.delete(co);
		 return co;
	}

}
