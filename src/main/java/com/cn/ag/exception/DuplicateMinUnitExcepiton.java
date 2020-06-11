package com.cn.ag.exception;
/**
* @Description: 
* @param 
* @return   
* 2019年7月11日
* @throws
*/
public class DuplicateMinUnitExcepiton extends Exception{
	
	private static final long serialVersionUID = 107L;
	
	
	public DuplicateMinUnitExcepiton() {
		
	}
	
	public DuplicateMinUnitExcepiton(String msg) {
		super(msg);
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}
	
	
}
