package com.cn.ag.services.qx;

import com.cn.ag.data.domain.sd.qx.RoleResource;

import com.cn.ff.utils.comm.support.FrontRequestParam;
import com.cn.ff.utils.comm.support.ResultData;

import java.util.List;
import java.util.Map;

/**
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
public interface RoleResourceService {


    /**
     * 获取多个对象
     */
    List<RoleResource> list(Map<String, Object> map);

    /**
     * 添加单个
     */
    boolean add(RoleResource roleResource);

    /**
     * 批量添加
     */
    boolean addBatch(List<RoleResource> roleResourceList);

    /**
     * 获取结果
     */
    ResultData lists(FrontRequestParam frontRequestParam);
}
