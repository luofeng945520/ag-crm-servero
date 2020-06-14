package com.cn.ag.services.order.impl;

import com.cn.ag.data.domain.sd.UserRole;
import com.cn.ag.data.dao.interf.UserRoleMapper;
import com.cn.ag.services.order.UserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.cn.ff.utils.comm.support.FrontRequestParam;
import com.cn.ff.utils.comm.support.ResultData;

import java.util.List;
import java.util.Map;

/**
 * @author milk
 * @Date 2020-06-14 16:52:26
 */
@Service("userRoleServiceImpl")
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    @Qualifier("userRoleMapperImpl")
    private UserRoleMapper userRoleMapper;


    /**
     * 获取多个对象
     */
    public List<UserRole> list(Map<String, Object> map) {
        return userRoleMapper.selectByPaging(map);
    }

    /**
     * 添加单个
     */
    public boolean add(UserRole userRole) {
        return userRoleMapper.insertSelective(userRole) > 0;
    }

    /**
     * 批量添加
     */
    public boolean addBatch(List<UserRole> userRoleList) {
        //一次全部插入 若是数据过多 需要重写
        return userRoleMapper.insertBatch(userRoleList) > 0;
    }

    /**
     * 获取结果
     */
    public ResultData lists(FrontRequestParam frontRequestParam) {
        return null;
    }

}
