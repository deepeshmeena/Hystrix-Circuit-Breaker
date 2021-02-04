package com.mgs.studentservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentServiceController {

	@GetMapping("/getstudent/{schoolname}")
	public School getStudents(@PathVariable("schoolname") String schoolname) {

		List<Student> lst = new ArrayList<Student>();
		Student std1 = new Student("Sajal", "Class IV");
		Student std2 = new Student("Lokesh", "Class V");
		lst.add(std1);
		lst.add(std2);
	
		
		School school = new School();
		school.setSchool(lst);
		//return new ResponseEntity<>(school,HttpStatus.OK);
		return school;
		
	
	}
}
