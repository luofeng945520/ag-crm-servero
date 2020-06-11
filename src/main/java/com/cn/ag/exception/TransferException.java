package com.cn.ag.exception;

/**
 * @ClassName:transferException
 * @Description: TODO
 * @Author: milk
 * @Date: 2019/8/5 9:51
 */
public class TransferException extends RuntimeException {

    public TransferException(){
        super();
    }

    public TransferException(String msg){
        super(msg);
    }

    /**
     * Returns the detail message string of this throwable.
     *
     * @return the detail message string of this {@code Throwable} instance
     * (which may be {@code null}).
     */
    @Override
    public String getMessage() {
        return super.getMessage();
    }


}
