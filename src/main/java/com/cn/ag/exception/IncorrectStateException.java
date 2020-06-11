package com.cn.ag.exception;

/**
 * @author amber
 * @version V 1.0
 * @Title:
 * @Package
 * @Description: (用一句话描述该文件做什么)
 * @date 2019/7/24 9:47
 */
public class IncorrectStateException extends Exception{
    private static final long serialVersionUID = 109L;

    public IncorrectStateException(){

    }

    public IncorrectStateException(String msg){
        super(msg);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
