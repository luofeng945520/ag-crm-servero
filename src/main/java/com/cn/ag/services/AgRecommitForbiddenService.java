package com.cn.ag.services;

import com.cn.ag.data.domain.sd.AgRecommitForbidden;
import com.cn.ag.exception.DeleteFailedException;
import com.cn.ag.exception.UpdateFailedException;

import java.util.List;
import java.util.Map;

/**
 * @ClassName AgRecommitForbiddenService
 * @Description: TODO 禁止重复提交service层
 * @Author Amber
 * @Date 2019/11/25 14:50
 * @Version 1.0
 */
public interface AgRecommitForbiddenService extends BaseService<AgRecommitForbidden>{
    AgRecommitForbidden get(String id);

    List<AgRecommitForbidden> list(Map<String, Object> map);

    /**
     * 统计条数
     */
    int statisticalNumber(Map<String, Object> map);

    /**
     * 添加单个
     */
    boolean add(AgRecommitForbidden t) throws Exception;

    /**
     * 批量添加
     */
    boolean batchAdd(List<AgRecommitForbidden> list) throws Exception;

    /**
     * 通过主键选择性修改
     */
    boolean modifyByPrimaryKeySelective(AgRecommitForbidden t) throws UpdateFailedException;

    /**
     * 通过主键删除
     */
    boolean removeByPrimaryKey(AgRecommitForbidden t) throws DeleteFailedException;

}
