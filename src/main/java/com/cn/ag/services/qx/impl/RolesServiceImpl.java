package com.cn.ag.services.qx.impl;

import com.cn.ag.data.domain.sd.qx.Roles;
import com.cn.ag.data.dao.interf.qx.RolesMapper;
import com.cn.ag.data.domain.sd.qx.Users;
import com.cn.ag.services.qx.RolesService;
import com.cn.ag.utils.UtilParm;
import com.cn.ag.utils.UtilTools;
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
@Service("rolesServiceImpl")
public class RolesServiceImpl implements RolesService {

    @Autowired
    @Qualifier("rolesMapperImpl")
    private RolesMapper rolesMapper;


    /**
     * 获取单个对象
     */
    public Roles get(Long id) {
        return rolesMapper.selectByPrimaryKey(id);
    }

    /**
     * 通过主键选择性修改
     */
    public boolean modifyByPrimaryKeySelective(Roles roles) {
        return rolesMapper.updateByPrimaryKeySelective(roles) > 0;
    }

    /**
     * 通过主键删除
     */
    public boolean removeByPrimaryKey(Long id) {
        return rolesMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * 获取多个对象
     */
    public List<Roles> list(Map<String, Object> map) {
        return rolesMapper.selectByPaging(map);
    }

    /**
     * 添加单个
     */
    public boolean add(Roles roles) {
        return rolesMapper.insertSelective(roles) > 0;
    }

    /**
     * 批量添加
     */
    public boolean addBatch(List<Roles> rolesList) {
        //一次全部插入 若是数据过多 需要重写
        return rolesMapper.insertBatch(rolesList) > 0;
    }

    /**
     * 获取结果
     */
    public ResultData lists(FrontRequestParam frontRequestParam, Users tokenUser) {
        Map<String, Object> args = UtilTools.getArgs(frontRequestParam);


        int i = rolesMapper.countSize(args);
        if (i == 0) {
            return UtilParm.resultData(0, "暂无数据");
        }

        List<Roles> agRoles = rolesMapper.selectByPaging(args);


        return UtilTools.returnData(i, frontRequestParam, agRoles);
    }

}
