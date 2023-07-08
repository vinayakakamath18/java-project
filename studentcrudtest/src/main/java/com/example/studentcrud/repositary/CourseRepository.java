package com.example.studentcrud.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import  com.example.studentcrud.domain.course;

@Repository
public interface CourseRepository extends JpaRepository<course, Integer>
{
	
}
