package br.com.bionexo.graph.exception;

/**
 * @author Gabriel Nobrega de Lima
 */

public class GraphNexoException extends RuntimeException {

	private static final long serialVersionUID = 8122471940888216757L;

	public GraphNexoException(String message) {
		super(message);
	}

	public GraphNexoException(String message, Exception e) {
		super(message, e);
	}

}
