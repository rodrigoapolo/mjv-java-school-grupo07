package com.mjv.digytal.peoplejob.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequiredObjectIsNullException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RequiredObjectIsNullException() {
		super("Não é permitido persistir um objeto nulo!");
	}
	
	public RequiredObjectIsNullException(String ex) {
		super(ex);
	}
	
}
