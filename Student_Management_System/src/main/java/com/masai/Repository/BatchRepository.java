package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.Model.Batch;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Integer>{

//	@Query("SELECT B FROM Batch B JOIN B.student S ON B.batchid = S.studentId WHERE S.studentId = ?1")
//	public Batch findByStudentId(int id);
	
}
