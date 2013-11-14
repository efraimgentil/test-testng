package br.com.estacio.exception;

public class ClientNotFoundException extends Exception {

	private static final long serialVersionUID = 7585930844268187292L;
	
	public ClientNotFoundException(String message) {
		super(message);
	}
	
}
