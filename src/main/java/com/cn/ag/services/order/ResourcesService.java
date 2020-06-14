package com.cn.ag.services.order;

import com.cn.ag.data.domain.sd.Resources;

import com.cn.ff.utils.comm.support.FrontRequestParam;
import com.cn.ff.utils.comm.support.ResultData;

import java.util.List;
import java.util.Map;

/**
 * @author milk
 * @Date 2020-06-14 16:52:25
 */
public interface ResourcesService {

    /**
     * 获取单个对象
     */
    Resources get(Long id);

    /**
     * 通过主键选择性修改
     */
    boolean modifyByPrimaryKeySelective(Resources resources);

    /**
     * 通过主键删除
     */
    boolean removeByPrimaryKey(Long id);

    /**
     * 获取多个对象
     */
    List<Resources> list(Map<String, Object> map);

    /**
     * 添加单个
     */
    boolean add(Resources resources);

    /**
     * 批量添加
     */
    boolean addBatch(List<Resources> resourcesList);

    /**
     * 获取结果
     */
    ResultData lists(FrontRequestParam frontRequestParam);
}
