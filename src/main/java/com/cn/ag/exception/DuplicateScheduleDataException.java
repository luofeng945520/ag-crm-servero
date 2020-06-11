package com.cn.ag.exception;

/**
 * @ClassName DuplicateScheduleDataException
 * @Description: TODO
 * @Author Amber
 * @Date 2020/03/25 15:23
 * @Version 1.0
 */
public class DuplicateScheduleDataException extends Exception {

    public DuplicateScheduleDataException() {
    }

    public DuplicateScheduleDataException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
