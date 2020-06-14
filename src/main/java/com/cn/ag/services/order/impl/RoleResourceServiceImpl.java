package com.cn.ag.services.order.impl;

import com.cn.ag.data.domain.sd.RoleResource;
import com.cn.ag.data.dao.interf.RoleResourceMapper;
import com.cn.ag.services.order.RoleResourceService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.cn.ff.utils.comm.support.FrontRequestParam;
import com.cn.ff.utils.comm.support.ResultData;

import java.util.List;
import java.util.Map;

/**
 * @author milk
 * @Date 2020-06-14 16:52:25
 */
@Service("roleResourceServiceImpl")
public class RoleResourceServiceImpl implements RoleResourceService {

    @Autowired
    @Qualifier("roleResourceMapperImpl")
    private RoleResourceMapper roleResourceMapper;


    /**
     * 获取多个对象
     */
    public List<RoleResource> list(Map<String, Object> map) {
        return roleResourceMapper.selectByPaging(map);
    }

    /**
     * 添加单个
     */
    public boolean add(RoleResource roleResource) {
        return roleResourceMapper.insertSelective(roleResource) > 0;
    }

    /**
     * 批量添加
     */
    public boolean addBatch(List<RoleResource> roleResourceList) {
        //一次全部插入 若是数据过多 需要重写
        return roleResourceMapper.insertBatch(roleResourceList) > 0;
    }

    /**
     * 获取结果
     */
    public ResultData lists(FrontRequestParam frontRequestParam) {
        return null;
    }

}
