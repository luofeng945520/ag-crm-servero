package com.cn.ag.services.qx;

import com.cn.ag.data.domain.sd.qx.System;

import com.cn.ff.utils.comm.support.FrontRequestParam;
import com.cn.ff.utils.comm.support.ResultData;

import java.util.List;
import java.util.Map;

/**
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
public interface SystemService {

    /**
     * 获取单个对象
     */
    System get(String id);

    /**
     * 通过主键选择性修改
     */
    boolean modifyByPrimaryKeySelective(System system);

    /**
     * 通过主键删除
     */
    boolean removeByPrimaryKey(String id);

    /**
     * 获取多个对象
     */
    List<System> list(Map<String, Object> map);

    /**
     * 添加单个
     */
    boolean add(System system);

    /**
     * 批量添加
     */
    boolean addBatch(List<System> systemList);

    /**
     * 获取结果
     */
    ResultData lists(FrontRequestParam frontRequestParam);
}
