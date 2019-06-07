package com.rnlic.hraapp.exception;

public class RemoteServiceNotAvailable extends HrAppException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RemoteServiceNotAvailable() {
		super(ErrorConstants.REMOTE_SERVICE_NOT_AVAILABLE_CODE,ErrorConstants.REMOTE_SERVICE_NOT_AVAILABLE_MESSAGE,false);
	}
	public RemoteServiceNotAvailable(String message) {
		super(ErrorConstants.REMOTE_SERVICE_NOT_AVAILABLE_CODE,message,false);
	}
}
