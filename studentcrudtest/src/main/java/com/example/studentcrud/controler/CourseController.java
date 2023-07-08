package com.example.studentcrud.controler;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.studentcrud.domain.course;
import com.example.studentcrud.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController 
{
	@Autowired
	private CourseService courseService;
	
	@GetMapping("")
	public String findAll(Model model)
	{
		List<course> courses = courseService.findAll();
		model.addAttribute("courses", courses);
		return "course-list";
	}
	
	@GetMapping("/{id}")
	public String findById(@PathVariable("id") int id, Model model) 
	{
		course course = courseService.findById(id);
		model.addAttribute("course", course);
		return "course-detail";
	}
	
	@GetMapping("/add")
	public String add(Model model)
	{
		course thecourse = new course();
		model.addAttribute("thecourse", thecourse);
		return "course-form";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("thecourse") course thecourse)
	{
		courseService.save(thecourse);
		return "redirect:/courses";
	}
	
}
