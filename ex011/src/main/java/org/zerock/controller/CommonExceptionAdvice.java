package org.zerock.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//ë°”ê¿”ë³´ìž
//ÁÖ¼®¿¬½À
//안댐요
@ControllerAdvice
public class CommonExceptionAdvice {

	@ExceptionHandler
	private ModelAndView errorModelAndView(Exception ex){
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("/error_common");
		modelAndView.addObject("exception",ex);
		
		return modelAndView;
		
	}
	
}
