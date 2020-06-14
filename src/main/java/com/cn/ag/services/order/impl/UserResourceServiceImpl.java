package com.cn.ag.services.order.impl;

import com.cn.ag.data.domain.sd.UserResource;
import com.cn.ag.data.dao.interf.UserResourceMapper;
import com.cn.ag.services.order.UserResourceService;
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
@Service("userResourceServiceImpl")
public class UserResourceServiceImpl implements UserResourceService {

    @Autowired
    @Qualifier("userResourceMapperImpl")
    private UserResourceMapper userResourceMapper;


    /**
     * 获取多个对象
     */
    public List<UserResource> list(Map<String, Object> map) {
        return userResourceMapper.selectByPaging(map);
    }

    /**
     * 添加单个
     */
    public boolean add(UserResource userResource) {
        return userResourceMapper.insertSelective(userResource) > 0;
    }

    /**
     * 批量添加
     */
    public boolean addBatch(List<UserResource> userResourceList) {
        //一次全部插入 若是数据过多 需要重写
        return userResourceMapper.insertBatch(userResourceList) > 0;
    }

    /**
     * 获取结果
     */
    public ResultData lists(FrontRequestParam frontRequestParam) {
        return null;
    }

}
