package com.springboot.api.exception.handler;

public class EmployeeApplicationException extends RuntimeException{
	
    private static final long serialVersionUID = 10001L;
	private String errorCode;
	public EmployeeApplicationException(String errorMessage,String errorCode){
		super(errorMessage);
		this.errorCode=errorCode;
	}
	public EmployeeApplicationException(String errorMessage,String errorCode,Throwable cause){
		super(errorMessage,cause);
		this.errorCode=errorCode;
	}
	public String getErrorCode() {
		return errorCode;
	}
	
	
}
