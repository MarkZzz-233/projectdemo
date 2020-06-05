package com.demo.spbdemo.exception;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value =Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req,Exception e)throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception",e);
		mav.addObject("url",req.getRequestURL());
		//索引到errorPage
		//修改后会出现whitelabel error page
		mav.setViewName("errorPage");
		return mav;
	}
}
