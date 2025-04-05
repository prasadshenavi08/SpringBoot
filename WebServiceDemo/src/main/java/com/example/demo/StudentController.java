package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	//@GetMapping(“/getStudent”)
		@RequestMapping(method=RequestMethod.GET, path="/getStudent")  
		public String getStudent()  
		{  
		return"Hello";  
		}  

}
