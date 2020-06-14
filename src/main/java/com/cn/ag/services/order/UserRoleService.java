package com.cn.ag.services.order;

import com.cn.ag.data.domain.sd.UserRole;

import com.cn.ff.utils.comm.support.FrontRequestParam;
import com.cn.ff.utils.comm.support.ResultData;

import java.util.List;
import java.util.Map;

/**
 * @author milk
 * @Date 2020-06-14 16:52:26
 */
public interface UserRoleService {


    /**
     * 获取多个对象
     */
    List<UserRole> list(Map<String, Object> map);

    /**
     * 添加单个
     */
    boolean add(UserRole userRole);

    /**
     * 批量添加
     */
    boolean addBatch(List<UserRole> userRoleList);

    /**
     * 获取结果
     */
    ResultData lists(FrontRequestParam frontRequestParam);
}
