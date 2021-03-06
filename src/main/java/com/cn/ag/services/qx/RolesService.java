package com.cn.ag.services.qx;

import com.cn.ag.data.domain.sd.qx.Roles;

import com.cn.ag.data.domain.sd.qx.Users;
import com.cn.ff.utils.comm.support.FrontRequestParam;
import com.cn.ff.utils.comm.support.ResultData;

import java.util.List;
import java.util.Map;

/**
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
public interface RolesService {

    /**
     * 获取单个对象
     */
    Roles get(Long id);

    /**
     * 通过主键选择性修改
     */
    boolean modifyByPrimaryKeySelective(Roles roles);

    /**
     * 通过主键删除
     */
    boolean removeByPrimaryKey(Long id);

    /**
     * 获取多个对象
     */
    List<Roles> list(Map<String, Object> map);

    /**
     * 添加单个
     */
    boolean add(Roles roles);

    /**
     * 批量添加
     */
    boolean addBatch(List<Roles> rolesList);

    /**
     * 获取结果
     */
    ResultData lists(FrontRequestParam frontRequestParamd, Users tokenUser);
}
