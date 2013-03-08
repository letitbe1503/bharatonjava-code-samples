package com.bharatonjava.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/greet")
public class HelloWorldController {

	@RequestMapping(method = RequestMethod.GET)
	public String sayHello(ModelMap modelMap) {
		System.out.println("Inside controller");
		modelMap.addAttribute("message","Hello Bharat");
		return "hello";
	}
}
