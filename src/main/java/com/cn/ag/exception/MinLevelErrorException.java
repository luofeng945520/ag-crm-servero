package com.cn.ag.exception;
/**
* @Description: 
* @param 
* @return   
* 2019年7月11日
* @throws
*/
public class MinLevelErrorException extends Exception {
	private static final long serialVersionUID = 105L;
	
	public MinLevelErrorException() {
		
	}
	
	public MinLevelErrorException(String msg) {
		super(msg);
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
