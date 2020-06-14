package com.cn.ag.data.dao.impl;

import com.cn.ag.data.dao.MapperHelper;
import com.cn.ag.data.domain.sd.Resources;
import com.cn.ag.data.dao.interf.ResourcesMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


/**
 * @author milk
 * @Date 2020-06-14 16:52:25
 */
@Repository("resourcesMapperImpl")
public class ResourcesMapperImpl extends MapperHelper<Resources> implements ResourcesMapper {

    public int deleteByPrimaryKey(Long id) {
        return deleteHelper(id);
    }

    public int updateByPrimaryKey(Resources record) {
        return updateHelper(record);
    }

    public Resources selectByPrimaryKey(Long id) {
        return selectOneHelper(id);
    }

    public int updateByPrimaryKeySelective(Resources record) {
        return updateHelper(record);
    }

    public int insert(Resources record) {
        return insertHelper(record);
    }

    public int insertSelective(Resources record) {
        return insertHelper(record);
    }

    public int insertBatch(List<Resources> recordList) {
        return insertHelper(recordList);
    }

    public int countSize(Map<String, Object> map) {
        return countHelper(map);
    }

    public List<Resources> selectByPaging(Map<String, Object> map) {
        return selectListHelper(map);
    }

    public List<Resources> selectByPagingFromContinuous(Map<String, Object> map) {
        return selectListHelper(map);
    }

    public int countSizeFromContinuous(Map<String, Object> map) {
        return countHelper(map);
    }

}
