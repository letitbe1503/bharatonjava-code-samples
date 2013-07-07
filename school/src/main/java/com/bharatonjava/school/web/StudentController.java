package com.bharatonjava.school.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bharatonjava.school.domain.Contact;
import com.bharatonjava.school.domain.Student;
import com.bharatonjava.school.service.StudentService;
import com.bharatonjava.school.utils.Utils;
import com.bharatonjava.school.utils.ViewConstants;
import com.bharatonjava.school.web.formbean.GradesFormBean;
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
		GradesFormBean fb = new GradesFormBean();
		fb.setGrades(studentService.getAllGrades());
		mav.addObject("fb", fb);
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
		s.setDob(Utils.convertStringToDate(formBean.getDob()));
		s.setGradeId(formBean.getGradeId());

		Contact c = new Contact();
		c.setBuilding(formBean.getBuilding());
		c.setStreet(formBean.getStreet());
		c.setArea(formBean.getArea());
		c.setCity(formBean.getCity());
		c.setState(formBean.getState());
		c.setPhoneNumber(formBean.getPhoneNumber());
		c.setAlternatePhoneNumber(formBean.getAlternatePhoneNumber());
		c.setEmail(formBean.getEmail());
		
		studentService.registerStudent(s,c);
		
		mav.setViewName(ViewConstants.REGISTER_STUDENT_SUCCESS);
		return mav;
	}
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView showListStudentsPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(ViewConstants.LIST_STUDENTS);
		GradesFormBean fb = new GradesFormBean();
		fb.setGrades(studentService.getAllGrades());
		mav.addObject("fb", fb);
		//mav.addObject("students", students);
		return mav;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public ModelAndView listStudents() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName(ViewConstants.LIST_STUDENTS);
		List<Student> students = studentService.getAllStudents();
		GradesFormBean fb = new GradesFormBean();
		fb.setGrades(studentService.getAllGrades());
		mav.addObject("fb", fb);

		mav.addObject("students", students);
		return mav;
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView showStudentProfile(@RequestParam Long id){
		ModelAndView mav = new ModelAndView();
		System.out.println("------> "+ id);
		mav.setViewName(ViewConstants.STUDENT_PROFILE);
		return mav;
	}
}
