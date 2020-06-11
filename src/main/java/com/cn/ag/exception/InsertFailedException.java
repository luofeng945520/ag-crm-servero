package com.cn.ag.exception;

/**
 * @ClassName: insertFailedException
 * @Description: TODO(插入数据库失败异常)
 * @author amber
 * @date 2019年7月3日 下午4:34:52
 */
public class InsertFailedException extends Exception{
	 private static final long serialVersionUID = 101L;
	 
	 public InsertFailedException() {
		 
	 }
	 
	 public InsertFailedException(String msg) {
		 super(msg);
	 }
	 
	 @Override
	public String getMessage() {
		return super.getMessage();
	}
}
