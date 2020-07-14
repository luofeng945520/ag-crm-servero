package com.cn.ag.data.dao.impl.qx;

import com.cn.ag.data.dao.MapperHelper;
import com.cn.ag.data.domain.sd.qx.ResourceType;
import com.cn.ag.data.dao.interf.qx.ResourceTypeMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


/**
 * @author milk
 * @Date 2020-07-14 21:06:07
 */
@Repository("resourceTypeMapperImpl")
public class ResourceTypeMapperImpl extends MapperHelper<ResourceType> implements ResourceTypeMapper {

    public int deleteByPrimaryKey(Integer id) {
        return deleteHelper(id);
    }

    public int updateByPrimaryKey(ResourceType record) {
        return updateHelper(record);
    }

    public ResourceType selectByPrimaryKey(Integer id) {
        return selectOneHelper(id);
    }

    public int updateByPrimaryKeySelective(ResourceType record) {
        return updateHelper(record);
    }

    public int insert(ResourceType record) {
        return insertHelper(record);
    }

    public int insertSelective(ResourceType record) {
        return insertHelper(record);
    }

    public int insertBatch(List<ResourceType> recordList) {
        return insertHelper(recordList);
    }

    public int countSize(Map<String, Object> map) {
        return countHelper(map);
    }

    public List<ResourceType> selectByPaging(Map<String, Object> map) {
        return selectListHelper(map);
    }

    public List<ResourceType> selectByPagingFromContinuous(Map<String, Object> map) {
        return selectListHelper(map);
    }

    public int countSizeFromContinuous(Map<String, Object> map) {
        return countHelper(map);
    }

}
