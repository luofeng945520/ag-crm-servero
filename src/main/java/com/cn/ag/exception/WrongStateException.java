package com.cn.ag.exception;

/**
 * @author amber
 * @version V 1.0
 * @Title:
 * @Package
 * @Description: (用一句话描述该文件做什么)
 * @date 2019/8/1 17:04
 */
public class WrongStateException extends Exception {

    public WrongStateException(){

    }
    public WrongStateException(String msg){
        super(msg);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
