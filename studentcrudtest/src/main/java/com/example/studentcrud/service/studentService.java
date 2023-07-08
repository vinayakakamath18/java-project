package com.example.studentcrud.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.studentcrud.domain.student;
import com.example.studentcrud.repositary.studentRepository;

@Service
public class studentService
{
	@Autowired
	private studentRepository studentRepository;
	
	public List<student> findAll() {
		return studentRepository.findAll();
	}
	
	public student findById(int id) {
		return studentRepository.findById(id).get();
	}
	
	public student save(student student) {
		return studentRepository.save(student);
	}
}
