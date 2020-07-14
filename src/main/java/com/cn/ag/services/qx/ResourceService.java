package com.cn.ag.services.qx;

import com.cn.ag.data.domain.sd.qx.Resource;

import com.cn.ff.utils.comm.support.FrontRequestParam;
import com.cn.ff.utils.comm.support.ResultData;

import java.util.List;
import java.util.Map;

/**
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
public interface ResourceService {

    /**
     * 获取单个对象
     */
    Resource get(Long id);

    /**
     * 通过主键选择性修改
     */
    boolean modifyByPrimaryKeySelective(Resource resource);

    /**
     * 通过主键删除
     */
    boolean removeByPrimaryKey(Long id);

    /**
     * 获取多个对象
     */
    List<Resource> list(Map<String, Object> map);

    /**
     * 添加单个
     */
    boolean add(Resource resource);

    /**
     * 批量添加
     */
    boolean addBatch(List<Resource> resourceList);

    /**
     * 获取结果
     */
    ResultData lists(FrontRequestParam frontRequestParam);
}
