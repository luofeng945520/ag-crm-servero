package com.cn.ag.exception;

/**
 * @author amber
 * @version V 1.0
 * @Title:
 * @Package
 * @Description: (用一句话描述该文件做什么)
 * @date 2019/8/1 19:42
 */
public class DeleteFailedException extends Exception{
    public DeleteFailedException(){

    }

    public DeleteFailedException(String msg){
        super(msg);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
