package com.cn.ag.exception;

/**
 * @ClassName:QueryFailedException
 * @Description: 查询数据失败是抛出异常
 * @Author: milk
 * @Date: 2019/7/10 17:27
 */
public class QueryFailedException extends RuntimeException {
    private static final long serialVersionUID = 104L;

    public QueryFailedException(){

    }

    public QueryFailedException(String message){
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
