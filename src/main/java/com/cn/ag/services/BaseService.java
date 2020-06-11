package com.cn.ag.services;

import com.cn.ag.exception.DeleteFailedException;
import com.cn.ag.exception.UpdateFailedException;

import java.util.List;
import java.util.Map;

public interface BaseService<T> {

    /**
     * 获取单个对象
     */
    T get(String id);
    T get(Long id);

    /**
     * 获取多个对象
     */
    List<T> list(Map<String, Object> map);

    /**
     * 统计条数
     */
    int statisticalNumber(Map<String, Object> map);

    /**
     * 添加单个
     */
    boolean add(T t) throws Exception;

    /**
     * 批量添加
     */
    boolean batchAdd(List<T> list) throws Exception;

    /**
     * 通过主键选择性修改
     */
    boolean modifyByPrimaryKeySelective(T t) throws UpdateFailedException;

    /**
     * 通过主键删除
     */
    boolean removeByPrimaryKey(T t) throws DeleteFailedException;




}
