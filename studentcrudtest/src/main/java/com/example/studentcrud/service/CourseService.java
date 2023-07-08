package com.example.studentcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentcrud.domain.course;
import com.example.studentcrud.repositary.CourseRepository;

@Service
public class CourseService 
{
	@Autowired
	private CourseRepository courseRepository;
	
	public List<course> findAll() {
		return courseRepository.findAll();
	}
	
	public course findById(int id) {
		return courseRepository.findById(id).get();
	}
	
	public course save(course course) {
		return courseRepository.save(course);
	}
}
