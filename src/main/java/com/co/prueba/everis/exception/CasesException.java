package com.co.prueba.everis.exception;

public class CasesException extends Exception {

	private static final long serialVersionUID = 1L;

	public CasesException() {
	}

	public CasesException(String message) {
		super(message);
	}

	public CasesException(Throwable cause) {
		super(cause);
	}

	public CasesException(String message, Throwable cause) {
		super(message, cause);
	}
}