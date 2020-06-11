package com.cn.ag.exception;
/**
* @Description: 
* @param 
* @return   
* 2019年7月11日
* @throws
*/
public class ErrorCodeException extends Exception {
	private static final long serialVersionUID = 106L;
	
	public ErrorCodeException() {
		
	}
	
	public ErrorCodeException(String msg) {
		super(msg);
	}
	
	@Override
		public String getMessage() {
			return super.getMessage();
	
	
}
}
