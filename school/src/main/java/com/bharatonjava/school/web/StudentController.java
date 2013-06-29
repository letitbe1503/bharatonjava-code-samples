package com.bharatonjava.school.web;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bharatonjava.school.domain.Student;
import com.bharatonjava.school.service.StudentService;
import com.bharatonjava.school.utils.Constants;
import com.bharatonjava.school.utils.ViewConstants;
import com.bharatonjava.school.web.formbean.StudentRegFormBean;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView prepareStudentRegistrationForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(ViewConstants.REGISTER_NEW_STUDENT_PAGE);
		mav.addObject("frmBean", new StudentRegFormBean());
		return mav;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView processStudentRegistrationForm(
			StudentRegFormBean formBean, BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView();

		if (bindingResult.hasErrors()) {
			mav.setViewName(ViewConstants.REGISTER_NEW_STUDENT_PAGE);
		}

		Student s = new Student();
		s.setStudentId(1001L);
		s.setFirstName(formBean.getFirstName());
		s.setMiddleName(formBean.getMiddleName());
		s.setLastName(formBean.getLastName());

		DateFormat df = new SimpleDateFormat(Constants.DATE_FORMAT);

		try {
			s.setDob(df.parse(formBean.getDob()));
		} catch (ParseException pe) {
			pe.printStackTrace();
		}

		studentService.saveStudent(s);

		mav.setViewName(ViewConstants.REGISTER_STUDENT_SUCCESS);
		return mav;
	}

}
