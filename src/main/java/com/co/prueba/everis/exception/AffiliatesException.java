package com.co.prueba.everis.exception;

public class AffiliatesException extends Exception {

	private static final long serialVersionUID = 1L;

	public AffiliatesException() {
	}

	public AffiliatesException(String message) {
		super(message);
	}

	public AffiliatesException(Throwable cause) {
		super(cause);
	}

	public AffiliatesException(String message, Throwable cause) {
		super(message, cause);
	}
}