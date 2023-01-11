package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{

//	boolean existsById(String name);

}
