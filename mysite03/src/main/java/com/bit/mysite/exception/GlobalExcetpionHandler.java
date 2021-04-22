package com.bit.mysite.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExcetpionHandler {

	
	@ExceptionHandler(Exception.class)
	public void handleException(
			HttpServletRequest request,
			HttpServletResponse repsonse,
			Exception e) throws Exception {
		
		// 1. 로깅
		System.out.println(e);
		
		// 2. 사과
		request.setAttribute("error", e.toString());
		request.getRequestDispatcher("/WEB-INF/views/error/exception.jsp").forward(request, repsonse);
		
	}
	
}
