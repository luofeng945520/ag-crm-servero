package com.cn.ag.services.qx.impl;

import com.cn.ag.data.domain.sd.qx.System;
import com.cn.ag.data.dao.interf.qx.SystemMapper;
import com.cn.ag.services.qx.SystemService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.cn.ff.utils.comm.support.FrontRequestParam;
import com.cn.ff.utils.comm.support.ResultData;

import java.util.List;
import java.util.Map;

/**
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
@Service("systemServiceImpl")
public class SystemServiceImpl implements SystemService {

    @Autowired
    @Qualifier("systemMapperImpl")
    private SystemMapper systemMapper;


    /**
     * 获取单个对象
     */
    public System get(String id) {
        return systemMapper.selectByPrimaryKey(id);
    }

    /**
     * 通过主键选择性修改
     */
    public boolean modifyByPrimaryKeySelective(System system) {
        return systemMapper.updateByPrimaryKeySelective(system) > 0;
    }

    /**
     * 通过主键删除
     */
    public boolean removeByPrimaryKey(String id) {
        return systemMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * 获取多个对象
     */
    public List<System> list(Map<String, Object> map) {
        return systemMapper.selectByPaging(map);
    }

    /**
     * 添加单个
     */
    public boolean add(System system) {
        return systemMapper.insertSelective(system) > 0;
    }

    /**
     * 批量添加
     */
    public boolean addBatch(List<System> systemList) {
        //一次全部插入 若是数据过多 需要重写
        return systemMapper.insertBatch(systemList) > 0;
    }

    /**
     * 获取结果
     */
    public ResultData lists(FrontRequestParam frontRequestParam) {
        return null;
    }

}
