package com.cn.ag.data.dao.interf.qx;

import com.cn.ag.data.domain.sd.qx.ResourceType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
public interface ResourceTypeMapper {

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKey(ResourceType record);

    ResourceType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResourceType record);

    int insert(ResourceType record);

    int insertSelective(ResourceType record);

    int insertBatch(List<ResourceType> recordList);

    int countSize(Map<String, Object> map);

    List<ResourceType> selectByPaging(Map<String, Object> map);

    List<ResourceType> selectByPagingFromContinuous(Map<String, Object> map);

    int countSizeFromContinuous(Map<String, Object> map);
}
