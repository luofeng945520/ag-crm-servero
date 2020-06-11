package com.cn.ag.exception;

import com.cn.ag.utils.UtilParm;
import com.cn.ff.utils.comm.support.ResultData;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName:GlobalExceptionHandler
 * @Description: TODO
 * @Author: milk
 * @Date: 2020/5/19 22:57
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResultData exceptionHandler(Exception e){
        if (e instanceof NullPointerException){
            return UtilParm.resultData(0,"空",e);
        }
        return UtilParm.resultData(0,"fail",e.getMessage());
    }
}
