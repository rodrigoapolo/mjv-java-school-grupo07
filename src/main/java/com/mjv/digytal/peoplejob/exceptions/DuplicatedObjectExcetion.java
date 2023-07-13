package com.mjv.digytal.peoplejob.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class DuplicatedObjectExcetion extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DuplicatedObjectExcetion(String ex) {
		super(ex);
	}
}
