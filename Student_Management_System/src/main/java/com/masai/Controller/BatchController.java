package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.masai.Exception.BatchException;
import com.masai.Exception.StudentException;
import com.masai.Exception.TeacherException;
import com.masai.Model.Batch;
import com.masai.Service.BatchService;

@RestController
@RequestMapping("/batch")
@CrossOrigin("*")
public class BatchController {

	@Autowired
	public BatchService batchservice;
	
	
	@GetMapping("/getAllBatches")
	public ResponseEntity<List<Batch>>  getAllBatchs()throws BatchException{
		
		List<Batch> batches = batchservice.getAllBatchs();
		
		return new ResponseEntity<>(batches,HttpStatus.OK);
	}
	
	
	@PostMapping("/assignStudentToBatch/{sid}/{bid}")
	public ResponseEntity<String> assignStudentToBatch(@PathVariable int sid,@PathVariable int bid)throws StudentException,BatchException{
		
		batchservice.assignStudentToBatch(sid, bid);
		
		return new ResponseEntity<>("assigned student to batch",HttpStatus.OK);
		
	}
	
	@PostMapping("/assignTeacherToBatch/{tid}/{bid}")
	public ResponseEntity<String> assignTeacherToBatch(@PathVariable int tid,@PathVariable int bid)throws TeacherException,BatchException{
		
		batchservice.assignTeacherToBatch(tid, bid);
		
		return new ResponseEntity<>("assigned teacher to batch",HttpStatus.OK);
	}
	
	
//	public Batch getBatchByStudentid(int id)throws StudentException{
//		
////		to be done after solving error of batchrepository method
//		
//		return null;
//	}
//	
//	
//	public Batch getBatchById(int id)throws BatchException{
//		
//		
//		return null;
//	}
	@GetMapping("/getBatchById/{id}")
    public ResponseEntity<Batch> getBatchById(@PathVariable int id) throws BatchException {
        Batch batch = batchservice.getBatchById(id);
        return ResponseEntity.ok(batch);
    }

    @GetMapping("/getBatchByStudentId/{id}")
    public ResponseEntity<Batch> getBatchByStudentId(@PathVariable int id) throws StudentException, BatchException {
        Batch batch = batchservice.getBatchById(id);
        return ResponseEntity.ok(batch);
    }
	
	
}
