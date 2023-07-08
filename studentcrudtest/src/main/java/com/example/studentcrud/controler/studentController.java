package com.example.studentcrud.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.studentcrud.domain.student;
import com.example.studentcrud.service.studentService;
import com.example.studentcrud.domain.course;
import com.example.studentcrud.service.CourseService;


@Controller
public class studentController {
	@Autowired
	private studentService studentService;
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/students")
	public String findAll(Model model)
	{
		List<student> students = studentService.findAll();
		model.addAttribute("students", students);
		return "students";
	}
	
	@GetMapping("/students/add")
	public String add(Model model)
	{
		student theStudent = new student();
		model.addAttribute("theStudent", theStudent);
		return "student-form";
	}
	
	@PostMapping("/students/save")
	public String save(@ModelAttribute("theStudent") student theStudent)
	{
		studentService.save(theStudent);
		return "redirect:/students";
	}
	
	@GetMapping("/students/{id}/courses")
	public String viewCourses(@PathVariable("id") int id, Model model)
	{
		student student = studentService.findById(id);
		List<course> courses = student.getCourses();
		model.addAttribute("courses", courses);
		return "course-list";
	}
	
	@GetMapping("/students/{id}/addCourses")
	public String addCourses(@PathVariable("id") int id, Model model)
	{
		List<course> studentCourses = studentService.findById(id).getCourses();
		List<course> courses = courseService.findAll();
		List<course> remainingCourses = new ArrayList<course>();
		List<String> courseNames = new ArrayList<>();
		for (course p : studentCourses) {
			courseNames.add(p.getName());
		}
		for(course c: courses) {
			if(!courseNames.contains(c.getName())) {
				remainingCourses.add(c);
			}
		}
		model.addAttribute("courses", remainingCourses);
		model.addAttribute("add_id", id);
		return "course-list";
	}
	
	@GetMapping("/students/{sid}/addCourse")
	public String addCourse(@PathVariable("sid") int sid, @RequestParam("cid") int cid)
	{
		student student = studentService.findById(sid);
		course course = courseService.findById(cid);
		System.out.print("addCourse" + sid + cid);
		student.addCourse(course);
		studentService.save(student);
		course.addStudent(student);
		courseService.save(course);
		return "redirect:/students/"+sid+"/courses";
	}
}
