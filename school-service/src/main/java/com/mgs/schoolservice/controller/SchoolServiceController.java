package com.mgs.schoolservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.mgs.schoolservice.models.School;
import com.mgs.schoolservice.services.SchoolServiceHystrix;

@RestController
public class SchoolServiceController {
	@Autowired
	SchoolServiceHystrix schoolservicehystrix;

	@GetMapping(value="/SchoolDetails/{name}")
	public String getStudents(@PathVariable("name") String name) throws InterruptedException {
		
		//return new ResponseEntity<>(schoolservicehystrix.callStudentServiceAndGetData(name),HttpStatus.OK);
		return  schoolservicehystrix.callStudentServiceAndGetData(name);
	}
}
