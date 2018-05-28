package com.springboot.api.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.springboot.api.exception.handler.EmployeeApplicationException;

@ControllerAdvice
public class EmployeeExceptionHandler {
	@ExceptionHandler(EmployeeApplicationException.class)
	public String mapException(Model model, EmployeeApplicationException exception) {
		model.addAttribute("errorMessage", exception.getMessage());
		model.addAttribute("errorCode", exception.getErrorCode());
		return "error";

	}
}
