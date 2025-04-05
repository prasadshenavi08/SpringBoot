package com.example.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	@RequestMapping(method=RequestMethod.GET, path="/")  
	public String helloWorld()  
	{  
	return"Hello World";  
	}  
	
	@GetMapping(path="/studentbean")  
	public StudentBean studentBean()  
	{  
	return new StudentBean(1,"Prasad",85); //constructor of StudentBean
	} 

}
