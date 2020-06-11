package com.cn.ag.exception;
/**
* @Description: 
* @param 
* @return   
* 2019年7月6日
* @throws
*/
public class QuantityNotEnoughException extends Exception {
	private static final long serialVersionUID = 103L;
	
	public QuantityNotEnoughException() {
		
	}
	
	public QuantityNotEnoughException(String msg) {
		super(msg);	
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
