package com.cn.ag.exception;
/**
* @Description: 
* @param 
* @return   
* 2019年7月11日
* @throws
*/
public class DuplicateNonBasicUnitException extends Exception {
	private static final long serialVersionUID = 108L;
	
	public DuplicateNonBasicUnitException() {
		
	}
	
	public DuplicateNonBasicUnitException(String msg) {
		super(msg);
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
