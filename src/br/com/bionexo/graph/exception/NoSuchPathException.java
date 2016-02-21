package br.com.bionexo.graph.exception;

/**
 * @author Gabriel Nobrega de Lima
 */

public class NoSuchPathException extends RuntimeException {

	private static final long serialVersionUID = 8122471940888216757L;

	public NoSuchPathException(String message) {
		super(message);
	}

	public NoSuchPathException(String message, Exception e) {
		super(message, e);
	}

}
