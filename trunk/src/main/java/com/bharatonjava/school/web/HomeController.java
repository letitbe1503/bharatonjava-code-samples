package com.bharatonjava.school.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bharatonjava.school.utils.ViewConstants;

@Controller
public class HomeController {

	private static final Log log = LogFactory.getLog(HomeController.class);
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView prepareHomePage(){
		log.info("Entering prepareHomePage");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(ViewConstants.HOME_PAGE);
		return  mav;
	}
}
