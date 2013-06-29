package com.bharatonjava.school.web;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bharatonjava.school.utils.ViewConstants;
import com.bharatonjava.school.web.formbean.StudentRegFormBean;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView prepareStudentRegistrationForm(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName(ViewConstants.REGISTER_NEW_STUDENT_PAGE);
		mav.addObject("frmBean", new StudentRegFormBean());
		return mav;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView processStudentRegistrationForm(StudentRegFormBean fromBean, BindingResult bindingResult){
		ModelAndView mav = new ModelAndView();
		
		if(bindingResult.hasErrors()){
				mav.setViewName(ViewConstants.REGISTER_NEW_STUDENT_PAGE);
		}
		
		mav.setViewName(ViewConstants.REGISTER_STUDENT_SUCCESS);
		return mav;
	}
	
	
}
