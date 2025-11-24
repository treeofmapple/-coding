package com.tom.tcc.backend.exception;

import org.springframework.http.HttpStatus;

import com.tom.tcc.backend.exception.global.GlobalRuntimeException;

import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper = true)
public class DuplicateException extends GlobalRuntimeException {
	public DuplicateException(String message) {
		super(message, HttpStatus.CONFLICT);
	}

	public DuplicateException(String message, Throwable cause) {
		super(message, cause, HttpStatus.CONFLICT);
	}
}
