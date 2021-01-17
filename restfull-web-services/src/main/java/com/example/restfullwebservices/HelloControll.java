package com.example.restfullwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins="http://localhost:4200")

@Controller
public class HelloControll {
	//@RequestMapping(method =RequestMethod.GET ,path="/hello-world")
//	@GetMapping(path="/hello-world")
//	public String data()
//	{
//		return "hello";
	//}
	
	@GetMapping(path="/hello-world-bean")
	public HelloBean dataBean()
	{
		//throw new RuntimeException("some errrr occured");
	  return new HelloBean("hello bean changed");
	}
	
	
}
