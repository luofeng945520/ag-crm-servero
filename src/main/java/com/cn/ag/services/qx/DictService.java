package com.cn.ag.services.qx;

import com.cn.ag.data.domain.sd.qx.Dict;

import com.cn.ff.utils.comm.support.FrontRequestParam;
import com.cn.ff.utils.comm.support.ResultData;

import java.util.List;
import java.util.Map;

/**
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
public interface DictService {

    /**
     * 获取单个对象
     */
    Dict get(Long id);

    /**
     * 通过主键选择性修改
     */
    boolean modifyByPrimaryKeySelective(Dict dict);

    /**
     * 通过主键删除
     */
    boolean removeByPrimaryKey(Long id);

    /**
     * 获取多个对象
     */
    List<Dict> list(Map<String, Object> map);

    /**
     * 添加单个
     */
    boolean add(Dict dict);

    /**
     * 批量添加
     */
    boolean addBatch(List<Dict> dictList);

    /**
     * 获取结果
     */
    ResultData lists(FrontRequestParam frontRequestParam);
}
