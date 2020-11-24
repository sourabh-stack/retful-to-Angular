package com.sourabh.rest.webservice.restfulwebservice.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloworldController {
	
	@RequestMapping(method = RequestMethod.GET, path = "/hello123")
	public String helloWorld() {
		
		return"Hello World";
	}

	@GetMapping(path="/helloworldbean")
	public HelloWorldBean helloWorldBean() {
		
		return new HelloWorldBean("Hello world");
	}
	
	@GetMapping(path="/helloworldbean/pathvar/{name}")
	public HelloWorldBean helloWorldPV(@PathVariable String name) {
		
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
}
