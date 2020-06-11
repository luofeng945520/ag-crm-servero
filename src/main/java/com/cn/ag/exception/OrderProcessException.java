package com.cn.ag.exception;

/**
 * @ClassName:OrderProcessException
 * @Description: 订单流程异常
 * @Author: milk
 * @Date: 2019/11/11 22:21
 */
public class OrderProcessException extends Exception  {

    public OrderProcessException(){

    }

    public OrderProcessException(String msg){
        super(msg);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

}
