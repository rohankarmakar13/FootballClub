package com.footballclub.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalException {
	@ExceptionHandler(value = ClubException.class)
	@ResponseStatus
	@ResponseBody
	public ErrorResponse handleUserExistsException(ClubException e) {
		return new ErrorResponse(101,e.getMassage(), e.getDetails());
	}
}
