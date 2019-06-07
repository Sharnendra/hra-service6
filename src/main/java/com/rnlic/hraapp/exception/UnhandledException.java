package com.rnlic.hraapp.exception;

public class UnhandledException extends HrAppException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UnhandledException() {
		super(ErrorConstants.UNKNOWN_ERROR_CODE,ErrorConstants.UNKNOWN_ERROR__MESSAGE,false);
	}
	public UnhandledException(String message) {
		super(ErrorConstants.UNKNOWN_ERROR_CODE,message,false);
	}

}
