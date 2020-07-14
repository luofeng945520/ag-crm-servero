package com.cn.ag.services.qx.impl;

import com.cn.ag.data.domain.sd.qx.UsersRoles;
import com.cn.ag.data.dao.interf.qx.UsersRolesMapper;
import com.cn.ag.services.qx.UsersRolesService;
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
@Service("usersRolesServiceImpl")
public class UsersRolesServiceImpl implements UsersRolesService {

    @Autowired
    @Qualifier("usersRolesMapperImpl")
    private UsersRolesMapper usersRolesMapper;


    /**
     * 获取单个对象
     */
    public UsersRoles get(Long id) {
        return usersRolesMapper.selectByPrimaryKey(id);
    }

    /**
     * 通过主键选择性修改
     */
    public boolean modifyByPrimaryKeySelective(UsersRoles usersRoles) {
        return usersRolesMapper.updateByPrimaryKeySelective(usersRoles) > 0;
    }

    /**
     * 通过主键删除
     */
    public boolean removeByPrimaryKey(Long id) {
        return usersRolesMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * 获取多个对象
     */
    public List<UsersRoles> list(Map<String, Object> map) {
        return usersRolesMapper.selectByPaging(map);
    }

    /**
     * 添加单个
     */
    public boolean add(UsersRoles usersRoles) {
        return usersRolesMapper.insertSelective(usersRoles) > 0;
    }

    /**
     * 批量添加
     */
    public boolean addBatch(List<UsersRoles> usersRolesList) {
        //一次全部插入 若是数据过多 需要重写
        return usersRolesMapper.insertBatch(usersRolesList) > 0;
    }

    /**
     * 获取结果
     */
    public ResultData lists(FrontRequestParam frontRequestParam) {
        return null;
    }

}
