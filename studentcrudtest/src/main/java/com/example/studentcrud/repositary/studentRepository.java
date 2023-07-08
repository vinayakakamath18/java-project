package com.example.studentcrud.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentcrud.domain.student;

@Repository
public interface studentRepository extends JpaRepository<student, Integer> {

}
