package com.tom.tcc.backend.exception;

import org.springframework.http.HttpStatus;

import com.tom.tcc.backend.exception.global.GlobalRuntimeException;

@SuppressWarnings("serial")
public class DataViolationException extends GlobalRuntimeException {

	public DataViolationException(String message) {
		super(message, HttpStatus.CONFLICT);
	}

	public DataViolationException(String message, Throwable cause) {
		super(message, cause, HttpStatus.CONFLICT);
	}
}
