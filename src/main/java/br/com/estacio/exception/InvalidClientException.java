package br.com.estacio.exception;

public class InvalidClientException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public InvalidClientException(String message) {
		super(message);
	}
	
}
