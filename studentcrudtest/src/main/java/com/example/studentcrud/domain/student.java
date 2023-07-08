package com.example.studentcrud.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class student {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinTable(name = "student_course", 
		joinColumns = @JoinColumn(name="student_id"), 
		inverseJoinColumns = @JoinColumn(name = "course_id"))
	private List<course> courses = new ArrayList<>();

	public student() {}

	public student(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<course> getCourses() {
		return courses;
	}

	public void addCourse(course course) {
		this.courses.add(course);
	}
	
	public void removeCourse(course course) {
		this.courses.remove(course);
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCourses(List<course> courses) {
		this.courses = courses;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
}
