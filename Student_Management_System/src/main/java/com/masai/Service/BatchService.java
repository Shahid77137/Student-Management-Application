package com.masai.Service;

import java.util.List;

import com.masai.Exception.BatchException;
import com.masai.Exception.StudentException;
import com.masai.Exception.TeacherException;
import com.masai.Model.Batch;
//import com.masai.Exception.TeacherException;
//import com.masai.Model.Teacher;

public interface BatchService {

//	public Batch AddBatch(Batch batch)throws BatchException;
	public Batch getBatchById(int id)throws BatchException;
	public List<Batch> getAllBatchs()throws BatchException;
//	public Batch UpdateBatch(Batch batch,int id)throws BatchException;
//	public Batch DeleteBatch(Batch batch,int id)throws BatchException;
	public Batch getBatchByStudentid(int id)throws StudentException; 
	public void assignStudentToBatch(int sid,int bid)throws StudentException,BatchException;
	public void assignTeacherToBatch(int tid,int bid)throws TeacherException,BatchException;
}
