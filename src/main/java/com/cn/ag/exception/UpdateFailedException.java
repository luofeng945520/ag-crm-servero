package com.cn.ag.exception;
/**
* @Description: 
* @param 
* @return   
* 2019年7月3日
* @throws
*/
public class UpdateFailedException extends Exception{
	private static final long serialVersionUID = 102L;
	
	public UpdateFailedException() {
		
	}
	
	public UpdateFailedException(String msg) {
		super(msg);
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
