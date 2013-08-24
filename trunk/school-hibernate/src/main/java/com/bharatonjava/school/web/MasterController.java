package com.bharatonjava.school.web;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bharatonjava.school.domain.Grade;
import com.bharatonjava.school.service.MasterService;
import com.bharatonjava.school.web.formbean.GradesFormBean;

@Controller
@RequestMapping(value = "/master")
public class MasterController {

	private static final Log log = LogFactory.getLog(MasterController.class);

	@Autowired
	private MasterService masterService;

	public void setMasterService(MasterService masterService) {
		this.masterService = masterService;
	}

	@RequestMapping(value = "/grades", method = RequestMethod.GET)
	public ModelAndView prepareGradeMasterForm(ModelAndView model) {
		log.info("entering prepareGradeMasterForm method");
		model.addObject("frmBean", new Grade());
		model.setViewName("gradeMaster");
		List<Grade> grades = masterService.getAllGrades();
		model.addObject("grades", grades);

		model.addObject("g", new GradesFormBean());
		return model;
	}

	@RequestMapping(value = "/addGrade", method = RequestMethod.POST)
	public ModelAndView processGradeMasterForm(Grade grade,
			BindingResult bindingResult) {
		log.info("entering processGradeMasterForm method");
		log.info(grade);
		masterService.createGrade(grade);
		ModelAndView model = new ModelAndView();
		if (bindingResult.hasErrors()) {
			model.addObject("frmBean", grade);
		} else {
			model.addObject("frmBean", new Grade());
		}
		model.setViewName("gradeMaster");
		List<Grade> grades = masterService.getAllGrades();
		log.info(grades);
		model.addObject("grades", grades);
		model.addObject("g", new GradesFormBean());
		model.setViewName("gradeMaster");
		return model;
	}

	@RequestMapping(value = "/deleteGrade", method = RequestMethod.GET)
	public ModelAndView processDeleteGradeMasterForm(
			@RequestParam("id") Long gradeId) {
		log.info("entering processDeleteGradeMasterForm() method to delete gradeId: "
				+ gradeId);

		ModelAndView model = new ModelAndView();
		masterService.deleteGrade(gradeId);

		List<Grade> grades = masterService.getAllGrades();
		log.info(grades);
		model.addObject("grades", grades);
		model.addObject("frmBean", new Grade());
		model.addObject("g", new GradesFormBean());
		model.setViewName("redirect:grades");
		return model;
	}

}
