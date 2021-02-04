package com.mgs.schoolservice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

//import com.mgs.schoolservice.models.School;
//import com.mgs.schoolservice.models.Student;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class SchoolServiceHystrix {
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@HystrixCommand(fallbackMethod = "callStudentServiceAndGetData_Fallback",commandKey = "mykey1",threadPoolKey="mykey1")
	public String callStudentServiceAndGetData(String schoolname) throws InterruptedException {
	
		
		/*String response = restTemplate
				.exchange("http://localhost:8182/getstudent/{schoolname}"
				, HttpMethod.GET
				, null
				, new ParameterizedTypeReference<String>() {
			}, schoolname).getBody();
		*/
		
		Thread.sleep(90000);
		
		//String url = "http://student-service/getstudent/{schoolname}";
		
		//ResponseEntity<School> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, School.class, schoolname);
		
		
		// school =   restTemplate.exchange("http://localhost:8182/getstudent/{schoolname}", HttpMethod.GET, null, School.class,schoolname).getBody();
		
		////ResponseEntity<School> response = restTemplate.getForEntity("http://localhost:8182/getstudent/"+schoolname, School.class);
		
		////return response.getBody();
		//return restTemplate.getForObject("http://localhost:8182/getstudent/"+schoolname,School.class);

		return "NORMAL FLOW !!! - School Name -  " + schoolname + " :::  Student Details "  + " -  ";
	/*	WebClient webClient = WebClient.builder()
		        .baseUrl("http://localhost:8182")
		        .defaultHeader(HttpHeaders.CONTENT_TYPE,  MediaType.APPLICATION_JSON_VALUE)
		        .build();*/
		/*School school1 = webClientBuilder.build().get().uri("http://localhost:8182/getstudent/"+schoolname).retrieve().bodyToMono(School.class).block();
		return school1;*/

		
	}
	
	
	private String callStudentServiceAndGetData_Fallback(String schoolname) {
		return "CIRCUIT BREAKER ENABLED!!!No Response From Student Service at this moment. Service will be back shortly - ";
		/*List<Student> lst = new ArrayList<Student>();
		Student std = new Student("Test Student","Test Class");
		lst.add(std);	
		School school = new School();
		school.setSchool(lst);
		return school*/
	}

}
