package org.binggo.mockapp.common;

public class MockAppException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @param message the exception message
	 */
	public MockAppException(String message) {
		super(message);
	}
	
	/**
	 * @param ex the causal exception
	 */
	public MockAppException(Throwable ex) {
		super(ex);
	}
	
	/**
	 * @param message exception message
	 * @param ex the causal exception
	 */
	public MockAppException(String message, Throwable ex) {
		super(message, ex);
	}

}
