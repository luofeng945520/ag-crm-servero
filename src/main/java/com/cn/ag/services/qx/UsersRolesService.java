package com.cn.ag.services.qx;

import com.cn.ag.data.domain.sd.qx.UsersRoles;

import com.cn.ff.utils.comm.support.FrontRequestParam;
import com.cn.ff.utils.comm.support.ResultData;

import java.util.List;
import java.util.Map;

/**
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
public interface UsersRolesService {

    /**
     * 获取单个对象
     */
    UsersRoles get(Long id);

    /**
     * 通过主键选择性修改
     */
    boolean modifyByPrimaryKeySelective(UsersRoles usersRoles);

    /**
     * 通过主键删除
     */
    boolean removeByPrimaryKey(Long id);

    /**
     * 获取多个对象
     */
    List<UsersRoles> list(Map<String, Object> map);

    /**
     * 添加单个
     */
    boolean add(UsersRoles usersRoles);

    /**
     * 批量添加
     */
    boolean addBatch(List<UsersRoles> usersRolesList);

    /**
     * 获取结果
     */
    ResultData lists(FrontRequestParam frontRequestParam);
}
