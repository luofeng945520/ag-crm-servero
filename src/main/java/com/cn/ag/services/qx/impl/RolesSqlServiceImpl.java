package com.cn.ag.services.qx.impl;

import com.cn.ag.data.domain.sd.qx.RolesSql;
import com.cn.ag.data.dao.interf.qx.RolesSqlMapper;
import com.cn.ag.services.qx.RolesSqlService;
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
@Service("rolesSqlServiceImpl")
public class RolesSqlServiceImpl implements RolesSqlService {

    @Autowired
    @Qualifier("rolesSqlMapperImpl")
    private RolesSqlMapper rolesSqlMapper;


    /**
     * 获取单个对象
     */
    public RolesSql get(String id) {
        return rolesSqlMapper.selectByPrimaryKey(id);
    }

    /**
     * 通过主键选择性修改
     */
    public boolean modifyByPrimaryKeySelective(RolesSql rolesSql) {
        return rolesSqlMapper.updateByPrimaryKeySelective(rolesSql) > 0;
    }

    /**
     * 通过主键删除
     */
    public boolean removeByPrimaryKey(String id) {
        return rolesSqlMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * 获取多个对象
     */
    public List<RolesSql> list(Map<String, Object> map) {
        return rolesSqlMapper.selectByPaging(map);
    }

    /**
     * 添加单个
     */
    public boolean add(RolesSql rolesSql) {
        return rolesSqlMapper.insertSelective(rolesSql) > 0;
    }

    /**
     * 批量添加
     */
    public boolean addBatch(List<RolesSql> rolesSqlList) {
        //一次全部插入 若是数据过多 需要重写
        return rolesSqlMapper.insertBatch(rolesSqlList) > 0;
    }

    /**
     * 获取结果
     */
    public ResultData lists(FrontRequestParam frontRequestParam) {
        return null;
    }

}
